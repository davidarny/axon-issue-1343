package com.davidarutiunian.springbootapp.infrastructure.entities

import com.davidarutiunian.springbootapp.domain.entities.Employee
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "employee")
data class EmployeeEntity(
    @Id
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "employee_id_employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @Column(name = "id_employee", insertable = false, updatable = false)
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_position", nullable = false)
    val position: PositionEntity,
    val password: String,
    val birthday: LocalDate,
    val email: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sex", nullable = false)
    val sex: SexEntity
)

fun EmployeeEntity.toEmployee() = Employee(
    id = this.id.toLong(),
    middleName = this.middleName,
    lastName = this.lastName,
    position = this.position.toPosition(),
    password = this.password,
    email = this.email,
    sex = this.sex.toSex(),
    birthday = this.birthday,
    firstName = this.firstName
)

fun Employee.toEmployeeEntity() = EmployeeEntity(
    id = this.id.toInt(),
    firstName = this.firstName,
    birthday = this.birthday,
    sex = this.sex.toSexEntity(),
    email = this.email,
    password = this.password,
    position = this.position.toPositionEntity(),
    lastName = this.lastName,
    middleName = this.middleName
)
