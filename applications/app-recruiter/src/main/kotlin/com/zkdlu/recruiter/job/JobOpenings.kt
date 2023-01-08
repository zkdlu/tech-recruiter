package com.zkdlu.recruiter.job

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "JOB_OPENINGS")
class JobOpenings(
    @Enumerated(value = EnumType.STRING)
    val company: Company,
    @Column(name = "NAME", nullable = false)
    val name: String,
    @Column(name = "URL", nullable = false)
    val url: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val until: LocalDateTime,
    @Convert(converter = ListToStringConverter::class)
    val tags: List<String> = listOf(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("name must not empty")
        }
    }
}