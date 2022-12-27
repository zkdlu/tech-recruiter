package com.zkdlu.recruiter.job.toss

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean

class TossFeignConfig {
    @Bean
    fun decoder(messageConverters: ObjectFactory<HttpMessageConverters>,
                messageConverterCustomizer: ObjectProvider<HttpMessageConverterCustomizer>,
                objectMapper: ObjectMapper): TossFeignDecoder {
        return TossFeignDecoder(SpringDecoder(messageConverters, messageConverterCustomizer), objectMapper)
    }
}