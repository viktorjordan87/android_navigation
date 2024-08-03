package com.viktorjordan.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.viktorjordan.navigation.ui.screen.BottomNavScreen
import com.viktorjordan.navigation.ui.screen.ModalNavigationDrawerComposable
import com.viktorjordan.navigation.ui.theme.NavigationTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			NavigationTheme {
				val navController = rememberNavController()
				NavHost(
					navController = navController,
					startDestination = BottomNavigationScreen
				) {
					composable<ScreenA> {
						Column(
							modifier = Modifier.fillMaxSize(),
							verticalArrangement = Arrangement.Center,
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							Button(onClick = {
								navController.navigate(
									ScreenB(
										name = "William",
										age = 25
									)
								)
							}) {
								Text(text = "Go to screen B")
							}
							Button(onClick = { navController.navigate(ModalNavigationDrawerScreen) }) {
								Text(text = "Go to screen ModalNavigationDrawerScreen")
							}
						}
					}
					composable<ScreenB> {
						val args = it.toRoute<ScreenB>()
						Column(
							modifier = Modifier.fillMaxSize(),
							verticalArrangement = Arrangement.Center,
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							Text(text = "${args.name}, ${args.age} years old")
						}
					}
					composable<ModalNavigationDrawerScreen> {
						ModalNavigationDrawerComposable()
					}
					composable<BottomNavigationScreen> {
						BottomNavScreen()
					}
				}
			}
		}
	}
}

@Serializable
object ScreenA

@Serializable
data class ScreenB(
	val name: String?,
	val age: Int
)

@Serializable
object ModalNavigationDrawerScreen

@Serializable
object BottomNavigationScreen
