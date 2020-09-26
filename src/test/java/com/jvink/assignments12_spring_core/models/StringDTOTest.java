package com.jvink.assignments12_spring_core.models;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringDTOTest {
    static private String testString;
    static private Number testCount;

    @BeforeAll
    static void setup() {
        testString = "this is a test string";
        testCount = 5;
    }

    @Test
    @DisplayName("gets the current name of StringDTO")
    void testGetName() {
        // arrange
        StringDTO stringDTO = new StringDTO(testString, testCount);
        // act
        String name = stringDTO.getName();
        // assert
        assertThat(name).isEqualTo(testString);
    }

    @Test
    @DisplayName("gets the current count of StringDTO")
    void testGetCount() {
        // arrange
        StringDTO stringDTO = new StringDTO(testString, testCount);
        // act
        Number count = stringDTO.getCount();
        // assert
        assertThat(count).isEqualTo(testCount);
    }

    @AfterAll
    static void tearDown() {
        testString = null;
        testCount = null;
    }
}
