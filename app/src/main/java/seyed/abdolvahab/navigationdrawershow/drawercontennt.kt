package seyed.abdolvahab.navigationdrawershow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun DrawerContentComponent(
    currentScreen: MutableState<DrawerAppScreen>,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        for (index in DrawerAppScreen.entries.toTypedArray().indices) {

            val screen = getScreenBasedOnIndex(index)
            Column(Modifier.clickable(onClick = {
                currentScreen.value = screen

                closeDrawer()
            }), content = {

                Surface(
                    modifier = Modifier.fillMaxWidth(),

                    color = if (currentScreen.value == screen) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                ) {
                    Text(text = screen.name , modifier = Modifier.padding(16.dp), textAlign = TextAlign.Left)
                }
            })
        }
    }
}

fun getScreenBasedOnIndex(index: Int) = when (index) {
    0 -> DrawerAppScreen.Screen1
    1 -> DrawerAppScreen.Screen2
    2 -> DrawerAppScreen.Screen3
    else -> DrawerAppScreen.Screen1
}


