package com.zkdlu.recruiter.display

import com.zkdlu.recruiter.company.Company
import java.time.LocalDateTime

class JobOpenings(
    val name: String,
    val company: Company,
    val until: LocalDateTime,
    val tags: List<String> = listOf()
)