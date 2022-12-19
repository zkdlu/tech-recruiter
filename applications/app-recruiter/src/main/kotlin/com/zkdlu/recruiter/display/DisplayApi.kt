package com.zkdlu.recruiter.display

import com.zkdlu.recruiter.company.Company
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DisplayApi {

    @GetMapping("/job-openings")
    fun getJobOpenings(): List<JobOpenings> {
        return Company.values()
            .map { company -> JobOpenings(company, 20) }
    }
}