package com.davidarutiunian.springbootapp.domain.usecases

import com.davidarutiunian.springbootapp.domain.entities.Employee
import com.davidarutiunian.springbootapp.domain.entities.Position

interface HrUseCase {
    fun createEmployee(employee: Employee): Long

    fun findAllEmployees(): Iterable<Employee>

    fun findAllPositions(): Iterable<Position>
}
