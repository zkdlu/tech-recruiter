package com.zkdlu.recruiter.job.toss

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping

@Component
@FeignClient(name = "toss", url = "https://static.toss.im/greenhouse/jobs/jobs.json?v=2", configuration = [TossFeignConfig::class])
interface TossClient {
    @GetMapping(produces = ["application/json"])
    fun getJobs(): List<TossJob>
}