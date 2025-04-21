package com.example.security.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val username: String = "",
    val password: String = "",

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id") // clave foránea
    val role: Rol
)
