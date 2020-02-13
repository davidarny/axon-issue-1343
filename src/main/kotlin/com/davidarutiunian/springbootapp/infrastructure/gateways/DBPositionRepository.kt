package com.davidarutiunian.springbootapp.infrastructure.gateways

import com.davidarutiunian.springbootapp.infrastructure.entities.PositionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DBPositionRepository: JpaRepository<PositionEntity, Int> {
    fun findByTitle(title: String): Optional<PositionEntity>
}
