package com.zkdlu.recruiter.job

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JobApi(
    private val jobService: JobServiceFacade,
) {

    @GetMapping("/job-openings")
    fun getJobOpenings(): List<JobOpenings> {
        return jobService.getJob()
    }

    @GetMapping("/job-openings/collect")
    fun collectJobOpenings() {
        jobService.collectJobOpenings()
    }
}