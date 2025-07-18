package com.tharik.androidkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tharik.androidkt.presentation.App
import com.tharik.androidkt.presentation.ui.theme.BaseMVVMAndroidKtTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseMVVMAndroidKtTheme {
                App()
            }
        }
    }
}