package com.davidarutiunian.springbootapp.infrastructure.entities

import com.davidarutiunian.springbootapp.domain.entities.Position
import javax.persistence.*

@Entity
@Table(name = "position")
data class PositionEntity(
    @Id
    @Column(name = "id_position")
    @SequenceGenerator(name = "position_seq_gen", sequenceName = "position_id_position_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq_gen")
    val id: Int,
    val title: String
)

fun PositionEntity.toPosition() = Position(
    id = this.id.toLong(),
    title = this.title
)

fun Position.toPositionEntity() = PositionEntity(
    id = this.id.toInt(),
    title = this.title
)
