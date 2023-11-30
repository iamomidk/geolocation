@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package com.polygon.geolocation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.polygon.geolocation.backgroundAccess.BgLocationAccessScreen
import com.polygon.geolocation.current.CurrentLocationScreen
import com.polygon.geolocation.geofencing.GeofencingScreen
import com.polygon.geolocation.locationupdates.LocationUpdatesScreen
import com.polygon.geolocation.useractivityrecog.UserActivityRecognitionScreen

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			AppTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {

					val items = listOf(
						Screen.BgLocationAccessScreen,
						Screen.CurrentLocationScreen,
						Screen.GeofencingScreen,
						Screen.LocationUpdatesScreen,
						Screen.UserActivityRecognitionScreen,
					)

					val navController = rememberNavController()
					Scaffold(
						bottomBar = {
							BottomAppBar {
								val navBackStackEntry by navController.currentBackStackEntryAsState()
								val currentDestination = navBackStackEntry?.destination
								items.forEach { screen ->
									NavigationBarItem(
										icon = { },
										label = { Text(stringResource(screen.resourceId)) },
										selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
										onClick = {
											navController.navigate(screen.route) {
												// Pop up to the start destination of the graph to
												// avoid building up a large stack of destinations
												// on the back stack as users select items
												popUpTo(navController.graph.findStartDestination().id) {
													saveState = true
												}
												// Avoid multiple copies of the same destination when
												// reselecting the same item
												launchSingleTop = true
												// Restore state when reselecting a previously selected item
												restoreState = true
											}
										}
									)
								}
							}
						}
					) { innerPadding ->
						NavHost(
							navController,
							startDestination = Screen.BgLocationAccessScreen.route,
							Modifier.padding(innerPadding)
						) {
							composable(Screen.BgLocationAccessScreen.route) { BgLocationAccessScreen() }
							composable(Screen.CurrentLocationScreen.route) { CurrentLocationScreen() }
							composable(Screen.GeofencingScreen.route) { GeofencingScreen() }
							composable(Screen.LocationUpdatesScreen.route) { LocationUpdatesScreen() }
							composable(Screen.UserActivityRecognitionScreen.route) { UserActivityRecognitionScreen() }
						}
					}
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
						// LocationPermissionScreen()
					}

				}
			}
		}

	}
}