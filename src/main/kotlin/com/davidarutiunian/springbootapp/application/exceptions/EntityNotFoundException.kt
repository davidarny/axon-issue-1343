package com.davidarutiunian.springbootapp.application.exceptions

open class EntityNotFoundException(message: String? = "Entity not found") : RuntimeException(message)
