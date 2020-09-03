# OverlappingImageView

Circular Image Views that overlap over one another. <br />

![Scrollable Coins](https://github.com/aditya09tyagi/OverlappingView/blob/master/video2gif_20180524_231352%5B1%5D.gif)
<br />
<br />
<b>To add in your .xml file : </b>

```
<com.sasuke.overlappingimageview.OverlappingImageView
        android:id="@+id/oiv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" <br />
        app:itemBorderColor="@color/colorPrimaryDark"
        app:itemBorderWidth="4dp"
        app:itemHeight="200dp"
        app:itemWidth="200dp"
        app:maxItemCount="20"
        app:offset="0.5" />
 ```

<b>Attributes</b> <br />

 *  itemBorderColor -> Border color of circular image view <br />
 *  itemBorderWidth -> Border width of circular image view <br />
 *  itemHeight -> Height of circular image view <br />
 *  itemWidth -> Width of circular image view <br />
 *  maxItemCount -> Maximum number of items <br />
 *  offset -> Overlapping ratio <br />

You can set it's weight between 0 to 1. <br />

   - if (offset == 1) -> All the items will completely overlap over each other <br />
   - if (offset == 0.5) -> All the items will overlap by 50% of the width (just like the above image) <br />
   - if (offset == 0) -> All the items will arrange side by side <br />
   similarly you can play with the offset value according to your need. <br />

<b>How to Load Images</b> <br />

You can use any of the following functions to load the image: <br />

<h4>1. To load the images from url use:</h4>
   <h5>setThumbnailUrl(ArrayList<String> imageUrlList, boolean removeItemOnSwipe)</h5>       
        <em>//If you want to enable item remove functionality on swipe :: set removeItemOnSwipe = true </em>
        

<b>NOTE</b> -> ( THIS LIBRARY USE PICASSO INTERNALLY TO LOAD IMAGES SO DON'T FORGET TO ADD THE DEPENDENCY -> implementation 'com.squareup.picasso:picasso:2.71828' ) 

<h4>2. To load the images from drawable use:</h4>
   <h5>setThumbnailDrawableRes(ArrayList<Integer> imageDrawableResList, boolean removeItemOnSwipe)</h5>

<h4>3. To laod the images from file use:</h4>
   <h5>setThumbnailFile(ArrayList<File> imageFileList, boolean removeItemOnSwipe) </h5>

NOTE -> ( DON'T FORGET TO ADD READ_INTERNAL_STORAGE PERMISSION)

<h4>4. To load the images from Uri use:</h4>
   <h5>setThumbnailUri(ArrayList<Uri> imageUriList, boolean removeItemOnSwipe) </h5><br />
ENJOY :)
