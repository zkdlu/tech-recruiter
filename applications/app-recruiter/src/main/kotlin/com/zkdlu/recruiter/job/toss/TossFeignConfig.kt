package com.zkdlu.recruiter.job.toss

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.Decoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import java.lang.reflect.Type

class TossFeignConfig {
    @Bean
    fun decoder(messageConverters: ObjectFactory<HttpMessageConverters>,
                messageConverterCustomizer: ObjectProvider<HttpMessageConverterCustomizer>,
                objectMapper: ObjectMapper): TossFeignDecoder {
        return TossFeignDecoder(SpringDecoder(messageConverters, messageConverterCustomizer), objectMapper)
    }
}

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