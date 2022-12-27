package com.zkdlu.recruiter.job.baemin

import org.springframework.stereotype.Service

@Service
class BaeminJobService(
    private val baeminClient: BaeminClient,
) {

    fun todo() {
        val codes = baeminClient.getBaeminCodes()

        println(codes)
    }
}