package com.example.gallery_art.ui.theme

import android.widget.HorizontalScrollView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gallery_art.R

@Composable
fun GalleryArtApp(modifier: Modifier = Modifier){
    val appViewModel: GalleryArtViewModel = GalleryAppViewModel
    val appState = appViewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.teal_200))
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShowGalleryImage(paint = appState.value.imageArt)
            ShowGalleryInformation(
                location = appState.value.artLocation,
                author = appState.value.artAuthor
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Button(
                    modifier = Modifier.size(width = 120.dp, height = 40.dp),
                    onClick = { appViewModel.showPreviousArt()}
                ){
                    Text(text = "Previous")
                }
                Button(
                    modifier = Modifier.size(width = 120.dp, height = 40.dp),
                    onClick = { appViewModel.showNextArt()}
                ){
                    Text(text = "Next")
                }
            }

        }
    }
}
@Composable
fun ShowGalleryImage(
    modifier: Modifier = Modifier,
    paint: Int)
{
    Card(
        modifier = Modifier
            .size(400.dp)
            .padding(30.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        colors = CardDefaults.elevatedCardColors()
        ){
        Image(
            painter = painterResource(paint),
            modifier = Modifier.padding(20.dp),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ShowGalleryInformation(
    modifier: Modifier = Modifier,
    location: Int,
    author: Int
    ){
    Card(modifier = modifier
        .size(width = 400.dp, height = 150.dp)
        .padding(vertical = 16.dp, horizontal = 12.dp)
    ){
        Column(){
            Text(
                text = stringResource(location),
                modifier = Modifier.padding(8.dp),
                fontSize = 25.sp,
                lineHeight = 35.sp
            )
            Text(
                text = stringResource(author),
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                fontSize = 18.sp,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GalleryArtAppPreview(){
    Gallery_ArtTheme{
        GalleryArtApp(modifier = Modifier.fillMaxSize())
    }
}