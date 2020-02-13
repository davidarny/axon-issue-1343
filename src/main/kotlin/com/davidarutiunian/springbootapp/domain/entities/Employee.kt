package com.davidarutiunian.springbootapp.domain.entities

import java.time.LocalDate

data class Employee(
    val id: Long,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val password: String,
    val birthday: LocalDate,
    val email: String,
    var position: Position,
    var sex: Sex
)
