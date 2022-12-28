package com.zkdlu.recruiter.job

import com.zkdlu.recruiter.job.baemin.BaeminJobService
import com.zkdlu.recruiter.job.toss.TossJobMeta
import com.zkdlu.recruiter.job.toss.TossJobService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class JobServiceFacade(
    private val tossJobService: TossJobService,
    private val baeminJobService: BaeminJobService
) {

    fun getJob(): List<Job> {
        val tossJobs = tossJobService.getJobs()
            .map { tossJob -> Job(Company.Toss, tossJob.title, LocalDateTime.MAX, tossJob.url, getKeywords(tossJob.keyword)) }

        val baeminJobs = baeminJobService.getJobs()
            .map { baeminJob -> Job(Company.Baemin, baeminJob.title, baeminJob.until, baeminJob.url, baeminJob.keywords) }

        return listOf(
            tossJobs,
            baeminJobs
        ).flatten()
    }

    private fun getKeywords(keywords: TossJobMeta): List<String> {
        return keywords.value?.split(",") ?: listOf()
    }
}