package com.turbosokol.sharedfront.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.turbosokol.sharedfront.ui.screens.CalculatorScreen
import com.turbosokol.sharedfront.util.ApplicationViewModel
import com.turbosokol.sharedfront.util.Extensions.observeAsState

/***
 *If this code runs it created by Evgenii Sokol.
 *If it doesn’t work, I don’t know who created it.
 ***/

@Composable
internal fun BottomNavigationView(viewModel: ApplicationViewModel, modifier: Modifier = Modifier) {
    val selectedTab by viewModel.observeSelectedTab.observeAsState()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigation(elevati