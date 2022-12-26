package com.zkdlu.recruiter.job.toss

import org.springframework.stereotype.Service

@Service
class TossJobService(
    private val tossClient: TossClient,
) {

    fun getJobs() = tossClient.getJobs()
}