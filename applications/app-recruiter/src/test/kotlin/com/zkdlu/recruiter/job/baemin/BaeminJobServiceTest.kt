package com.zkdlu.recruiter.job.baemin

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BaeminJobServiceTest @Autowired constructor(
    private val baeminJobService: BaeminJobService,
) {

    @Test
    fun getCodes() {
        baeminJobService.todo()
    }
}