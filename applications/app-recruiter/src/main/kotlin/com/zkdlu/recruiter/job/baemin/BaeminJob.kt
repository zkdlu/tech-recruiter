package com.zkdlu.recruiter.job.baemin

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


class BaeminResponse<T>(
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
    val id: Long,
    @JsonProperty(value = "recruitNumber")
    val internalJobId: String,
    @JsonProperty(value = "recruitName")
    val title: String,
    @JsonProperty(value = "recruitCloseDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val until: LocalDateTime,
    @JsonProperty(value = "keywords")
    keywords: List<BaeminKeyword>? = listOf()
) {
    val keywords: List<BaeminKeyword> = keywords ?: listOf()

    val url: String
        get() = "https://career.woowahan.com/recruitment/${internalJobId}/detail"
}

class BaeminKeyword(
    @JsonProperty(value = "recruitItemGroupCode")
    val recruitItemGroupCode: String,
    @JsonProperty(value = "recruitItemCode")
    val recruitItemCode: String,
    @JsonProperty(value = "primary")
    val primary: Boolean,
)

