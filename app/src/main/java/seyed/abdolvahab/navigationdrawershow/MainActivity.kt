package seyed.abdolvahab.navigationdrawershow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import seyed.abdolvahab.navigationdrawershow.ui.theme.NavigationDrawerShowTheme










class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            DrawerAppComponent()


        }
    }
}




@ExperimentalMaterial3Api
@Composable
fun DrawerAppComponent() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val currentScreen = remember { mutableStateOf(DrawerAppScreen.Screen1) }

    val coroutineScope = rememberCoroutineScope()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){

        ModalNavigationDrawer(

            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {

                Column(modifier = Modifier,

                    ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W500,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                        ,
                        textAlign = TextAlign.Left

                    )


                    DrawerContentComponent(


                        currentScreen = currentScreen,
                        closeDrawer = { coroutineScope.launch { drawerState.close() } }
                    )
                }
            },
            content = {


                BodyContentComponent(
                    currentScreen = currentScreen.value,
                    openDrawer = {
                        coroutineScope.launch { drawerState.open() }
                    }
                )
            }
        )

    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun DrawerAppComponentPreview() {
    DrawerAppComponent()
}







