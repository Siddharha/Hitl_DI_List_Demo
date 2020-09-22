package `in`.creativelizard.hiltdilistdemo.ui.utils

import `in`.creativelizard.hiltdilistdemo.models.RepositoriesModel
import androidx.recyclerview.widget.DiffUtil

class DiffUtilRepositoriesModelItem : DiffUtil.ItemCallback<RepositoriesModel.RepositorysModelItem>() {
    override fun areItemsTheSame(
        oldItem: RepositoriesModel.RepositorysModelItem,
        newItem: RepositoriesModel.RepositorysModelItem
    ): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(
        oldItem: RepositoriesModel.RepositorysModelItem,
        newItem: RepositoriesModel.RepositorysModelItem
    ): Boolean {
        return newItem == oldItem
    }
}