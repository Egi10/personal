package com.bajapuik.personal.screen.home.component.header

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalButton
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.designsystem.utils.LocalThemeState
import com.bajapuik.personal.core.ui.ResponsiveRow
import com.bajapuik.personal.core.utils.NameUtils
import com.bajapuik.personal.screen.home.utils.Section
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_dark_mode_light
import personal.composeapp.generated.resources.ic_light_mode

@Composable
fun DesktopHeader(
    onInitialClick: () -> Unit,
    onSectionClick: (Section) -> Unit,
    name: String,
    modifier: Modifier = Modifier
) {
    ResponsiveRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "<${NameUtils.getInitials(name = name)}/>",
            style = PersonalTheme.typography.headingH3,
            color = PersonalTheme.colors.gray900,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            onInitialClick.invoke()
                        }
                    )
                }
                .weight(1f)
        )

        MenuNavigation(
            onSectionClick = onSectionClick
        )
    }
}

@Composable
private fun MenuNavigation(
    onSectionClick: (Section) -> Unit,
    modifier: Modifier = Modifier
) {
    val themeState = LocalThemeState.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MenuHeader(
            onSectionClick = onSectionClick
        )

        Spacer(
            modifier = Modifier
                .width(24.dp)
        )

        VerticalDivider(
            modifier = Modifier
                .height(24.dp),
            color = PersonalTheme.colors.gray100
        )

        Spacer(
            modifier = Modifier
                .width(24.dp)
        )

        PersonalIconButtons(
            icon = if (themeState.isDarkMode) {
                painterResource(Res.drawable.ic_dark_mode_light)
            } else {
                painterResource(Res.drawable.ic_light_mode)
            },
            onClick = {
                themeState.toggleTheme()
            }
        )

        Spacer(
            modifier = Modifier
                .width(16.dp)
        )

        PersonalButton(
            text = "Download CV",
            onClick = {
                window.open(
                    "https://egi10.github.io/storage/resume/julsapargi_nursam.pdf",
                    "_blank"
                )
            }
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun MenuHeader(
    onSectionClick: (Section) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            space = 24.dp
        )
    ) {
        val sections = Section.entries
        sections.forEach { s ->
            var isHovered by remember {
                mutableStateOf(false)
            }

            Box(
                modifier = Modifier
                    .onPointerEvent(PointerEventType.Enter) { isHovered = true }
                    .onPointerEvent(PointerEventType.Exit) { isHovered = false }
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                onSectionClick.invoke(s)
                            }
                        )
                    }
            ) {
                Text(
                    text = s.title,
                    style = PersonalTheme.typography.body2,
                    fontWeight = FontWeight.Medium,
                    color = if (!isHovered) {
                        PersonalTheme.colors.gray600
                    } else {
                        PersonalTheme.colors.gray900
                    },
                )
            }
        }
    }
}