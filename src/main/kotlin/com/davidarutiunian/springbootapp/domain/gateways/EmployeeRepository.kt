package com.davidarutiunian.springbootapp.domain.gateways

import com.davidarutiunian.springbootapp.domain.entities.Employee

interface EmployeeRepository {
    fun findAll(): Iterable<Employee>

    fun save(employee: Employee): Long
}
