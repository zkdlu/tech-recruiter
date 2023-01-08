package com.zkdlu.recruiter.job

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class JobOpenings(
    val company: Company,
    val name: String,
    val url: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val until: LocalDateTime,
    val tags: List<String> = listOf()
)