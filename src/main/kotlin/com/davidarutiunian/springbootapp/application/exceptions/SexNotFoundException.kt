package com.davidarutiunian.springbootapp.application.exceptions

class SexNotFoundException(message: String? = "Sex not found") : EntityNotFoundException(message)
