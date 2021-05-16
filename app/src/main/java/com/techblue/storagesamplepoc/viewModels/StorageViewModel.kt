package com.techblue.storagesamplepoc.viewModels

import android.app.Application
import android.content.ContentUris
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.techblue.storagesamplepoc.dateToTimestamp
import com.techblue.storagesamplepoc.models.ImageItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class StorageViewModel(application: Application) : AndroidViewModel(application) {


    private val TAG = this::class.java.simpleName

    private val _images = MutableLiveData<List<ImageItem>>()
    val images: LiveData<List<ImageItem>> = _images

    private val _sampleMutableLiveData = MutableLiveData<String>()
    val sampleLiveData: LiveData<String> = _sampleMutableLiveData

    init {
        Log.d(TAG, "StorageViewModel initiated")
    }

    fun getAllImages() {
        val allImages = mutableListOf<ImageItem>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val projection = arrayOf(
                    MediaStore.Images.Media._ID,
                    MediaStore.Images.Media.DISPLAY_NAME,
                    MediaStore.Images.Media.DATE_TAKEN,
                )

                val selection = "${MediaStore.Images.Media.DATE_TAKEN} >= ?"

                val selectionArgs = arrayOf(
                    dateToTimestamp(day = 10, month = 8, year = 1994).toString()
                )

                val sortOrder = "${MediaStore.Images.Media.DATE_TAKEN} DESC"

                getApplication<Application>().contentResolver.query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    selection,
                    selectionArgs,
                    sortOrder
                )?.use { cursor ->

                    val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                    val dateTakenColumn =
                        cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN)
                    val displayNameColumn =
                        cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)

                    while (cursor.moveToNext()) {
                        // Here we'll use the column indexs that we found above.
                        val id = cursor.getLong(idColumn)
                        val dateTaken = Date(cursor.getLong(dateTakenColumn))
                        val displayName = cursor.getString(displayNameColumn)

                        /**
                         * This is one of the trickiest parts:
                         *
                         * Since we're accessing images (using
                         * [MediaStore.Images.Media.EXTERNAL_CONTENT_URI], we'll use that
                         * as the base URI and append the ID of the image to it.
                         *
                         * This is the exact same way to do it when working with [MediaStore.Video] and
                         * [MediaStore.Audio] as well. Whatever `Media.EXTERNAL_CONTENT_URI` you
                         * query to get the items is the base, and the ID is the document to
                         * request there.
                         */
                        val contentUri = ContentUris.withAppendedId(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            id
                        )

                        Log.i(TAG, "getAllImages: $id---$dateTaken---$displayName")

                        allImages.add(ImageItem(id, displayName, dateTaken, contentUri))
                    }

                    _images.postValue(allImages)
                }
            }
        }
    }

    fun postDataUsingSetValue() {
        _sampleMutableLiveData.setValue("one")
        _sampleMutableLiveData.setValue("two")
        _sampleMutableLiveData.setValue("three")
    }

    fun postDataUsingPostValue() {
        viewModelScope.launch(Dispatchers.Main) {
//            _sampleMutableLiveData.value = "one"
            _sampleMutableLiveData.postValue("two")
            _sampleMutableLiveData.postValue("three")
        }
    }
}