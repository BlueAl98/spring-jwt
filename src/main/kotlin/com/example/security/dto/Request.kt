package com.example.security.dto

data class RegisterDto(
    val name: String,
    val password: String,
    val roleId: Long
)

data class LoginDto(
    val name: String,
    val password: String
)
