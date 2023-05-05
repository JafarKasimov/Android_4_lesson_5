package com.example.android_4_lesson_5.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson5.databinding.ItemRickAndMortyBinding
import com.example.android_4_lesson_5.extension.setImage
import com.example.android_4_lesson_5.models.CharacterLocationModel

class RickAndMortyAdapter() :
    ListAdapter<CharacterLocationModel, RickAndMortyAdapter.ViewHolder>(
        RickAndMortyDiffCallBack
    ) {

    inner class ViewHolder(private val binding: ItemRickAndMortyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CharacterLocationModel?) = with(binding) {
            itemPersonImg.setImage(item!!.character.image)
            itemNameTv.text = item.character.name
            itemDimensionTv.text = item.location.dimension
            itemTypeTv.text = item.location.type
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemRickAndMortyBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    object RickAndMortyDiffCallBack : DiffUtil.ItemCallback<CharacterLocationModel>() {
        override fun areItemsTheSame(
            oldItem: CharacterLocationModel,
            newItem: CharacterLocationModel
        ): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(
            oldItem: CharacterLocationModel,
            newItem: CharacterLocationModel,
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}