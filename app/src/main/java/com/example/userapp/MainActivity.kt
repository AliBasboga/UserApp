package com.example.userapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.userapp.screens.UserList
import com.example.userapp.ui.theme.UserAppTheme
import com.example.userapp.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UserAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        // Kullanıcıları almak için viewModel.getUsers() fonksiyonunu başlat
                        LaunchedEffect(Unit) {
                            viewModel.getUsers()
                        }

                        // StateFlow'u collectAsState ile kullanıyoruz
                        val userList = viewModel.userList.collectAsState().value

                        if (userList.isEmpty()) {
                            // Kullanıcılar gelmediyse yükleme animasyonu göster
                            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
                        } else {
                            // Kullanıcı listesi yüklendiyse, listeyi göster
                            UserList(userList = userList)
                        }
                    }
                }
            }
        }
    }
}

