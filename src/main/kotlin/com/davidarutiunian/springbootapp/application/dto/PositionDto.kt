package com.davidarutiunian.springbootapp.application.dto

import com.davidarutiunian.springbootapp.domain.entities.Position

data class PositionDto(
    val id: Long,
    val title: String
)

fun PositionDto.toPosition() = Position(
    id = this.id,
    title = this.title
)

fun Position.toPositionDto() = PositionDto(
    id = this.id,
    title = this.title
)
