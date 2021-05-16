package com.techblue.storagesamplepoc.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techblue.storagesamplepoc.R
import com.techblue.storagesamplepoc.databinding.ImageItemLayoutBinding
import com.techblue.storagesamplepoc.models.ImageItem

class GalleryAdapter(val list: MutableList<ImageItem>, var widthPixels: Int) :
    RecyclerView.Adapter<GalleryAdapter.MyViewHolder>() {

    companion object {
        class GalleryDiffUtil(
            val newList: MutableList<ImageItem>,
            val oldList: MutableList<ImageItem>
        ) :
            DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return oldList.size
            }

            override fun getNewListSize(): Int {
                return newList.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].id == newList[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val (id, name) = oldList[oldItemPosition]
                val (id2, name2) = newList[oldItemPosition]

                return id == id2 && name == name2
            }

        }
    }

    class MyViewHolder(val imageItemLayoutBinding: ImageItemLayoutBinding) :
        RecyclerView.ViewHolder(imageItemLayoutBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val imageItemLayoutBinding: ImageItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.image_item_layout,
            parent,
            false
        )

        return MyViewHolder(imageItemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.imageItemLayoutBinding.imageItem.setImageURI(list[position].uri)


        Glide.with(holder.imageItemLayoutBinding.imageItem)
            .load(list[position].uri)
            .into(holder.imageItemLayoutBinding.imageItem)

        holder.imageItemLayoutBinding.imageItem.layoutParams.width = widthPixels / 2

        holder.imageItemLayoutBinding.imageItem.layoutParams.height =
            Math.random().toInt() * 100

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: MutableList<ImageItem>, widthPixels: Int) {

        this.widthPixels = widthPixels

        val diffCallback = GalleryDiffUtil(newList, list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}