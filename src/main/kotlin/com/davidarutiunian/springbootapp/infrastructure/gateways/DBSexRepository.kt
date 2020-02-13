package com.davidarutiunian.springbootapp.infrastructure.gateways

import com.davidarutiunian.springbootapp.infrastructure.entities.SexEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DBSexRepository : JpaRepository<SexEntity, Int> {
    fun findByTitle(title: String): Optional<SexEntity>
}
