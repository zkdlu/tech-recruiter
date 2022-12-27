package com.zkdlu.recruiter.job.baemin

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Component
@FeignClient(
    name = "baemin",
    url = "https://career.woowahan.com/w1",
    configuration = [BaeminFeignConfig::class]
)
interface BaeminClient {
    @GetMapping("/common/common-item/all")
    fun getBaeminCodes(): BaeminResponse<List<BaeminJobCode>>

    @GetMapping("/job-groups/statistics")
    fun getBaeminJobGroupStats(): BaeminResponse<List<BaeminJobGroupStat>>

    @GetMapping("/recruits?recruitCampaignSeq=0&jobGroupCodes=BA005001&sort=updateDate%2Cdesc")
    fun getJobs(
        @RequestParam("category") category: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int): BaeminResponse<BaeminJobs>
}