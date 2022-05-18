package com.example.user.repository

import com.example.user.models.Token
import com.example.user.storage.UserStorage

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveOnboardingState() {
        userStorage.saveState()
    }
    override fun getOnboardingState(): Boolean = userStorage.takeState()

    override fun saveToken(token: Token) {
        userStorage.saveToken(token)
    }

    override fun getToken(): String = userStorage.getToken()
}
