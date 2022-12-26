package com.zkdlu.recruiter.job.toss

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TossJobServiceTest @Autowired constructor(
    val tossJobService: TossJobService
) {


    @Test
    fun name() {
        val jobs = tossJobService.getJobs()
        println(jobs)
    }
}