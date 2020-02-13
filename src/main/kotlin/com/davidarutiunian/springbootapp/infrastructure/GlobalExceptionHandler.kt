package com.davidarutiunian.springbootapp.infrastructure

import com.davidarutiunian.springbootapp.application.dto.ErrorCode
import com.davidarutiunian.springbootapp.infrastructure.exceptions.ExceptionResponse
import javassist.NotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException
import javax.xml.bind.ValidationException

@ControllerAdvice
@RestController
class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(ex: NotFoundException) =
        ExceptionResponse.from(ErrorCode.NOT_FOUND).create(ex)

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFound(ex: EntityNotFoundException) =
        ExceptionResponse.from(ErrorCode.ENTITY_NOT_FOUND).create(ex)

    @ExceptionHandler(ValidationException::class)
    fun handleValidationException(ex: ValidationException) =
        ExceptionResponse.from(ErrorCode.VALIDATION_ERROR).create(ex)

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(ex: DataIntegrityViolationException) =
        ExceptionResponse.from(ErrorCode.DATA_INTEGRITY_VIOLATION).create(ex)
}
