package com.davidarutiunian.springbootapp.domain.gateways

import com.davidarutiunian.springbootapp.domain.entities.Sex
import java.util.*

interface SexRepository {
    fun findAll(): Iterable<Sex>

    fun findByTitle(title: String): Optional<Sex>
}
