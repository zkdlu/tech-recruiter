package com.zkdlu.recruiter.job

import java.time.LocalDateTime

class Job(
    val company: Company,
    val title: String,
    val until: LocalDateTime,
    val url: String,
    val keywords: List<String> = listOf(),
)