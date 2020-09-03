package com.sasuke.overlappingimageview

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import com.sasuke.overlappingimageview.util.ImageLoader
import java.io.File
import java.util.*

class OverlappingImageView(context: Context, attrs: AttributeSet?) : HorizontalScrollView(context, attrs) {

    private var mItemWidth = 0
    private var mItemHeight = 0
    private var mItemBorderWidth = 0
    private var mMaxItemCount = 0
    private var mOffset = 0f
    private var mBorderColor = 0
    private var mLinearLayout: LinearLayout? = null
    private var mImageLoader: ImageLoader? = null
    private fun init(context: Context, attributeSet: AttributeSet?) {
        if (attributeSet != null) {
            val typedArray = context.theme.obtainStyledAttributes(attributeSet, R.styleable.OverlappingImageView, 0, 0)
            mItemWidth = Math.round(typedArray.getDimension(R.styleable.OverlappingImageView_itemWidth, DEFAULT_WIDTH))
            mItemHeight = Math.round(typedArray.getDimension(R.styleable.OverlappingImageView_itemHeight, DEFAULT_HEIGHT))
            mItemBorderWidth = Math.round(typedArray.getDimension(R.styleable.OverlappingImageView_itemBorderWidth, DEFAULT_BORDER_WIDTH))
            mBorderColor = typedArray.getColor(R.styleable.OverlappingImageView_itemBorderColor, DEFAULT_BORDER_COLOR)
            mMaxItemCount = typedArray.getInt(R.styleable.OverlappingImageView_maxItemCount, DEFAULT_MAX_ITEM_COUNT)
            mOffset = typedArray.getFloat(R.styleable.OverlappingImageView_offset, DEFAULT_OFFSET)
            typedArray.recycle()
        }
        isHorizontalScrollBarEnabled = false
        mLinearLayout = LinearLayout(context)
        mLinearLayout!!.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        mLinearLayout!!.orientation = LinearLayout.HORIZONTAL
        addView(mLinearLayout)
        mImageLoader = ImageLoader(mItemWidth, mItemHeight, mItemBorderWidth, mMaxItemCount, mOffset, mBorderColor, getContext(), mLinearLayout)
    }

    fun setThumbnailUrl(imageUrlList: ArrayList<String?>?, removeItemOnSwipe: Boolean) {
        mImageLoader!!.setThumbnailUrl(imageUrlList, removeItemOnSwipe)
    }

    fun setThumbnailDrawableRes(imageDrawableResList: ArrayList<Int?>?, removeItemOnSwipe: Boolean) {
        mImageLoader!!.setThumbnailDrawableRes(imageDrawableResList, removeItemOnSwipe)
    }

    fun setThumbnailFile(imageFileList: ArrayList<File?>?, removeItemOnSwipe: Boolean) {
        mImageLoader!!.setThumbnailFile(imageFileList, removeItemOnSwipe)
    }

    fun setThumbnailUri(imageUriList: ArrayList<Uri?>?, removeItemOnSwipe: Boolean) {
        mImageLoader!!.setThumbnailUri(imageUriList, removeItemOnSwipe)
    }

    companion object {
        private const val DEFAULT_WIDTH = 50f
        private const val DEFAULT_HEIGHT = 50f
        private const val DEFAULT_BORDER_WIDTH = 4f
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_MAX_ITEM_COUNT = 1000
        private const val DEFAULT_OFFSET = 0.5f
    }

    init {
        init(context, attrs)
    }
}