package com.zkdlu.recruiter.display

import com.zkdlu.recruiter.company.Company
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class DisplayApi {

    @GetMapping("/job-stats")
    fun getJobStats(): List<JobStats> {
        return Company.values()
            .map { company -> JobStats(company, 20) }
    }

    @GetMapping("/job-openings")
    fun getJobOpenings(): List<JobOpenings> {
        val until = LocalDateTime.of(2023, 1, 28, 0, 0)
        return listOf(
            JobOpenings("공고1", Company.Baemin, until, listOf("java")),
            JobOpenings("공고2", Company.Baemin, until, listOf("java", "spring")),
            JobOpenings("공고3", Company.Toss, until, listOf("kotlin")),
            JobOpenings("공고4", Company.Toss, until, listOf("react")),
            JobOpenings("공고5", Company.Toss, until, listOf("front")),
        )
    }
}