package com.davidarutiunian.springbootapp.infrastructure.gateways

import com.davidarutiunian.springbootapp.infrastructure.entities.EmployeeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DBEmployeeRepository : JpaRepository<EmployeeEntity, Int>
