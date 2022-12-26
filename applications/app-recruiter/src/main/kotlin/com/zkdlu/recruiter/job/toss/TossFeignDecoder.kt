package com.zkdlu.recruiter.job.toss

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.Decoder
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import java.lang.reflect.Type

class TossFeignDecoder(
    decoder: Decoder,
    private val objectMapper: ObjectMapper,
): ResponseEntityDecoder(decoder) {
    override fun decode(response: Response?, type: Type?): Any {
        return kotlin.runCatching {
            objectMapper.readValue<List<TossJob>>(
                response?.body()?.asInputStream(),
                objectMapper.typeFactory.constructCollectionType(MutableList::class.java, TossJob::class.java)
            )
        }.getOrElse { listOf() }
    }
}