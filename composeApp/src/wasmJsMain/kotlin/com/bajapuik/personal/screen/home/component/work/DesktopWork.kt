package com.bajapuik.personal.screen.home.component.work

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.ResponsiveColumn
import com.bajapuik.personal.core.ui.SimpleFlowRow
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.screen.home.component.work.utils.WorkItemLayoutType
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import personal.composeapp.generated.resources.*

@Composable
internal fun DesktopWork(
    works: List<Work>,
    modifier: Modifier = Modifier
) {
    ResponsiveColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = stringResource(Res.string.work)
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = stringResource(Res.string.work_noteworthy_projects),
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray600
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Column(
            modifier = Modifier
                .padding(
                    horizontal = 32.dp
                ),
            verticalArrangement = Arrangement.spacedBy(
                space = 48.dp
            )
        ) {
            works.forEachIndexed { index, work ->
                if (index % 2 == 0) {
                    WorkItem(
                        item = work,
                        layoutType = WorkItemLayoutType.IMAGE_LEFT
                    )
                } else {
                    WorkItem(
                        item = work,
                        layoutType = WorkItemLayoutType.IMAGE_RIGHT
                    )
                }
            }
        }
    }
}

@Composable
private fun WorkItem(
    item: Work,
    layoutType: WorkItemLayoutType,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .dropShadow(
                shape = RoundedCornerShape(12.dp),
                block = {
                    offset = Offset(
                        x = 0f,
                        y = 4f
                    )
                    brush = SolidColor(
                        value = Color(0xFF000000).copy(
                            alpha = 0.15f
                        )
                    )
                    radius = 3f
                }
            )
            .background(
                color = PersonalTheme.colors.gray100,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp)),
        verticalAlignment = Alignment.Top
    ) {
        if (layoutType == WorkItemLayoutType.IMAGE_LEFT) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(
                        color = PersonalTheme.colors.gray200
                    )
                    .padding(
                        all = 48.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                WorkItemImage(
                    image = item.image,
                    modifier = Modifier
                        .matchParentSize()
                )
            }

            WorkItemInfo(
                item = item,
                modifier = Modifier
                    .weight(1f)
                    .padding(48.dp)
            )
        } else {
            WorkItemInfo(
                item = item,
                modifier = Modifier
                    .weight(1f)
                    .padding(48.dp)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(
                        color = PersonalTheme.colors.gray200
                    )
                    .padding(
                        all = 48.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                WorkItemImage(
                    image = item.image,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }
    }
}

@Composable
private fun WorkItemInfo(
    item: Work,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp
        )
    ) {
        Text(
            text = item.name,
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray900,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = item.description,
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600
        )

        SimpleFlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalSpacing = 8.dp,
            verticalSpacing = 8.dp,
        ) {
            item.technologies.forEach {
                PersonalTags(text = it)
            }
        }

        item.projectUrl?.let {
            PersonalIconButtons(
                icon = painterResource(Res.drawable.ic_external_link),
                onClick = {
                    window.open(it, "_blank")
                }
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun WorkItemImage(
    image: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    var isHovered by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.1f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "hover-scale"
    )
    Box(
        modifier = modifier
            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(PlatformContext.INSTANCE)
                .data(image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(Res.drawable.img_avatar),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(480f / 384f) // atau bisa .aspectRatio(5f / 4f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    clip = true
                    shape = RoundedCornerShape(12.dp)
                }
        )
    }
}