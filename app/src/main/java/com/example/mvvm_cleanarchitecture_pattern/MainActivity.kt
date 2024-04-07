package com.example.mvvm_cleanarchitecture_pattern
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm_cleanarchitecture_pattern.domain.model.Post
import com.example.mvvm_cleanarchitecture_pattern.viewmodel.PostListViewModel
import dagger.hilt.android.AndroidEntryPoint

import androidx.compose.foundation.layout.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = "Posts") })
                },
                content = {
                    PostListContent()
                }
            )
        }
    }
}

@Composable
fun PostListContent() {
    val viewModel: PostListViewModel = viewModel()
    val posts by viewModel.posts.observeAsState(initial = emptyList())

    LazyColumn {
        items(posts) { post ->
            PostItem(post)
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = post.title,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = post.body,
                    modifier = Modifier.weight(1f)
                )
            }
            // Add more rows for additional text fields if needed
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PostItem(Post(1, 1, "Title", "Body"))
}
