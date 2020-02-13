package com.davidarutiunian.springbootapp.infrastructure.gateways

import com.davidarutiunian.springbootapp.domain.entities.Employee
import com.davidarutiunian.springbootapp.domain.gateways.EmployeeRepository
import com.davidarutiunian.springbootapp.infrastructure.entities.toEmployee
import com.davidarutiunian.springbootapp.infrastructure.entities.toEmployeeEntity
import org.springframework.stereotype.Repository

@Repository
class JpaEmployeeRepository(private val dbEmployeeRepository: DBEmployeeRepository) : EmployeeRepository {
    override fun findAll(): Iterable<Employee> = dbEmployeeRepository.findAll().map { it.toEmployee() }

    override fun save(employee: Employee): Long {
        val entity = dbEmployeeRepository.save(employee.toEmployeeEntity())
        return entity.id.toLong()
    }
}
