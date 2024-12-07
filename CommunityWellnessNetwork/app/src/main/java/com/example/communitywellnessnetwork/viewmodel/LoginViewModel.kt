package com.example.communitywellnessnetwork.viewmodel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.communitywellnessnetwork.model.User
import com.example.communitywellnessnetwork.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class SignUpViewModel(private val authRepository: AuthRepository) : ViewModel() {

    // LiveData to observe the sign-up result
    private val _signUpResult = MutableLiveData<Result<FirebaseUser>>()
    val signUpResult: LiveData<Result<FirebaseUser>> = _signUpResult

    // LiveData to indicate loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Method to sign up the user
    fun signUp(user: User) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val result = authRepository.signUp(user)
                _signUpResult.value = result
            } catch (e: Exception) {
                _signUpResult.value = Result.failure(e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}
