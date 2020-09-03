package com.sasuke.overlappingimageview.util

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.LinearLayout

class OnSwipeTouchListener(ctx: Context?, private val mItemWidth: Int) : OnTouchListener {
    private val gestureDetector: GestureDetector
    private var mView: View? = null
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        mView = view
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            var result = false
            try {
                val diffY = e2.y - e1.y
                if (Math.abs(diffY) > Companion.SWIPE_THRESHOLD && Math.abs(velocityY) > Companion.SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        mView!!.animate()
                                .y(e2.rawY + mItemWidth)
                                .alpha(Companion.ALPHA)
                                .setDuration(Companion.AMINATION_DURATION.toLong())
                                .withEndAction {
                                    val linearLayout = mView!!.parent as LinearLayout
                                    linearLayout.removeView(mView)
                                    linearLayout.invalidate()
                                }
                                .start()
                    } else {
                        mView!!.animate()
                                .y(mItemWidth - e2.rawY)
                                .alpha(Companion.ALPHA)
                                .setDuration(Companion.AMINATION_DURATION.toLong())
                                .withEndAction {
                                    val linearLayout = mView!!.parent as LinearLayout
                                    linearLayout.removeView(mView)
                                    linearLayout.invalidate()
                                }
                                .start()
                    }
                    result = true
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return result
        }

    }

    companion object {
        private const val SWIPE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
        private const val AMINATION_DURATION = 300
        private const val ALPHA = 0.0f
    }

    init {
        gestureDetector = GestureDetector(ctx, GestureListener())
    }
}