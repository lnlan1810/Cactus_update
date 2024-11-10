package com.example.android.cactus.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.android.cactus.data.database.dao.CategoryDao
import com.example.android.cactus.data.database.entities.CategoryDb
import com.example.android.cactus.data.database.entities.toDomainModel
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.toDatabaseModel

class CategoryRepository(private val dao: CategoryDao) {

    val categories: LiveData<List<Category>> = dao.getAllCategories().map { categoryList ->
        categoryList.toDomainModel()
    }

    suspend fun getCategories(): LiveData<List<CategoryDb>> =
        dao.getAllCategories()

    fun addCategory(category: CategoryDb) =
        dao.addCategory(category)

    fun updateCategory(category: Category) =
        dao.updateCategory(category.toDatabaseModel())

    fun deleteCategory(category: Category) =
        dao.deleteCategory(category.toDatabaseModel())

    fun searchDatabase(searchQuery: String): LiveData<List<CategoryDb>> =
        dao.searchDatabase(searchQuery)
}