package com.davidarutiunian.springbootapp.infrastructure.interactors

import com.davidarutiunian.springbootapp.application.exceptions.PositionNotFoundException
import com.davidarutiunian.springbootapp.application.exceptions.SexNotFoundException
import com.davidarutiunian.springbootapp.domain.entities.Employee
import com.davidarutiunian.springbootapp.domain.entities.Position
import com.davidarutiunian.springbootapp.domain.gateways.EmployeeRepository
import com.davidarutiunian.springbootapp.domain.gateways.PositionRepository
import com.davidarutiunian.springbootapp.domain.gateways.SexRepository
import com.davidarutiunian.springbootapp.domain.usecases.HrUseCase
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class HrInteractor(
    private val sexRepository: SexRepository,
    private val employeeRepository: EmployeeRepository,
    private val positionRepository: PositionRepository
) : HrUseCase {
    @Transactional
    override fun createEmployee(employee: Employee): Long {
        employee.position = positionRepository
            .findByTitle(employee.position.title)
            .orElseThrow { PositionNotFoundException("Position with title '${employee.position.title}' not found") }
        employee.sex = sexRepository
            .findByTitle(employee.sex.title)
            .orElseThrow { SexNotFoundException("Sex with title '${employee.sex.title}' not found") }
        return employeeRepository.save(employee)
    }

    override fun findAllEmployees(): Iterable<Employee> = employeeRepository.findAll()

    override fun findAllPositions(): Iterable<Position> = positionRepository.findAll()
}
