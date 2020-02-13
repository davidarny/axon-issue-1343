package com.davidarutiunian.springbootapp.application.exceptions

class PositionNotFoundException(message: String? = "Position not found") : EntityNotFoundException(message)
