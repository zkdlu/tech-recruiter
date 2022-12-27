package com.zkdlu.recruiter.job.baemin

import org.springframework.stereotype.Service

@Service
class BaeminJobService(
    private val baeminClient: BaeminClient,
) {

    fun getJobs(): List<BaeminJob> {
        val codes = getCodes()
        val groupStats = getGroupStats()

        return groupStats.map { stat -> getJobs(stat) }
            .flatMap { jobs -> jobs.list }
    }

    private fun getJobs(jobGroupStat: BaeminJobGroupStat): BaeminJobs {
        return baeminClient.getJobs("jobGroupCodes:${jobGroupStat.code}", 0, jobGroupStat.count).data
    }

    private fun getGroupStats(): List<BaeminJobGroupStat> {
        return baeminClient.getBaeminJobGroupStats().data
    }

    private fun getCodes(): List<BaeminJobCode> {
        return baeminClient.getBaeminCodes().data
    }
}