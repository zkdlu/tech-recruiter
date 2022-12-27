package com.zkdlu.recruiter.job.toss

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class TossJob(
    @JsonProperty(value = "absolute_url")
    val url: String,
    @JsonProperty(value = "id")
    val id: Long,
    @JsonProperty(value = "internal_job_id")
    val internalJobId: Long,
    @JsonProperty(value = "location")
    val location: TossJobLocation,
    @JsonProperty(value = "title")
    val title: String,
    @JsonProperty(value = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[xxx]")
    val updatedAt: LocalDateTime,
    @JsonProperty(value = "metadata")
    val metadata: List<TossJobMeta> = mutableListOf()
)

class TossJobLocation(
    @JsonProperty(value = "name")
    val name: String,
)

class TossJobMeta(
    @JsonProperty(value = "id")
    val id: Long,
    @JsonProperty(value = "name")
    val name: String,
    @JsonProperty(value = "value")
    val value: String?,
    @JsonProperty(value = "value_type")
    val valueType: String,
)