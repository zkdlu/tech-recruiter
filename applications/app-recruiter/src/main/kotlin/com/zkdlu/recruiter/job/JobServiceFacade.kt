package com.zkdlu.recruiter.job

import org.springframework.stereotype.Service

@Service
class JobServiceFacade(
    private val jobServices: List<JobService>
) {

    fun getJob(): List<JobOpenings> {
        return jobServices.flatMap { jobService -> jobService.getJobs() }
    }
}