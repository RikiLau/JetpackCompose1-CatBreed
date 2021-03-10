/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.ui.layout.ContentScale
import com.example.androiddevchallenge.bean.Cat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp() {
    val list = mutableListOf<Cat>()
    list.add(Cat("abyssinian", R.drawable.abyssinian))
    list.add(Cat("american_bobtail", R.drawable.american_bobtail))
    Surface(color = MaterialTheme.colors.background) {
        LazyVerticalGrid (
            cells = GridCells.Adaptive(minSize = 128.dp)
                         ) {
            items(list) { cat ->
                CatItem(cat)
            }
        }
    }
}

@Composable
fun CatItem(cat: Cat) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
          ) {
        val imageModifier = Modifier
                .fillMaxWidth()
        Image(
            painter = painterResource(id = cat.picRes),
            contentScale = ContentScale.Crop,
            modifier = imageModifier,
            contentDescription = null
             )
        Spacer(modifier = Modifier.height(8.dp))
        Text(cat.name)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

/*@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}*/
