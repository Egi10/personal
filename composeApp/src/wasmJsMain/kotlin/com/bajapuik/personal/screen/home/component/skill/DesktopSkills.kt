package com.bajapuik.personal.screen.home.component.skill

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalImage
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.ResponsiveColumn
import com.bajapuik.personal.domain.model.Skills

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DesktopSkills(
    skills: List<Skills>,
    modifier: Modifier = Modifier
) {
    ResponsiveColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = "Skills"
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = "The skills, tools and technologies I am really good at:",
            textAlign = TextAlign.Center,
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray600
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(86.87.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachRow = 8
        ) {
            skills.forEach {
                SkillsItem(it)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SkillsItem(
    item: Skills,
    modifier: Modifier = Modifier
) {
    var isHovered by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        if (isHovered) 1.1f else 1f, label = "hover-scale"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PersonalImage(
            url = item.icon,
            modifier = Modifier
                .size(64.dp)
                .scale(scale)
                .onPointerEvent(PointerEventType.Enter) { isHovered = true }
                .onPointerEvent(PointerEventType.Exit) { isHovered = false }
        )

        Text(
            text = item.name,
            style = PersonalTheme.typography.body1,
            color = PersonalTheme.colors.gray600
        )
    }
}