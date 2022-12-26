package com.zkdlu.recruiter.display

import com.fasterxml.jackson.annotation.JsonFormat
import com.zkdlu.recruiter.company.Company
import java.time.LocalDateTime

class JobOpenings(
    val name: String,
    val company: Company,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val until: LocalDateTime,
    val tags: List<String> = listOf()
)