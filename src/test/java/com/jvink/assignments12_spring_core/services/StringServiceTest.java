package com.jvink.assignments12_spring_core.services;

import com.jvink.assignments12_spring_core.interfaces.StringRepository;
import com.jvink.assignments12_spring_core.models.StringDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringServiceTest {
    static private String testString;
    @Autowired
    static private StringService stringService;
    @Autowired
    private StringRepository stringRepository;

    @BeforeAll
    static void setupBeforeAll() {
        testString = "this is a test string";
    }

    @BeforeEach
    void setupBeforeEach() {
        // arrange
        stringService = new StringService(stringRepository);
    }

    @Test
    void testReverseString() {
        // act
        String reversedString = stringService.reverseString(testString);
        // assert
        assertThat(reversedString).isEqualTo("gnirts tset a si siht");
    }

    @Test
    void testEncapsulateString() {
        // act
        String encapsulatedString = stringService.encapsulateString(testString);
        // assert
        assertThat(encapsulatedString).isEqualTo("THIS IS A TEST STRING");
    }

    @AfterAll
    static void tearDown() {
        testString = null;
        stringService = null;
    }
}
