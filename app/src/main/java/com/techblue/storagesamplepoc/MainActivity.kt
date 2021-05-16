package com.techblue.storagesamplepoc

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.techblue.storagesamplepoc.adapters.GalleryAdapter
import com.techblue.storagesamplepoc.databinding.ActivityMainBinding
import com.techblue.storagesamplepoc.models.ImageItem
import com.techblue.storagesamplepoc.viewModels.StorageViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    private val storageViewModel: StorageViewModel by viewModels<StorageViewModel>()
    private val galleryAdapter = GalleryAdapter(mutableListOf<ImageItem>(), 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setFullScreen()

//        storageViewModel.getAllImages()

        val listMAnager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        activityMainBinding.galleryList.apply {
            listMAnager.gapStrategy =
                StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
//            setHasFixedSize(true)
            layoutManager = listMAnager
            adapter = galleryAdapter
        }

        storageViewModel.images.observe(this, {
            it?.let {
                galleryAdapter.setData(it.toMutableList(), resources.displayMetrics.widthPixels)
            }
        })



        storageViewModel.postDataUsingPostValue()
//        storageViewModel.sampleLiveData.observe(this, {
//            it?.let {
//                Log.e("setValue", it)
//            }
//        })

        GlobalScope.launch {
            delay(5000)
            Log.e("setValue", storageViewModel.sampleLiveData.value ?:"")
        }
    }

    @Suppress("DEPRECATION")
    private fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            // finally, show the system bars
            window.insetsController?.show(WindowInsets.Type.systemBars())
//            window.insetsController?.show(WindowInsets.Type.ime())
//            window.insetsController?.show(WindowInsets.Type.statusBars())
//            window.insetsController?.show(WindowInsets.Type.navigationBars())
        } else {
            activityMainBinding.mainRootLayout.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        }
    }
}