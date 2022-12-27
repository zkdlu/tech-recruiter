package com.zkdlu.recruiter.job.baemin

import com.fasterxml.jackson.annotation.JsonProperty


class BaeminResponse<T> private constructor(
    @JsonProperty("code")
    val code: String,
    @JsonProperty("message")
    val message: String,
    @JsonProperty("data")
    val data: T,
)