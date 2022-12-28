package com.zkdlu.recruiter.job

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JobApi(
    private val jobService: JobServiceFacade,
) {

    @GetMapping("/jobs")
    fun getJobs(): List<Job> {
        return jobService.getJob()
    }
}