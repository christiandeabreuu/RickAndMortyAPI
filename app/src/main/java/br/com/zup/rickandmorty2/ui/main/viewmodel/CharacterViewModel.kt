package br.com.zup.rickandmorty2.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.rickandmorty2.data.model.CharacterResult
import br.com.zup.rickandmorty2.data.remote.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel : ViewModel() {
    private val _characterResponse = MutableLiveData<List<CharacterResult>>()
    val characterResponse: LiveData<List<CharacterResult>> = _characterResponse

    fun getAllCharacter() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitService.apiService.getAllCharactersNetwork()
                }
                _characterResponse.value = response.results
            } catch (ex: Exception) {
                Log.i("Error", "${ex.message}")
            }
        }
    }
}