package com.davidarutiunian.springbootapp.infrastructure.exceptions

import com.davidarutiunian.springbootapp.application.dto.ErrorCode
import com.davidarutiunian.springbootapp.application.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

interface ExceptionResponse {
    companion object {
        fun from(code: ErrorCode): ExceptionResponse = when (code) {
            ErrorCode.NOT_FOUND -> object : ExceptionResponse {
                override fun create(ex: Exception): ResponseEntity<ErrorDto> =
                    ExceptionResponseDelegate(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Resource not found").create(ex)
            }

            ErrorCode.VALIDATION_ERROR -> object : ExceptionResponse {
                override fun create(ex: Exception): ResponseEntity<ErrorDto> =
                    ExceptionResponseDelegate(ErrorCode.VALIDATION_ERROR, HttpStatus.BAD_REQUEST).create(ex)
            }

            ErrorCode.ENTITY_NOT_FOUND -> object : ExceptionResponse {
                override fun create(ex: Exception): ResponseEntity<ErrorDto> =
                    ExceptionResponseDelegate(ErrorCode.ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND).create(ex)
            }

            ErrorCode.DATA_INTEGRITY_VIOLATION -> object : ExceptionResponse {
                override fun create(ex: Exception): ResponseEntity<ErrorDto> =
                    ExceptionResponseDelegate(ErrorCode.DATA_INTEGRITY_VIOLATION, HttpStatus.BAD_REQUEST, "Data integrity violation").create(ex)
            }
        }
    }

    fun create(ex: Exception): ResponseEntity<ErrorDto>
}
