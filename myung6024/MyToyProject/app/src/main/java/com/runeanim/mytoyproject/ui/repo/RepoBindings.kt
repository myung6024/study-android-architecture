package com.runeanim.mytoyproject.ui.repo

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.runeanim.mytoyproject.data.model.Contribute
import com.runeanim.mytoyproject.data.source.local.entity.RepositoryEntity
import com.runeanim.mytoyproject.ui.main.ContributeAdapter
import com.runeanim.mytoyproject.ui.repo.RepoListAdapter

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<RepositoryEntity>) {
    (listView.adapter as RepoListAdapter).submitList(items)
}

@BindingAdapter("app:items")
fun setContributeItems(listView: RecyclerView, items: List<Contribute>) {
    (listView.adapter as ContributeAdapter).submitList(items)
}

@BindingAdapter("app:userImage")
fun setUserImage(imageView: ImageView, path: String) {
    Glide.with(imageView.context)
        .load(path)
        .into(imageView)
}

@BindingAdapter("app:pbText")
fun TextView.setProgressText(@StringRes stringRes: Int?) {
    if (stringRes != null) {
        visibility = View.VISIBLE
        setText(stringRes)
    } else {
        visibility = View.GONE
    }
}

@BindingAdapter("app:contributeColor")
fun View.setContributeColor(hexColor: String) {
    setBackgroundColor(Color.parseColor(hexColor))
}