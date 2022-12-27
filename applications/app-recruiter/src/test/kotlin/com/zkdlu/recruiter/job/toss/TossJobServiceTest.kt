package com.zkdlu.recruiter.job.toss

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

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

        val module = JavaTimeModule()
        objectMapper.registerModule(module)
        val value = objectMapper.readValue(json, Target::class.java)

        println(value)
    }

    @Test
    fun datetimeTest() {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val date = ZonedDateTime.parse("2022-01-01T10:10:10-05:00", formatter)

        println(date)
    }
}

class Target(
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[xxx]")
    val time: ZonedDateTime
)