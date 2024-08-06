package com.viktorjordan.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.viktorjordan.navigation.ui.screen.BottomNavHomeScreen
import com.viktorjordan.navigation.ui.screen.BottomNavProfileScreen
import com.viktorjordan.navigation.ui.screen.BottomNavScreen
import com.viktorjordan.navigation.ui.screen.BottomNavSearchScreen
import com.viktorjordan.navigation.ui.screen.ModalNavigationDrawerComposable
import com.viktorjordan.navigation.ui.screen.Routes
import com.viktorjordan.navigation.ui.screen.SidebarNavScreen
import com.viktorjordan.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			NavigationTheme {
				val navController = rememberNavController()
				NavHost(
					navController = navController,
					startDestination = Routes.SidebarNavigationRoute
				) {
//					composable<Routes.ScreenA> {
//						Column(
//							modifier = Modifier.fillMaxSize(),
//							verticalArrangement = Arrangement.Center,
//							horizontalAlignment = Alignment.CenterHorizontally
//						) {
//							Button(onClick = {
//								navController.navigate(
//									Routes.ScreenB(
//										name = "William",
//										age = 25
//									)
//								)
//							}) {
//								Text(text = "Go to screen B")
//							}
//							Button(onClick = { navController.navigate(Routes.ModalNavigationDrawerScreen) }) {
//								Text(text = "Go to screen ModalNavigationDrawerScreen")
//							}
//						}
//					}
//					composable<Routes.ScreenB> {
//						val args = it.toRoute<Routes.ScreenB>()
//						Column(
//							modifier = Modifier.fillMaxSize(),
//							verticalArrangement = Arrangement.Center,
//							horizontalAlignment = Alignment.CenterHorizontally
//						) {
//							Text(text = "${args.name}, ${args.age} years old")
//						}
//					}
//
//
//					composable<Routes.ModalNavigationDrawerScreen> {
//						ModalNavigationDrawerComposable()
//					}
					
					
					//bottom navigation screens
					composable<Routes.BottomNavigationRoute> {
						BottomNavScreen()
					}
					
					//sidebar navigation screens
					composable<Routes.SidebarNavigationRoute> {
						SidebarNavScreen()
					}
					
					
				}
			}
		}
	}
}


