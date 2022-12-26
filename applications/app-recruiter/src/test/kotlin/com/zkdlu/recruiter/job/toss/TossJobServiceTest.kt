package com.zkdlu.recruiter.job.toss

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class TossJobServiceTest @Autowired constructor(
    val tossJobService: TossJobService,
    val objectMapper: ObjectMapper,
) {


    @Test
    fun name() {
        val jobs = tossJobService.getJobs()
        println(jobs)
    }

    @Test
    fun jackson() {
        val json = "{\"time\":\"2022-12-22T01:35:54-05:00\"}"

        val value = objectMapper.readValue(json, Target::class.java)

        println(value)
    }
}

class Target(
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss-05:00")
    val time: LocalDateTime
)