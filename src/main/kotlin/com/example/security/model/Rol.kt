package com.example.security.model

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Rol(
    @Id
    val id: Long = 0,
    val name: String = ""
)
