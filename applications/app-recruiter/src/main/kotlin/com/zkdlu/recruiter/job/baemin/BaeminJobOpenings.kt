package com.zkdlu.recruiter.job.baemin

import com.zkdlu.recruiter.job.Company
import java.time.LocalDateTime

class BaeminJobOpenings(
    val company: Company,
    val id: Long,
    val title: String,
    val until: LocalDateTime,
    val url: String,
    val keywords: List<String> = listOf(),
)