package com.zkdlu.recruiter.job.toss

import com.zkdlu.recruiter.job.Company
import com.zkdlu.recruiter.job.JobOpenings
import com.zkdlu.recruiter.job.JobService
import org.springframework.stereotype.Service

@Service
class TossJobService(
    private val tossClient: TossClient,
) : JobService {

    override fun getJobs(): List<JobOpenings> {
        return tossClient.getJobs()
            .map { job -> JobOpenings(Company.Toss, job.title, job.url, job.updatedAt, getKeywords(job.keyword)) }
    }

    private fun getKeywords(keywords: TossJobMeta): List<String> {
        return keywords.value?.split(",") ?: listOf()
    }
}