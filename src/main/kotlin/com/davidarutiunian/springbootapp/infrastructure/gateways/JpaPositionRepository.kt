package com.davidarutiunian.springbootapp.infrastructure.gateways

import com.davidarutiunian.springbootapp.domain.entities.Position
import com.davidarutiunian.springbootapp.domain.gateways.PositionRepository
import com.davidarutiunian.springbootapp.infrastructure.entities.toPosition
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class JpaPositionRepository(private val dbPositionRepository: DBPositionRepository) : PositionRepository {
    override fun findAll(): Iterable<Position> = dbPositionRepository.findAll().map { it.toPosition() }

    override fun findByTitle(title: String): Optional<Position> {
        val position = dbPositionRepository.findByTitle(title)
        if (position.isPresent) {
            return Optional.of(position.get().toPosition())
        }
        return Optional.empty()
    }
}
