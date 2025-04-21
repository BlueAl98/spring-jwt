package com.example.security.controller

import com.example.security.dto.LoginResponseDto
import com.example.security.dto.RegisterDto
import com.example.security.model.User
import com.example.security.services.HashService
import com.example.security.services.TokenService
import com.example.security.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/test")
class TestController(
    private val hashService: HashService,
    private val tokenService: TokenService,
    private val userService: UserService
) {

    @GetMapping
    fun hashText():Boolean {
        val texto = "NAJIB"
        val testHasheado =  hashService.hashBcrypt(texto)
        val randomText = "pepe"

        return hashService.checkBcrypt(texto, testHasheado)

    }


}