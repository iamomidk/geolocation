package com.polygon.geolocation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {

    data object BgLocationAccessScreen : Screen("bg_location_access_screen", R.string.bg_location_access_screen, Icons.Filled.Favorite)
    data object CurrentLocationScreen : Screen("current_location_screen", R.string.current_location_screen, Icons.Filled.Favorite)
    data object GeofencingScreen : Screen("geofencing_screen", R.string.geofencing_screen, Icons.Filled.Favorite)
    data object LocationUpdatesScreen : Screen("location_updates_screen", R.string.location_updates_screen, Icons.Filled.Favorite)
    data object UserActivityRecognitionScreen : Screen("user_activity_recognition_screen", R.string.user_activity_recognition_screen, Icons.Filled.Favorite)
}