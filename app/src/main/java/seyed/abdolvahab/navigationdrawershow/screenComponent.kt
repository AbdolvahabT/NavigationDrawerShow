//@file:OptIn(ExperimentalMaterial3Api::class)

package seyed.abdolvahab.navigationdrawershow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@ExperimentalMaterial3Api
@Composable
fun ScreenComponent(openDrawer: () -> Unit, text1:String, text2:String, hexColor: Long) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text1, fontSize = 10.sp) },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )

        Surface(color = Color(hexColor.toInt()), modifier = Modifier.weight(1f)) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = text2)
                }
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun BodyContentComponent(
    currentScreen: DrawerAppScreen,
    openDrawer: () -> Unit
) {
    when (currentScreen) {
        DrawerAppScreen.Screen1 -> ScreenComponent(openDrawer, "Screen 1 Title",
            "Hello!! Screen 1", 0xFFffd7d7)

        DrawerAppScreen.Screen2 -> ScreenComponent(openDrawer, "Screen 2 Title",
            "Hello!! Screen 2", 0xFFffe9d6)

        DrawerAppScreen.Screen3 -> ScreenComponent(openDrawer, "Screen 3 Title",
            "Hello!! Screen 3", 0xFFfffbd0)
    }
}