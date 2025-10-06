package com.bajapuik.personal.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import com.bajapuik.personal.core.designsystem.utils.shimmer
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_avatar

@Composable
fun PersonalImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
) {
    val painter = rememberAsyncImagePainter(url)
    val state by painter.state.collectAsState()

    when (state) {
        is AsyncImagePainter.State.Empty,
        is AsyncImagePainter.State.Loading -> {
            Box(
                modifier = modifier
                    .shimmer()
            )
        }

        is AsyncImagePainter.State.Success -> {
            Image(
                modifier = modifier,
                painter = painter,
                contentDescription = null,
                contentScale = contentScale,
                colorFilter = colorFilter
            )
        }

        is AsyncImagePainter.State.Error -> {
            Image(
                modifier = modifier,
                painter = painterResource(Res.drawable.img_avatar),
                contentDescription = null,
                contentScale = contentScale
            )
        }
    }
}