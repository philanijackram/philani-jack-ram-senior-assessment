package com.jackslan.taskmanager.presentation

import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.jackslan.taskmanager.data.local.DataStoreManager
import com.jackslan.taskmanager.navigation.AppNavGraph
import com.jackslan.taskmanager.presentation.theme.TaskManagerTheme
import com.jackslan.taskmanager.utils.LocationUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @Inject
    lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LocationUtils.requestPermissions(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->

                lifecycleScope.launch {
                    dataStoreManager.storeLocation(
                        coordinates = "${location?.latitude}, ${location?.longitude}"
                    )

                    Log.d(
                        "Location",
                        "Latitude: ${location?.latitude}, Longitude: ${location?.longitude}"
                    )
                }
            }

        enableEdgeToEdge()

        setContent {

            val navController = rememberNavController()
            val darkTheme = dataStoreManager.darkModeFlow.collectAsState(initial = false)

            TaskManagerTheme(
                darkTheme = darkTheme.value
            ) {
                AppNavGraph(
                    darkMode = darkTheme.value,
                    navController = navController
                )
            }
        }
    }
}