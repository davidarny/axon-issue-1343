package com.davidarutiunian.springbootapp.infrastructure.gateways

import com.davidarutiunian.springbootapp.domain.entities.Sex
import com.davidarutiunian.springbootapp.domain.gateways.SexRepository
import com.davidarutiunian.springbootapp.infrastructure.entities.toSex
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class JpaSexRepository(private val dbSexRepository: DBSexRepository) : SexRepository {
    override fun findAll(): Iterable<Sex> = dbSexRepository.findAll().map { it.toSex() }

    override fun findByTitle(title: String): Optional<Sex> {
        val sex = dbSexRepository.findByTitle(title)
        if (sex.isPresent) {
            return Optional.of(sex.get().toSex())
        }
        return Optional.empty()
    }
}
