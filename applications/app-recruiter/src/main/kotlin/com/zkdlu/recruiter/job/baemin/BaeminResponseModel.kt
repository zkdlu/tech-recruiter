package com.zkdlu.recruiter.job.baemin

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


class BaeminResponse<T> (
    @JsonProperty(value = "code")
    val code: String,
    @JsonProperty(value = "message")
    val message: String,
    @JsonProperty(value = "data")
    val data: T,
)

class BaeminJobCode(
    @JsonProperty(value = "code")
    val code: String,
    @JsonProperty(value = "text")
    val text: String
)

class BaeminJobGroupStat(
    @JsonProperty(value = "recruitItemCode")
    val code: String,
    @JsonProperty(value = "recruitCount")
    val count: Int,
)

class BaeminJobs(
    @JsonProperty(value = "totalSize")
    val totalSize: Int,
    @JsonProperty(value = "list")
    val list: List<BaeminJob> = listOf()
)

class BaeminJob(
    @JsonProperty(value = "recruitSeq")
    val seq: Long,
    @JsonProperty(value = "recruitNumber")
    val id: String,
    @JsonProperty(value = "recruitName")
    val title: String,
    @JsonProperty(value = "recruitCloseDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val until: LocalDateTime,
    @JsonProperty(value = "keywords")
    val keywords: List<BaeminKeyword>? = listOf()
)

class BaeminKeyword(
    @JsonProperty(value = "recruitItemGroupCode")
    val recruitItemGroupCode: String,
    @JsonProperty(value = "recruitItemCode")
    val recruitItemCode: String,
    @JsonProperty(value = "primary")
    val primary: Boolean,
)

