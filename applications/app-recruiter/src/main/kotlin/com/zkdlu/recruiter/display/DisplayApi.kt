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
        return listOf(
            JobOpenings("공고1", Company.Baemin, LocalDateTime.MAX, listOf("java")),
            JobOpenings("공고2", Company.Baemin, LocalDateTime.MAX, listOf("java", "spring")),
            JobOpenings("공고3", Company.Toss, LocalDateTime.MAX, listOf("kotlin")),
            JobOpenings("공고4", Company.Toss, LocalDateTime.MAX, listOf("react")),
            JobOpenings("공고5", Company.Toss, LocalDateTime.MAX, listOf("front")),
        )
    }
}