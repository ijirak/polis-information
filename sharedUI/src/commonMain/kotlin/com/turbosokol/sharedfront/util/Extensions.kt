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
        val listener = remember(this) {
            object : ObservableObject.ChangeTracking.Listener {
                override fun onObjectDidChange() {
                    result.value = this@observeAsState
                }
            }
        }
        DisposableEffect(this) {
            val token = changeTracking.addListener(listener)
            result.value = this@observeAsState

            onDispose {
                token.cancel()
            }
        }
        return result
    }

    @Composable
    internal fun <T> ObservableProperty<T>.observeAsState(): State<T> {
        val result = remember(this) { mutableStateOf(value, neverEqualPolicy()) }
        val listener = remember(this) {
            object : ObservableProperty.Listener<T> {
                override fun valueDidChange(oldValue: T, newValue: T) {
                    result.value = newValue
                }
            }
        }
        DisposableEffect(this) {
            val token = addListener(listener)
            result.value = value

            onDispose {
                toke