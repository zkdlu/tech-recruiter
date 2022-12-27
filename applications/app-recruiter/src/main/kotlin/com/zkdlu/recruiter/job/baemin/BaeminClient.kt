package com.zkdlu.recruiter.job.baemin

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping

@Component
@FeignClient(name = "baemin", url = "https://career.woowahan.com/w1", configuration = [BaeminFeignConfig::class])
interface BaeminClient {
    @GetMapping("/common/common-item/all")
    fun getBaeminCodes(): List<BaeminCode>

}