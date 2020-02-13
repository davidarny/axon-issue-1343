package com.davidarutiunian.springbootapp.infrastructure.exceptions

import com.davidarutiunian.springbootapp.application.dto.ErrorCode
import com.davidarutiunian.springbootapp.application.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.time.LocalDateTime

class ExceptionResponseDelegate(
    private val code: ErrorCode,
    private val status: HttpStatus,
    private val message: String? = null
) : ExceptionResponse {
    override fun create(ex: Exception): ResponseEntity<ErrorDto> {
        val now = LocalDateTime.now().toString()
        val dto = ErrorDto(code, status.reasonPhrase, message ?: ex.message, now, status.value())
        return ResponseEntity(dto, status)
    }
}
