package com.bajapuik.personal.screen.main.component.work

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.calculateResponsivePadding
import com.bajapuik.personal.core.ui.shadowMd
import com.bajapuik.personal.data.work.Work
import kotlinx.browser.window
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_external_link

@Composable
fun DesktopWork(
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
            text = "Work"
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = "Some of the noteworthy projects I have built:",
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
            val columnWidth = min(maxWidth, 1218.dp)

            val breakpoints = mapOf(
                0.dp to 0.13f,
                600.dp to 0.00f,
                900.dp to 0.08f,
                1000.dp to 0.13f,
            )

            val horizontalPadding = calculateResponsivePadding(
                columnWidth = columnWidth,
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
                        WorkItemEven(
                            item = work
                        )
                    } else {
                        WorkItemOdd(
                            item = work
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WorkItemEven(
    item: Work,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadowMd(
                shadowColor = PersonalTheme.colors.gray200.copy(
                    alpha = 0.8f
                ),
                borderRadius = 12.dp
            )
            .background(
                color = PersonalTheme.colors.default,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            WorkItemImage(
                image = item.image,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .drawBehind {
                        val borderWidth = 1.dp.toPx()
                        drawLine(
                            color = Color(0xFFF3F4F6), // Warna border
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = borderWidth
                        )
                    }
                    .background(
                        color = PersonalTheme.colors.gray50,
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            bottomStart = 12.dp
                        )
                    )
                    .padding(
                        all = 48.dp
                    )
            )

            WorkItemInfo(
                item = item,
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        all = 48.dp
                    )
            )
        }
    }
}

@Composable
fun WorkItemOdd(
    item: Work,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadowMd(
                shadowColor = PersonalTheme.colors.gray200.copy(
                    alpha = 0.8f
                ),
                borderRadius = 12.dp
            )
            .background(
                color = PersonalTheme.colors.default,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            WorkItemInfo(
                item = item,
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        all = 48.dp
                    )
            )

            WorkItemImage(
                image = item.image,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .drawBehind {
                        val borderWidth = 1.dp.toPx()
                        drawLine(
                            color = Color(0xFFF3F4F6), // Warna border
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = borderWidth
                        )
                    }
                    .background(
                        color = PersonalTheme.colors.gray50,
                        shape = RoundedCornerShape(
                            topEnd = 12.dp,
                            bottomEnd = 12.dp
                        )
                    )
                    .padding(
                        all = 48.dp
                    )
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
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

        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item.technologies.forEach {
                PersonalTags(
                    text = it
                )
            }
        }

        if (item.projectUrl != null) {
            PersonalIconButtons(
                icon = painterResource(Res.drawable.ic_external_link),
                onClick = {
                    window.open(item.projectUrl, "_blank")
                }
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun WorkItemImage(
    image: DrawableResource,
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
        Image(
            painter = painterResource(image),
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
