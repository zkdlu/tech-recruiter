package com.zkdlu.recruiter.display

import com.zkdlu.recruiter.job.Company
import com.zkdlu.recruiter.job.JobServiceFacade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DisplayApi(
    private val jobServiceFacade: JobServiceFacade,
) {

    @GetMapping("/job-stats")
    fun getJobStats(): List<JobStats> {
        return Company.values()
            .map { company -> JobStats(company, 20) }
    }

    @GetMapping("/job-openings")
    fun getJobOpenings(): List<JobOpenings> {
        return jobServiceFacade.getJob()
            .map { job -> JobOpenings(job.title, job.company, job.until, job.url, job.keywords) }
    }
}