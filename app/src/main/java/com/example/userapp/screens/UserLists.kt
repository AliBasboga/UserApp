package com.example.userapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.userapp.model.User

@Composable
fun UserList(userList : List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ){
       items(userList) {
          UserRow(user = it)
       }
    }
}

@Composable
fun UserRow(user: User) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(6.dp, shape = RoundedCornerShape(12.dp)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column {
                Text(text = user.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(3.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(text = "Web Site: " + user.website,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Normal
                )

                Text(text = "Phone: " + user.phone,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun UserPreview() {
    UserAppTheme {
        UserList(listOf(
            User(
                1,
                "Ali Başboğa",
                "Ali45_xp",
                "Alibsbg47@gmail.com",
                Address (
                    "Merkez",
                    "YunusEmre",
                    "Manisa",
                    "45065",
                    Geo(
                        "17",
                        "04"
                    )
                ),
                "+90545455455",
                "website.com",
                Company(
                    "AliŞirketi",
                    "AliŞirketils",
                    "AliŞirketibölgesi"
                )
            )
        ))
    }
}
 */