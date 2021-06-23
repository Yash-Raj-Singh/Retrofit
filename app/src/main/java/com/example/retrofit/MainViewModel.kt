package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Respository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3 : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse4 : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getCountryDetail(){
        viewModelScope.launch {
            val response: Response<Post> = repository.getCountryDetail()
            myResponse.value = response
        }
    }

    fun getCountryDetail2(number : Int){
        viewModelScope.launch {
            val response: Response<Post> = repository.getCountryDetail2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPost(userId : Int, sort :String , order : String){
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getCustomPost(userId, sort, order)
            myResponse3.value = response
        }
    }

    fun getCustomPost2(userId : Int, options : Map<String, String>){
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getCustomPost2(userId, options)
            myResponse4.value = response
        }
    }

}