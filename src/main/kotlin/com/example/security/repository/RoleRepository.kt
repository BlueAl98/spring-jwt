package com.example.security.repository

import com.example.security.dto.LoginDto
import com.example.security.model.Rol
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Rol, Long>