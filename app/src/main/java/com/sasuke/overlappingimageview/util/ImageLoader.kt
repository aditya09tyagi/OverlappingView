package com.sasuke.overlappingimageview.util

import android.content.Context
import android.net.Uri
import android.widget.LinearLayout
import com.sasuke.overlappingimageview.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.util.*

class ImageLoader(private val mItemWidth: Int, private val mItemHeight: Int, private val mItemBorderWidth: Int, private val mMaxItemCount: Int, private val mOffset: Float, private val mBorderColor: Int, private val mContext: Context?, private val mParentLayout: LinearLayout) {
    fun setThumbnailUrl(imageUrlList: ArrayList<String?>?, removeOnSwipe: Boolean) {
        if (imageUrlList != null && mContext != null) {
            for (i in imageUrlList.indices) {
                val layoutParams = LinearLayout.LayoutParams(mItemWidth, mItemHeight)
                if (i > 0) {
                    layoutParams.setMargins(Math.round(mItemWidth * mOffset) * -1, 0, 0, 0)
                }
                val circleImageView = CircleImageView(mContext)
                circleImageView.borderWidth = mItemBorderWidth
                circleImageView.borderColor = mBorderColor
                circleImageView.layoutParams = layoutParams
                val url = imageUrlList[i]
                if (i <= mMaxItemCount) {
                    Picasso.get().load(url).placeholder(R.drawable.ic_launcher_background).into(circleImageView)
                    mParentLayout.addView(circleImageView)
                    if (removeOnSwipe) circleImageView.setOnTouchListener(OnSwipeTouchListener(mContext, mItemWidth))
                }
            }
        }
    }

    fun setThumbnailDrawableRes(imageDrawableResList: ArrayList<Int?>?, removeOnSwipe: Boolean) {
        if (imageDrawableResList != null && mContext != null) {
            for (i in imageDrawableResList.indices) {
                val layoutParams = LinearLayout.LayoutParams(mItemWidth, mItemHeight)
                if (i > 0) {
                    layoutParams.setMargins(Math.round(mItemWidth * mOffset) * -1, 0, 0, 0)
                }
                val circleImageView = CircleImageView(mContext)
                circleImageView.borderWidth = mItemBorderWidth
                circleImageView.borderColor = mBorderColor
                circleImageView.layoutParams = layoutParams
                if (i <= mMaxItemCount) {
                    Picasso.get().load(imageDrawableResList[i]!!).placeholder(R.drawable.ic_launcher_background).into(circleImageView)
                    mParentLayout.addView(circleImageView)
                    if (removeOnSwipe) circleImageView.setOnTouchListener(OnSwipeTouchListener(mContext, mItemWidth))
                }
            }
        }
    }

    fun setThumbnailFile(imageFileList: ArrayList<File?>?, removeOnSwipe: Boolean) {
        if (imageFileList != null && mContext != null) {
            for (i in imageFileList.indices) {
                val layoutParams = LinearLayout.LayoutParams(mItemWidth, mItemHeight)
                if (i > 0) {
                    layoutParams.setMargins(Math.round(mItemWidth * mOffset) * -1, 0, 0, 0)
                }
                val circleImageView = CircleImageView(mContext)
                circleImageView.borderWidth = mItemBorderWidth
                circleImageView.borderColor = mBorderColor
                circleImageView.layoutParams = layoutParams
                if (i <= mMaxItemCount) {
                    if (imageFileList[i] != null) {
                        Picasso.get().load(imageFileList[i]!!).placeholder(R.drawable.ic_launcher_background).into(circleImageView)
                        mParentLayout.addView(circleImageView)
                        if (removeOnSwipe) circleImageView.setOnTouchListener(OnSwipeTouchListener(mContext, mItemWidth))
                    }
                }
            }
        }
    }

    fun setThumbnailUri(imageFileList: ArrayList<Uri?>?, removeOnSwipe: Boolean) {
        if (imageFileList != null && mContext != null) {
            for (i in imageFileList.indices) {
                val layoutParams = LinearLayout.LayoutParams(mItemWidth, mItemHeight)
                if (i > 0) {
                    layoutParams.setMargins(Math.round(mItemWidth * mOffset) * -1, 0, 0, 0)
                }
                val circleImageView = CircleImageView(mContext)
                circleImageView.borderWidth = mItemBorderWidth
                circleImageView.borderColor = mBorderColor
                circleImageView.layoutParams = layoutParams
                if (i <= mMaxItemCount) {
                    if (imageFileList[i] != null) {
                        Picasso.get().load(imageFileList[i]).placeholder(R.drawable.ic_launcher_background).into(circleImageView)
                        mParentLayout.addView(circleImageView)
                        if (removeOnSwipe) circleImageView.setOnTouchListener(OnSwipeTouchListener(mContext, mItemWidth))
                    }
                }
            }
        }
    }
}