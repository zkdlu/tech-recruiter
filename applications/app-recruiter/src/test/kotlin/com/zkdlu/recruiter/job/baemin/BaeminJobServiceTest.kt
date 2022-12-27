package com.zkdlu.recruiter.job.baemin

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BaeminJobServiceTest @Autowired constructor(
    private val baeminJobService: BaeminJobService,
    private val objectMapper: ObjectMapper,
) {

    @Test
    fun getCodes() {
        val jobs = baeminJobService.getJobs()

        println(jobs)
    }

    @Test
    fun genericObjectMapperTest() {
        val json = "{\"data\":{\"number\":1}}"

        val outer = objectMapper.readValue<Outer<Any>>(
            json,
            objectMapper.typeFactory.constructParametricType(Outer::class.java, Inner::class.java)
        );

        println(outer)
    }
}

class Outer<T>(
    val data: T
)

class Inner(
    val number: Int
)