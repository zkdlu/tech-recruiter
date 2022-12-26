package com.zkdlu.recruiter.job.toss

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TossFeignConfig(
    private val messageConverters: ObjectFactory<HttpMessageConverters>,
    private val messageConverterCustomizer: ObjectProvider<HttpMessageConverterCustomizer>,
    private val objectMapper: ObjectMapper,
) {
    @Bean
    fun decoder(): TossFeignDecoder {
        return TossFeignDecoder(SpringDecoder(messageConverters, messageConverterCustomizer), objectMapper)
    }
}