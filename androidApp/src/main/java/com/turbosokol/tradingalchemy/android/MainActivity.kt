
package com.turbosokol.tradingalchemy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.turbosokol.sharedfront.ui.MainView
import com.turbosokol.sharedfront.util.ApplicationViewModel
import org.koin.java.KoinJavaComponent.inject

class MainActivity : ComponentActivity() {
    val appViewModel: ApplicationViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Box(modifier = Modifier.padding(16.dp)) {
               MainView(viewModel = appViewModel)
           }
        }
    }
}
