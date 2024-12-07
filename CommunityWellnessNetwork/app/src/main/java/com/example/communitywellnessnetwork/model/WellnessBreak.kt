package com.example.communitywellnessnetwork.model

class WellnessBreak (
    val breakId: String ,
    val userId: String,
    val breakType: String,       // e.g., "Stretching", "Meditation", "Breathing Exercise"
    val scheduledTime: String,   // Format: ISO 8601 (e.g., "2024-12-10T14:30:00Z")
    val durationInMinutes: Int
)