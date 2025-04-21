package com.example.security.services

import com.example.security.configuration.ApiException
import com.example.security.dto.LoginDto
import com.example.security.dto.LoginResponseDto
import com.example.security.dto.RegisterDto
import com.example.security.model.User
import com.example.security.repository.UserRepository
import org.springframework.context.annotation.Lazy
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val hashService: HashService,
    @Lazy private val tokenService: TokenService
    ) {

    fun registerUser(registerUser: RegisterDto): LoginResponseDto{

        userRepository.findByUsername(registerUser.name)?.let {
            throw ApiException("Name already exists", HttpStatus.NOT_ACCEPTABLE)
        }

        val user = User(
            username = registerUser.name ,
            password = hashService.hashBcrypt(registerUser.password)
        )

        userRepository.save(user)

        return LoginResponseDto(
            token = tokenService.createToken(user),
        )
    }



    fun loginUser(loginUser: LoginDto): LoginResponseDto{

       val user =  userRepository.findByUsername(loginUser.name)?:
            throw ApiException("user doesnt exists", HttpStatus.NOT_ACCEPTABLE)

        if (!hashService.checkBcrypt(loginUser.password, user.password)) {
            throw ApiException("password incorrect ", HttpStatus.UNAUTHORIZED)
        }

        return LoginResponseDto(
            token = tokenService.createToken(user),
        )
    }


    fun findById(id: Long): User? {
        return userRepository.findById(id).orElseThrow{null}
    }

}