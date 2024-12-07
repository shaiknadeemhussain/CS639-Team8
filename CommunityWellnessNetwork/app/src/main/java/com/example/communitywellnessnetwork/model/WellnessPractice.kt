package com.example.communitywellnessnetwork.model
data class WellnessPractice(
    val practiceId: String,
    val name: String,
    val description: String,
    val category: String // e.g., "Physical", "Mental", "Breathing"
)
