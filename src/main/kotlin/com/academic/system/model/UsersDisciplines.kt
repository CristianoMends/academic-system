package com.academic.system.model

import jakarta.persistence.*

@Entity
data class UsersDisciplines(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user:Users,

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    val discipline: Disciplines
)
