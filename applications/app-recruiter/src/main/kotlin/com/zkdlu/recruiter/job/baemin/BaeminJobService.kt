package com.zkdlu.recruiter.job.baemin

import com.zkdlu.recruiter.job.Company
import org.springframework.stereotype.Service

@Service
class BaeminJobService(
    private val baeminClient: BaeminClient,
) {

    fun getJobs(): List<BaeminJobOpenings> {
        val codes = getCodes()
        val groupStats = getGroupStats()

        return groupStats.map { stat -> getJobs(stat) }
            .flatMap { jobs -> jobs.list }
            .map { job -> BaeminJobOpenings(Company.Baemin, job.id, job.title, job.until, getMatchedKeywords(job.keywords, codes)) }
    }

    private fun getMatchedKeywords(keywords: List<BaeminKeyword>, codes: List<BaeminJobCode>): List<String> {
        if (keywords == null) {
            return listOf()
        }

        if (keywords.none { keyword -> containsKeyword(codes, keyword.recruitItemCode)}) {
            return listOf()
        }

        return keywords.map { keyword -> codes.first { it.code == keyword.recruitItemCode }.text }
    }

    private fun containsKeyword(codes: List<BaeminJobCode>, recruitItemCode: String): Boolean {
        return codes.any { code -> code.code == recruitItemCode}
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