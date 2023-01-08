package com.zkdlu.recruiter.job

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListToStringConverterTest {
    @Test
    fun convertToDatabaseColumnTest() {
        val sut = ListToStringConverter()

        val result = sut.convertToDatabaseColumn(listOf("A", "B"))

        assertThat(result).isEqualTo("A,B")
    }

    @Test
    fun convertToDatabaseColumnTest_whenNull() {
        val sut = ListToStringConverter()

        val result = sut.convertToDatabaseColumn(null)

        assertThat(result).isEqualTo("")
    }

    @Test
    fun convertToEntityAttributeTest() {
        val sut = ListToStringConverter()

        val result = sut.convertToEntityAttribute("A,B")

        assertThat(result).containsExactlyInAnyOrder("A", "B")
    }

    @Test
    fun convertToEntityAttributeTest_whenNull() {
        val sut = ListToStringConverter()

        val result = sut.convertToEntityAttribute(null)

        assertThat(result).isEmpty()
    }

    @Test
    fun convertToEntityAttributeTest_whenEmpty() {
        val sut = ListToStringConverter()

        val result = sut.convertToEntityAttribute("")

        assertThat(result).isEmpty()
    }
}