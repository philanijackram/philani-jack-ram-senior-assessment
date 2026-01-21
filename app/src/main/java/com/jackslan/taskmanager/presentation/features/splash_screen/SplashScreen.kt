package com.jackslan.taskmanager.presentation.features.splash_screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.presentation.MainActivity
import com.jackslan.taskmanager.presentation.components.ActionConfirmationDialog
import com.jackslan.taskmanager.utils.LocationUtils.getAndCacheLocation
import com.jackslan.taskmanager.utils.LocationUtils.isLocationPermissionGranted
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {}
) {
    val activity = LocalContext.current as MainActivity
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var isLocationPermissionGranted by remember {
        mutableStateOf(context.isLocationPermissionGranted())
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            isLocationPermissionGranted = isGranted
        }
    )

    var showActionConfirmationDialog by remember { mutableStateOf(false) }


    LaunchedEffect(true) {

        if (!isLocationPermissionGranted) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        } else {

            coroutineScope.launch {
                context.getAndCacheLocation {
                    onNavigateToHome()
                }
            }

        }

    }

    when {
        !isLocationPermissionGranted -> {
            showActionConfirmationDialog = true
        }

        else -> {
            context.getAndCacheLocation {
                coroutineScope.launch {
                    context.getAndCacheLocation {
                        onNavigateToHome()
                    }
                }
            }
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.task_manager_logo),
            contentDescription = stringResource(R.string.task_manager_logo)
        )
    }

    if (showActionConfirmationDialog) {
        ActionConfirmationDialog(
            title = stringResource(R.string.location_permission_required),
            message = stringResource(R.string.location_permission_required_message),
            onPositiveClick = {
                showActionConfirmationDialog = false
                permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            },
            onNegativeClick = {
                onNavigateToHome()
                showActionConfirmationDialog = false
            },
        )
    }

}