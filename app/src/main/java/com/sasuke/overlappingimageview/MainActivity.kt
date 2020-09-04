package com.sasuke.overlappingimageview

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity() {

    var overlappingImageView: OverlappingImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        overlappingImageView = findViewById<View>(R.id.overlappingImageView) as OverlappingImageView
        overlappingImageView!!.setThumbnailUrl(dummyUrls, false)
    }

    private val dummyUrls: ArrayList<String?>
        get() {
            val list = ArrayList<String?>()
            list.add("https://recommenderdb.000webhostapp.com/images/action.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/horror.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/romantic.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/scifi.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/mystery.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/action.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/horror.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/romantic.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/scifi.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/mystery.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/action.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/horror.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/romantic.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/scifi.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/mystery.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/action.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/horror.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/romantic.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/scifi.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/mystery.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/action.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/horror.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/romantic.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/scifi.jpg")
            list.add("https://recommenderdb.000webhostapp.com/images/mystery.jpg")
            return list
        }
    private val dummyDrawableRes: ArrayList<Int>
        get() {
            val list = ArrayList<Int>()
            list.add(R.drawable.ic_launcher_background)
            list.add(R.drawable.ic_launcher_background)
            list.add(R.drawable.ic_launcher_background)
            list.add(R.drawable.ic_launcher_background)
            list.add(R.drawable.ic_launcher_background)
            return list
        }
    private val dummyFiles: ArrayList<File>
        get() {
            val list = ArrayList<File>()
            val file = File(Environment.getExternalStorageDirectory().toString() + File.separator + "yet.jpg")
            if (file.exists()) {
                Toast.makeText(this, "EXISTS", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "NOT EXISTS", Toast.LENGTH_SHORT).show()
            list.add(file)
            list.add(file)
            list.add(file)
            list.add(file)
            list.add(file)
            list.add(file)
            list.add(file)
            return list
        }
}