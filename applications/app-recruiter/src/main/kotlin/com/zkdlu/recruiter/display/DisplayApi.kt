package com.zkdlu.recruiter.display

import com.zkdlu.recruiter.company.Company
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DisplayApi {

    @GetMapping("/companies")
    fun getCompanies(): List<Company> {
        return Company.values()
            .asList()
    }
}