import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
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

const val BOARD_SIZE = 8

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
            for (i in 0..BOARD_SIZE) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    for (j in 0..BOARD_SIZE) {
                        ChessSquare(
                            isWhite = (i + j) % 2 == 1,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
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
