package com.viktorjordan.navigation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


//Bottom navigation screen composables
@Composable
fun BottomNavHomeScreen(modifier: Modifier = Modifier) {
	Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
		Text(text = "Bottom Navigation Home Screen")
	}
}

@Composable
fun BottomNavSearchScreen(modifier: Modifier = Modifier) {
	Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
		Text(text = "Bottom Navigation Search Screen")
	}
}

@Composable
fun BottomNavProfileScreen(modifier: Modifier = Modifier) {
	Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
		Text(text = "Bottom Navigation Profile Screen")
	}
}

//Sidebar navigation screen composables
