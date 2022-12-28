package com.zkdlu.recruiter.job

import java.time.LocalDateTime

class Job(
    val company: Company,
    val companyJobId: Long,
    val title: String,
    val until: LocalDateTime,
    val keywords: List<String> = listOf(),
)