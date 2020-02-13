package com.davidarutiunian.springbootapp.application.dto

import com.davidarutiunian.springbootapp.domain.entities.Sex

data class SexDto(
    val id: Long,
    val title: String
)

fun SexDto.toSex() = Sex(
    id = this.id,
    title = this.title
)

fun Sex.toSexDto() = SexDto(
    id = this.id,
    title = this.title
)
