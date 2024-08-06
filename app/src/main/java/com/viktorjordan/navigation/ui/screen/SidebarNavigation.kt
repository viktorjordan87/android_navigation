package com.viktorjordan.navigation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.viktorjordan.navigation.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SidebarNavScreen(

) {
	//remember drawer state
	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val scope = rememberCoroutineScope()
	
	//modal navigation drawer
	ModalNavigationDrawer(
		drawerState = drawerState,
		drawerContent = {
			//drawer content
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
							drawerState.apply {
								if (isClosed) open() else close()
							}
						}
					}) {
						Icon(
							Icons.Default.Close,
							contentDescription = "Close Sidebar",
							modifier = Modifier.size(48.dp)
						)
					}
				}
				//drawer items
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
		
		
		val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
		//start of Scaffold
		Scaffold(
			topBar = {
				//start of TopAppBar
				TopAppBar(
					navigationIcon = {
						IconButton(onClick = { /* do something */ }) {
							Icon(
								imageVector = Icons.AutoMirrored.Filled.ArrowBack,
								contentDescription = "Localized description"
							)
						}
					},
					title = { Text(text = "Sidebar Navigation") },
					scrollBehavior = scrollBehavior,
					actions = {
						//hamburger menu icon
						IconButton(onClick = {
							scope.launch {
								drawerState.open()
							}
						}) {
							Icon(
								imageVector = Icons.Filled.Menu,
								contentDescription = "Hamburger menu"
							)
						}
					}
				)
			}
			//end of TopAppBar
		) { innerPadding ->
			//start of Column
			Column(
				modifier = Modifier.padding(innerPadding)
			) {
				Text(text = "Sidebar Navigation")
			}
			//end of Column
		}
		//end of Scaffold
	}
}