package com.viktorjordan.navigation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.viktorjordan.navigation.R
import kotlinx.coroutines.launch

@Composable
fun ModalNavigationDrawerComposable() {
	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val scope = rememberCoroutineScope()
	
	ModalNavigationDrawer(
		drawerState = drawerState,
		drawerContent = {
			ModalDrawerSheet {
				//logo and close button row
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween
				) {
					//logo
					Image(
						painter = painterResource(id = R.drawable.kotlin_icon),
						contentDescription = "Kotlin Logo"
					)
					//close button of the sidebar
					IconButton(onClick = {
						scope.launch {
							drawerState.close()
						}
					}) {
						Icon(
							Icons.Default.Close,
							contentDescription = "Close Sidebar",
							modifier = Modifier.size(48.dp)
						)
					}
				}
				Text("Drawer title", modifier = Modifier.padding(16.dp))
				HorizontalDivider()
				NavigationDrawerItem(
					label = { Text(text = "Drawer Item") },
					selected = false,
					onClick = { /*TODO*/ }
				)
				// ...other drawer items
			}
		},
		gesturesEnabled = true
	
	) {
		// Screen content
		Scaffold(
			floatingActionButton = {
				ExtendedFloatingActionButton(
					text = { Text("Show drawer") },
					icon = { Icon(Icons.Filled.Add, contentDescription = "") },
					onClick = {
						scope.launch {
							drawerState.apply {
								if (isClosed) open() else close()
							}
						}
					}
				)
			}
		) { padding ->
			Text(text = "Screen content", modifier = Modifier.padding(padding))
		}
		
	}
}

@Preview
@Composable
fun ModalNavigationDrawerPreview() {
	ModalNavigationDrawerComposable()
}
