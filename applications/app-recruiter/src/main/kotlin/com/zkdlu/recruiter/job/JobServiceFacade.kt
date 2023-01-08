package com.zkdlu.recruiter.job

import org.springframework.stereotype.Service

@Service
class JobServiceFacade(
    private val jobServices: List<JobService>,
    private val jobOpeningRepository: JopOpeningRepository
) {

    fun getJobs(): List<JobOpenings> {
        return jobOpeningRepository.findAll()
    }

    fun getJobsByCompany(company: Company): List<JobOpenings> {
        return jobOpeningRepository.findAllByCompany(company)
    }

    fun collectJobOpenings() {
        val jobOpenings = jobServices.flatMap { jobService -> jobService.getJobs() }

        jobOpeningRepository.saveAll(jobOpenings)
    }

    fun getJobStats(): List<JobStats> {
        return jobOpeningRepository.findAll()
            .groupBy { jobOpening -> jobOpening.company }
            .map { jobGroup -> JobStats(jobGroup.key, jobGroup.value.size) }
    }
}