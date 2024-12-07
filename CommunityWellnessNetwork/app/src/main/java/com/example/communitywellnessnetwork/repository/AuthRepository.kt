package com.example.communitywellnessnetwork.repository


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await
import com.example.communitywellnessnetwork.model.User

class AuthRepository {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")

    /**
     * Sign up a new user with email and password, and store additional user details in Realtime Database.
     */
    suspend fun signUp(user: User): Result<FirebaseUser> {
        return try {
            // Create user with email and password in Firebase Authentication
            val authResult = firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).await()
            val firebaseUser = authResult.user

            // Store additional user details in Realtime Database
            firebaseUser?.uid?.let { uid ->
                val userMap = mapOf(
                    "uid" to uid,
                    "email" to user.email,
                    "name" to user.name
                )
                databaseReference.child(uid).setValue(userMap).await()
            }

            Result.success(firebaseUser!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    suspend fun login(email: String, password: String): Result<FirebaseUser> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.success(authResult.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    fun logout() {
        firebaseAuth.signOut()
    }

    fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
}
