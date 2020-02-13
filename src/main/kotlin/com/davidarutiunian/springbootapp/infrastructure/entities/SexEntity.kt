package com.davidarutiunian.springbootapp.infrastructure.entities

import com.davidarutiunian.springbootapp.domain.entities.Sex
import javax.persistence.*

@Entity
@Table(name = "sex")
data class SexEntity(
    @Id
    @Column(name = "id_sex")
    @SequenceGenerator(name = "sex_seq_gen", sequenceName = "sex_id_sex_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sex_seq_gen")
    val id: Int,
    val title: String
)

fun SexEntity.toSex() = Sex(
    id = this.id.toLong(),
    title = this.title
)

fun Sex.toSexEntity() = SexEntity(
    id = this.id.toInt(),
    title = this.title
)
