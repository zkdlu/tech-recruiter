package com.zkdlu.recruiter.display

import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class DisplayApiTest {
    private lateinit var mockMvc: MockMvc
    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(DisplayApi())
            .build()
    }

    @Test
    fun `채용공고 조회 api`() {
        mockMvc.perform(get("/job-openings"))
            .andExpect(jsonPath("$[0].until", equalTo("2023-01-28 00:00:00")))
    }
}