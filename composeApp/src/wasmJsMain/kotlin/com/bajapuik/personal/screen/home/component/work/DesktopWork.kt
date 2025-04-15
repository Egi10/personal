package com.bajapuik.personal.screen.home.component.work

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.SimpleFlowRow
import com.bajapuik.personal.core.ui.calculateResponsivePadding
import com.bajapuik.personal.core.ui.shadowMd
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.screen.home.component.work.utils.WorkItemLayoutType
import com.bajapuik.personal.screen.home.component.work.utils.imageDesktop
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_external_link
import personal.composeapp.generated.resources.img_avatar
import personal.composeapp.generated.resources.work
import personal.composeapp.generated.resources.work_noteworthy_projects

@Composable
internal fun DesktopWork(
    works: List<Work>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(
                horizontal = 32.dp
            ),
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

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            /**
             * TODO : Adjust layout margins to match the web design at https://sagarshah.dev/
             * On larger screens, the margins are still inconsistent
             * Review the responsive layout rules and ensure a consistent max content width
             */
            val breakpoints = mapOf(
                0.dp to 0.13f,
                600.dp to 0.00f,
                900.dp to 0.08f,
                1000.dp to 0.13f,
            )

            val horizontalPadding = calculateResponsivePadding(
                columnWidth = maxWidth,
                breakpoints = breakpoints,
                defaultMultiplier = 0.13f
            )

            Column(
                modifier = Modifier
                    .padding(
                        horizontal = horizontalPadding
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
}

@Composable
private fun WorkItem(
    item: Work,
    layoutType: WorkItemLayoutType,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadowMd(
                shadowColor = PersonalTheme.colors.gray200.copy(alpha = 0.8f),
                borderRadius = 12.dp
            )
            .background(
                color = PersonalTheme.colors.default,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        SubcomposeLayout(
            modifier = Modifier.fillMaxWidth()
        ) { constraints ->
            val halfWidth = constraints.maxWidth / 2

            // Info
            val infoPlaceable = subcompose("info") {
                WorkItemInfo(
                    item = item,
                    modifier = Modifier.padding(48.dp)
                )
            }.map {
                it.measure(constraints.copy(minWidth = 0, maxWidth = halfWidth))
            }

            val infoHeight = infoPlaceable.maxOfOrNull { it.height } ?: 0

            // Image
            val imagePlaceable = subcompose("image") {
                val isImageLeft = layoutType == WorkItemLayoutType.IMAGE_LEFT
                WorkItemImage(
                    image = item.image,
                    modifier = Modifier
                        .imageDesktop(
                            isImageLeft = isImageLeft
                        )
                )
            }.map {
                it.measure(
                    constraints.copy(
                        minWidth = 0,
                        maxWidth = halfWidth,
                        minHeight = infoHeight,
                        maxHeight = infoHeight
                    )
                )
            }

            layout(constraints.maxWidth, infoHeight) {
                if (layoutType == WorkItemLayoutType.IMAGE_LEFT) {
                    imagePlaceable.forEach { it.placeRelative(0, 0) }
                    infoPlaceable.forEach { it.placeRelative(halfWidth, 0) }
                } else {
                    infoPlaceable.forEach { it.placeRelative(0, 0) }
                    imagePlaceable.forEach { it.placeRelative(halfWidth, 0) }
                }
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
    modifier: Modifier = Modifier
) {
    var isHovered by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        if (isHovered) 1.1f else 1f, label = "hover-scale"
    )

    Box(
        modifier = modifier
            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false }
            .graphicsLayer { clip = false },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(PlatformContext.INSTANCE)
                .data(image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(Res.drawable.img_avatar),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .scale(scale)
                .clip(
                    shape = RoundedCornerShape(12.dp)
                )
        )
    }
}