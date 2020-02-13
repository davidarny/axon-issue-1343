package com.davidarutiunian.springbootapp.application.dto

import com.davidarutiunian.springbootapp.domain.entities.Employee
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class EmployeeDto(
    val id: Long,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val password: String,
    val birthday: String,
    val email: String,
    var position: PositionDto,
    var sex: SexDto
)

fun Employee.toEmployeeDto() = EmployeeDto(
    id = this.id,
    firstName = this.firstName,
    middleName = this.middleName,
    lastName = this.lastName,
    birthday = this.birthday.format(DateTimeFormatter.ISO_DATE),
    sex = this.sex.toSexDto(),
    email = this.email,
    password = this.password,
    position = this.position.toPositionDto()
)

fun EmployeeDto.toEmployee() = Employee(
    id = this.id,
    firstName = this.firstName,
    middleName = this.middleName,
    lastName = this.lastName,
    position = this.position.toPosition(),
    password = this.password,
    email = this.email,
    sex = this.sex.toSex(),
    birthday = LocalDate.from(DateTimeFormatter.ISO_DATE.parse(this.birthday))
)
