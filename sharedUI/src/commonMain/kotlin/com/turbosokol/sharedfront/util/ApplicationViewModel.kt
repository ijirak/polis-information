package com.turbosokol.sharedfront.util

import org.brightify.hyperdrive.multiplatformx.BaseViewModel

/***
 *If this code runs it created by Evgenii Sokol.
 *If it doesn’t work, I don’t know who created it.
 ***/

class ApplicationViewModel: BaseViewModel() {
    val navTabs = listOf(NavTab.Calculator, NavTab.Actives, NavTab.Deals, NavTab.Correction, NavTab.Settings)
    var selectedTab: NavTab by 