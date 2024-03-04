package dev.dr10.test.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.dr10.test.domain.repository.MainRepository
import dev.dr10.test.domain.utilities.handleResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    private val _categories: MutableLiveData<List<String>> = MutableLiveData(emptyList())
    val categories: LiveData<List<String>> = _categories


    init {
        viewModelScope.launch {
            repository.getCategories().handleResult(
                onSuccess = {
                     _categories.value = it
                },
                onError = {
                    // Display error message
                }
            )
        }
    }


}