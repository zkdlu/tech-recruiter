package com.zkdlu.recruiter.job

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class JobApi(
    private val jobService: JobServiceFacade,
) {

    @GetMapping("/job-openings")
    fun getJobOpenings(
        size: Int = 10,
        page: Int = 0,
    ): List<JobOpenings> {
        return jobService.getJobs(page, size)
    }

    @GetMapping("/job-openings/{company}")
    fun getJobOpeningsByCompany(@PathVariable company: Company): List<JobOpenings> {
        return jobService.getJobsByCompany(company)
    }

    @GetMapping("/job-openings/stats")
    fun getJobStats(): List<JobStats> {
        return jobService.getJobStats()
    }
}