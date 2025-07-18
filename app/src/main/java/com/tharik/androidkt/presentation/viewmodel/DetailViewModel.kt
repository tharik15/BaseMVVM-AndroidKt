package com.tharik.androidkt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tharik.androidkt.model.TodoItem
import com.tharik.androidkt.network.ApiState
import com.tharik.androidkt.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<DetailUiState> =
        MutableStateFlow(DetailUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun fetchTodo(todoItemId : Int) {
        viewModelScope.launch {
            _uiState.update {
                when (val result = repository.getTodoDetails(todoItemId)) {
                    is ApiState.Success -> DetailUiState.Success(result.data)
                    is ApiState.Error -> DetailUiState.Error(result.errorMsg)
                    ApiState.Loading -> DetailUiState.Loading
                }
            }
        }
    }
}

sealed class DetailUiState {
    data class Success(val todoItem: TodoItem) : DetailUiState()
    data class Error(val message: String) : DetailUiState()
    data object Loading : DetailUiState()
}