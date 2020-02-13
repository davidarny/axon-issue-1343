package com.davidarutiunian.springbootapp.infrastructure.rest

import com.davidarutiunian.springbootapp.application.dto.EmployeeDto
import com.davidarutiunian.springbootapp.application.dto.toEmployee
import com.davidarutiunian.springbootapp.domain.usecases.HrUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1.0/hr")
class HrController(private val hrUseCase: HrUseCase) {
    @GetMapping
    fun getAllEmployees() = ResponseEntity.ok(hrUseCase.findAllEmployees())

    @PostMapping
    fun createEmployee(@RequestBody employeeDto: EmployeeDto) = ResponseEntity.ok(hrUseCase.createEmployee(employeeDto.toEmployee()))
}
