import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.math.min

@Composable
private fun ChessSquare(
    isWhite: Boolean,
    modifier: Modifier = Modifier
) {
    val squareColor = if (isWhite) Color.White else Color.Black
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(squareColor)
    )
}

const val BOARD_SIZE = 7

@Composable
fun ChessBoard() {
    BoxWithConstraints {
        val size = with(LocalDensity.current) {
            min(constraints.maxWidth, constraints.maxHeight).toDp()
        }
        Column(
            modifier = Modifier
                .size(size)
                .padding(16.dp),
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .width(24.dp)
                )
                for (i in 'A'..'A' + BOARD_SIZE) {
                    Text(
                        text = "$i",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .rotate(180f),
                        textAlign = TextAlign.Center
                    )
                }
                Box(
                    modifier = Modifier
                        .width(24.dp)
                )
            }
            for (i in 0..BOARD_SIZE) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(24.dp)
                    ) {
                        Text(
                            "${BOARD_SIZE - i + 1}",
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                    for (j in 0..BOARD_SIZE) {
                        ChessSquare(
                            isWhite = (i + j) % 2 == 1,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(24.dp)
                    ) {
                        Text(
                            "${BOARD_SIZE - i + 1}",
                            modifier = Modifier
                                .rotate(180f)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
            Row {
                Box(
                    modifier = Modifier
                        .width(24.dp)
                )
                for (i in 'A'..'A' + BOARD_SIZE) {
                    Text(
                        text = "$i",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
                Box(
                    modifier = Modifier
                        .width(24.dp)
                )
            }
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        resizable = true,
    ) {
        ChessBoard()
    }
}
