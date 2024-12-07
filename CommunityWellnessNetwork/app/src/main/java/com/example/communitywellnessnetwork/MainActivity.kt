package com.example.communitywellnessnetwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.communitywellnessnetwork.ui.theme.CommunityWellnessNetworkTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view using Jetpack Compose
        setContent {
            CommunityWellnessNetworkTheme {
                // Your UI Composables here, like the main screen
            }
        }

        // Example of Firebase Authentication (if needed)
        val auth = FirebaseAuth.getInstance()
        auth.addAuthStateListener {
            // Handle authentication state changes
        }
    }
}
