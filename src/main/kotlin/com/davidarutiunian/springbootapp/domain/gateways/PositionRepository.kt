package com.davidarutiunian.springbootapp.domain.gateways

import com.davidarutiunian.springbootapp.domain.entities.Position
import java.util.*

interface PositionRepository {
    fun findAll(): Iterable<Position>

    fun findByTitle(title: String): Optional<Position>
}
