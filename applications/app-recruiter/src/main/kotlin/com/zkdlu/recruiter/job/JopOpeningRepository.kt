package com.zkdlu.recruiter.job

import org.springframework.data.jpa.repository.JpaRepository

interface JopOpeningRepository: JpaRepository<JobOpenings, Long> {

    fun findAllByCompany(company: Company): List<JobOpenings>
}