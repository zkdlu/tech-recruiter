package com.zkdlu.recruiter.job.baemin

import com.fasterxml.jackson.databind.type.TypeFactory
import feign.Response
import feign.codec.Decoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.core.ResolvableType
import java.lang.reflect.Type

class BaeminFeignConfig {

    @Bean
    fun decoder(messageConverters: ObjectFactory<HttpMessageConverters>,
                messageConverterCustomizer: ObjectProvider<HttpMessageConverterCustomizer>): BaeminFeignDecoder {
        return BaeminFeignDecoder(SpringDecoder(messageConverters, messageConverterCustomizer))
    }
}

class BaeminFeignDecoder(
    decoder: Decoder
): ResponseEntityDecoder(decoder) {
    override fun decode(response: Response?, type: Type?): Any {
        val originType = TypeFactory.rawClass(type)
        val genericType = ResolvableType.forClassWithGenerics(BaeminResponse::class.java, originType)

        return kotlin.runCatching {
            (super.decode(response, genericType.type) as BaeminResponse<*>).data!!
        }.getOrElse {
            super.decode(response, type)
        }
    }
}