package com.tharik.androidkt.repository

import com.tharik.androidkt.model.TodoItem
import com.tharik.androidkt.network.ApiService
import com.tharik.androidkt.network.ApiState
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun getAllTodos(): ApiState<List<TodoItem>> = try {
        ApiState.Success(apiService.getAllTodoItems())
    } catch (e: Exception) {
        ApiState.Error(errorMsg = e.message.toString())
    }

    override suspend fun getTodoDetails(todoItemId : Int): ApiState<TodoItem> = try {
        ApiState.Success(apiService.getTodoItem(todoItemId))
    } catch (e: Exception) {
        ApiState.Error(errorMsg = e.message.toString())
    }
}