package com.davidarutiunian.springbootapp.application.dto

data class ErrorDto(
    val code: ErrorCode?,
    val error: String?,
    val message: String?,
    val timestamp: String?,
    val status: Int?
)
