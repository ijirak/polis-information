package com.turbosokol.sharedfront.util

import androidx.compose.runtime.*
import org.brightify.hyperdrive.multiplatformx.ManageableViewModel
import org.brightify.hyperdrive.multiplatformx.ObservableObject
import org.brightify.hyperdrive.multiplatformx.property.ObservableProperty

/***
 *If this code runs it created by Evgenii Sokol.
 *If it doesn’t work, I don’t know who created it.
 ***/

object Extensions {
    @Composable
    internal fun <T : ManageableViewModel> T.observeAsState(): State<T> {
        val result = remember(this) { mutableStateOf(this, neverEqualPolicy()) }
        val listener = remember(