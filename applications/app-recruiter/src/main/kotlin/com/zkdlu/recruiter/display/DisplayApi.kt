package com.zkdlu.recruiter.display

import com.zkdlu.recruiter.job.Company
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DisplayApi {

    @GetMapping("/job-stats")
    fun getJobStats(): List<JobStats> {
        return Company.values()
            .map { company -> JobStats(company, 20) }
    }
}