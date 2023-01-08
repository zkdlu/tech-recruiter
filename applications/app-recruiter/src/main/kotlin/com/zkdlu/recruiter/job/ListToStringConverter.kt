package com.zkdlu.recruiter.job

import javax.persistence.AttributeConverter

class ListToStringConverter: AttributeConverter<List<String>, String> {
    override fun convertToDatabaseColumn(attribute: List<String>?): String {
        return attribute?.joinToString(separator = ",") ?: ""
    }

    override fun convertToEntityAttribute(dbData: String?): List<String> {
        if (dbData.isNullOrBlank()) {
            return listOf()
        }

        return dbData.split(",")
    }
}