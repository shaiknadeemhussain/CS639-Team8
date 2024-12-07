package com.example.communitywellnessnetwork.model

data class BreakAnalytics(
    val userId: String,
    val totalBreaksTaken: Int,
    val averageBreakDuration: Int, // In minutes
    val missedBreaks: Int
)
