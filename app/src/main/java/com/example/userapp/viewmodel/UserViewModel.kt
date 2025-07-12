package com.example.userapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.model.User
import com.example.userapp.service.UserAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response

class UserViewModel : ViewModel() {

    private val BASE_URL = "https://raw.githubusercontent.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    // StateFlow kullanıyoruz
    private val _userList = MutableStateFlow<List<User>>(emptyList())
    val userList: StateFlow<List<User>> = _userList

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // API çağrısı yapılır ve yanıt alınır
                val response: Response<List<User>> = retrofit.getData()

                // Yanıt başarılı ise, response.body()'yu alıp StateFlow'u güncelle
                if (response.isSuccessful && response.body() != null) {
                    _userList.value = response.body() ?: emptyList()
                } else {
                    // Başarısız yanıt durumunda hata mesajı yazdır
                    println("Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Eğer API çağrısı sırasında bir hata oluşursa burada yakalayabilirsiniz
                e.printStackTrace()
            }
        }
    }
}
