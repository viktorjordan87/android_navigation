package com.viktorjordan.navigation.ui.screen

import kotlinx.serialization.Serializable

sealed class Routes {
	
	@Serializable
	object ScreenA
	
	@Serializable
	data class ScreenB(
		val name: String?,
		val age: Int
	)
	
	@Serializable
	object ModalNavigationDrawerScreen
	
	//Bottom navigation screens
	@Serializable
	object BottomNavigationRoute : Routes()
	
	//Sidebar navigation screens
	@Serializable
	object SidebarNavigationRoute : Routes()
	
}