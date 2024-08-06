package com.viktorjordan.navigation.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


data class BottomNavigationItem(
	val title: String,
	val selectedIcon: ImageVector,
	val unselectedIcon: ImageVector,
	val hasNews: Boolean = false,
	val badgeCount: Int? = null
)


@Composable
fun BottomNavScreen(

) {
	//List of Bottom Navigation Items
	val items = listOf(
		BottomNavigationItem(
			title = "Home",
			selectedIcon = Icons.Filled.Home,
			unselectedIcon = Icons.Outlined.Home,
			badgeCount = 5
		),
		BottomNavigationItem(
			title = "Search",
			selectedIcon = Icons.Filled.Search,
			unselectedIcon = Icons.Outlined.Search,
			hasNews = true,
		),
		BottomNavigationItem(
			title = "Profile",
			selectedIcon = Icons.Filled.Person,
			unselectedIcon = Icons.Outlined.Person
		)
	)
	//Add a state to hold the selected item index
	var selectedItemIndex by rememberSaveable {
		mutableStateOf(0)
	}
	
	
	Scaffold(
		bottomBar = {
			// Bottom Navigation
			NavigationBar {
				//loop through the items
				items.forEachIndexed() { index, item ->
					// Bottom Navigation Item
					NavigationBarItem(
						selected = selectedItemIndex == index,
						onClick = {
							selectedItemIndex = index
							
						},
						alwaysShowLabel = true,
						label = {
							Text(text = item.title)
						},
						icon = {
							BadgedBox(
								badge = {
									//if statement
									if (item.badgeCount != null) {
										Badge {
											Text(text = item.badgeCount.toString())
										}
									} else if (item.hasNews) {
										Badge(
											modifier = Modifier.size(8.dp) // Adjust the size as needed
										) {
											Text(text = "•")
										}
									}
									//end of if statement
								}
							) {
								Icon(
									imageVector = if (selectedItemIndex == index) {
										item.selectedIcon
									} else {
										item.unselectedIcon
									},
									contentDescription = item.title
								)
							}
						},
						
						)
				}
			}
		},
		content = { innerPadding ->
			// Replace fixed content with a composable based on selected item
			when (val title = items[selectedItemIndex].title) {
				"Home" -> BottomNavHomeScreen(
					modifier = Modifier.padding(
						innerPadding
					)
				)
				
				"Search" -> BottomNavSearchScreen(
					modifier = Modifier.padding(
						innerPadding
					)
				)
				
				"Profile" -> BottomNavProfileScreen(
					modifier = Modifier.padding(
						innerPadding
					)
				)
				
				else -> Text("Unknown Screen") // Handle potential unknown routes
			}
		}
	)
}
	

