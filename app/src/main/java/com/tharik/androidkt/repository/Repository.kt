package com.tharik.androidkt.repository

import com.tharik.androidkt.model.TodoItem
import com.tharik.androidkt.network.ApiState

interface Repository {
    suspend fun getAllTodos() : ApiState<List<TodoItem>>
    suspend fun getTodoDetails(todoItemId : Int) : ApiState<TodoItem>
}