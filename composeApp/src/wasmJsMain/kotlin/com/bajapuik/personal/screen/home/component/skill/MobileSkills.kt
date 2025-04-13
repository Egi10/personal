package com.bajapuik.personal.screen.home.component.skill

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.data.skils.Skills
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MobileSkills(
    skills: List<Skills>,
    modifier: Modifier = Modifier
) {
    Column(
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
                .height(24.dp)
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(57.59.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInEachRow = 10
        ) {
            skills.forEach { skill ->
                MobileSkillsItem(
                    item = skill,
                    modifier = Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                    window.open(skill.link, "_blank")
                                }
                            )
                        }
                )
            }
        }
    }
}

@Composable
private fun MobileSkillsItem(
    item: Skills,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(item.icon),
            contentDescription = item.name,
            modifier = Modifier
                .size(64.dp)
        )

        Text(
            text = item.name,
            style = PersonalTheme.typography.body1,
            color = PersonalTheme.colors.gray600
        )
    }
}