package com.bajapuik.personal.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SimpleFlowRow(
    modifier: Modifier = Modifier,
    horizontalSpacing: Dp = 8.dp,
    verticalSpacing: Dp = 8.dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurableLayout, constraints ->
        // Convert spacing to pixels
        val horizontalSpacingPx = horizontalSpacing.roundToPx()
        val verticalSpacingPx = verticalSpacing.roundToPx()

        // Ensure we're using the correct width constraint
        val maxWidth = constraints.maxWidth

        // Measure each child with loose constraints so they can be as wide as needed
        val placeableLayout = measurableLayout.map { measurable ->
            // We use loose constraints to let items be as big as they need
            measurable.measure(
                constraints.copy(
                    minWidth = 0,
                    minHeight = 0
                )
            )
        }

        // Track rows data
        val rows = mutableListOf<MutableList<Placeable>>()
        val rowWidths = mutableListOf<Int>()
        val rowHeights = mutableListOf<Int>()

        // Initialize first row
        var currentRow = mutableListOf<Placeable>()
        var currentRowWidth = 0
        var currentRowHeight = 0

        // Arrange items into rows
        for (placeable in placeableLayout) {
            // Calculate width with spacing
            val itemWidth = placeable.width
            val itemWidthWithSpacing =
                if (currentRow.isEmpty()) itemWidth else itemWidth + horizontalSpacingPx

            // Check if this item would exceed max width
            if (currentRow.isNotEmpty() && currentRowWidth + itemWidthWithSpacing > maxWidth) {
                // Current row is full, start a new row
                rows.add(currentRow)
                rowWidths.add(currentRowWidth)
                rowHeights.add(currentRowHeight)

                // Reset for new row
                currentRow = mutableListOf()
                currentRowWidth = 0
                currentRowHeight = 0
            }

            // Add the item to the current row
            currentRow.add(placeable)

            // Update current row dimensions
            currentRowWidth += itemWidthWithSpacing
            currentRowHeight = maxOf(currentRowHeight, placeable.height)
        }

        // Add the last row if it has any items
        if (currentRow.isNotEmpty()) {
            rows.add(currentRow)
            rowWidths.add(currentRowWidth)
            rowHeights.add(currentRowHeight)
        }

        // Calculate the total height needed
        val totalHeight = rowHeights.sumOf { it } +
                (rows.size - 1).coerceAtLeast(0) * verticalSpacingPx

        // Create the layout
        layout(
            width = maxWidth,
            height = totalHeight
        ) {
            var yPosition = 0

            // Position items row by row
            for (i in rows.indices) {
                val row = rows[i]
                val rowHeight = rowHeights[i]
                var xPosition = 0

                for (placeable in row) {
                    placeable.placeRelative(
                        x = xPosition,
                        y = yPosition
                    )

                    // Move x position for next item
                    xPosition += placeable.width + horizontalSpacingPx
                }

                // Move to next row
                yPosition += rowHeight + verticalSpacingPx
            }
        }
    }
}