package com.zkdlu.recruiter.job

import org.springframework.stereotype.Service

@Service
class JobServiceFacade(
    private val jobServices: List<JobService>,
    private val jobOpeningRepository: JopOpeningRepository
) {

    fun getJob(): List<JobOpenings> {
        return jobOpeningRepository.findAll()
    }

    fun collectJobOpenings() {
        val jobOpenings = jobServices.flatMap { jobService -> jobService.getJobs() }

        jobOpeningRepository.saveAll(jobOpenings)
    }
}