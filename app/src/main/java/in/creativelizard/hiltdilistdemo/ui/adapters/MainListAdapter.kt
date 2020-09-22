package `in`.creativelizard.hiltdilistdemo.ui.adapters

import `in`.creativelizard.hiltdilistdemo.R
import `in`.creativelizard.hiltdilistdemo.models.RepositoriesModel
import `in`.creativelizard.hiltdilistdemo.ui.utils.DiffUtilRepositoriesModelItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_user_repositories.view.*

class MainListAdapter : ListAdapter<RepositoriesModel.RepositorysModelItem, RepositoriesViewHolder>(
DiffUtilRepositoriesModelItem()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user_repositories, parent, false)
        return RepositoriesViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: RepositoriesModel.RepositorysModelItem?) {
        val owner = item?.owner
        //itemView.image_view_owner?.loadImageFromUrl(owner?.avatarUrl)
        itemView.text_view_owner_name.text = item?.fullName?.substringBefore(delimiter = "/")
      //  itemView.text_view_repository_name.hideIfEmptyText(item?.name)
        itemView.text_view_repository_description.text = (item?.description)
    }
}