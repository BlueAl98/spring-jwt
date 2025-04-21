package com.example.security.controller

import com.example.security.dto.LoginDto
import com.example.security.dto.LoginResponseDto
import com.example.security.dto.RegisterDto
import com.example.security.services.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class UserController (private val userService: UserService){

    @PostMapping("/login")
    fun login(@RequestBody payload: LoginDto): LoginResponseDto {
        return userService.loginUser(payload)
    }


    @PostMapping("/register")
    fun register(@RequestBody payload: RegisterDto): LoginResponseDto {
        return userService.registerUser(payload)
    }

}