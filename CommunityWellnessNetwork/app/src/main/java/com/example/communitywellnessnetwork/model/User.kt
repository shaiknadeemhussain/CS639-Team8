package com.example.communitywellnessnetwork.model

data class User(
    val userId: String,
    val name: String,
    val email: String,
    val role: String // e.g., "Office Worker", "Student", "Remote Employee"
)
