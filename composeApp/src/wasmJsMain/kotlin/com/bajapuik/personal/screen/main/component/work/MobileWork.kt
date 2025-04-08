package com.bajapuik.personal.screen.main.component.work

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.shadowMd
import com.bajapuik.personal.data.work.Work
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_external_link
import personal.composeapp.generated.resources.work
import personal.composeapp.generated.resources.work_noteworthy_projects

@Composable
internal fun MobileWork(
    works: List<Work>,
    modifier: Modifier = Modifier
) {
    Column(
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
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 24.dp
            )
        ) {
            works.forEach {
                MobileWorkItem(
                    item = it
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MobileWorkItem(
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
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(343f / 256)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                        )
                    )
                    .border(
                        width = 1.dp,
                        color = PersonalTheme.colors.gray100,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = PersonalTheme.colors.gray50
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(item.image),
                    contentDescription = null,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(
                            all = 32.dp
                        )
                )
            }

            Column(
                modifier = Modifier
                    .padding(
                        all = 32.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(
                    space = 24.dp
                )
            ) {
                Text(
                    text = item.name,
                    style = PersonalTheme.typography.subtitle,
                    color = PersonalTheme.colors.gray900
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
    }
}