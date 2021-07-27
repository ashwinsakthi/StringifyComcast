package com.comcast.stringinator.service;

import com.comcast.stringinator.model.StatsResult;
import com.comcast.stringinator.model.StringinatorInput;
import com.comcast.stringinator.model.StringinatorResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StringinatorServiceImplTest {

    private StringinatorServiceImpl stringinatorServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        stringinatorServiceImplUnderTest = new StringinatorServiceImpl();
        stringinatorServiceImplUnderTest.statsMap = mock(Map.class);
    }

    @Test
    void testStringinate() {
        // Setup
        final StringinatorInput input = new StringinatorInput("input");
        when(stringinatorServiceImplUnderTest.statsMap.get("key")).thenReturn(0);
        when(stringinatorServiceImplUnderTest.statsMap.put("ashwin",1)).thenReturn(1);

        // Run the test
        final StringinatorResult result = stringinatorServiceImplUnderTest.stringinate(input);
        assertEquals("input",result.getInput());
        // Verify the results
    }

    @Test
    void testStringinate_MapGetReturnsNull() {
        // Setup
        final StringinatorInput input = new StringinatorInput("input");
        when(stringinatorServiceImplUnderTest.statsMap.get("key")).thenReturn(null);
        when(stringinatorServiceImplUnderTest.statsMap.put("key", 0)).thenReturn(0);

        // Run the test
        final StringinatorResult result = stringinatorServiceImplUnderTest.stringinate(input);

        // Verify the results
    }

    @Test
    void testStringinate_MapPutReturnsNull() {
        // Setup
        final StringinatorInput input = new StringinatorInput("input");
        when(stringinatorServiceImplUnderTest.statsMap.get("key")).thenReturn(0);
        when(stringinatorServiceImplUnderTest.statsMap.put("key", 0)).thenReturn(null);

        // Run the test
        final StringinatorResult result = stringinatorServiceImplUnderTest.stringinate(input);

        // Verify the results
    }

    @Test
    void testStats() {
        // Setup

        // Run the test
        final StatsResult result = stringinatorServiceImplUnderTest.stats();
        assertNotNull(stringinatorServiceImplUnderTest.statsMap);
        // Verify the results

    }

    @Test
    void testGetPopularValue() {
        // Setup
        final Map<String, Integer> statsMap = Map.ofEntries(Map.entry("ashwin", 1),Map.entry("ashwinsakthi", 2));

        // Run the test
        final String result = StringinatorServiceImpl.getPopularValue(statsMap);

        // Verify the results
        assertEquals("ashwinsakthi", result);
    }

    @Test
    void testGetMaxOccurringChar() {
        // Setup
        final Map<Character, Integer> expectedResult = Map.ofEntries(Map.entry('s', 2));

        // Run the test
        final Map<Character, Integer> result = StringinatorServiceImpl.getMaxOccurringChar("strs");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testEntriesSortedByValues() {
        // Setup
        final Map<String, Integer> sortMap = Map.ofEntries(Map.entry("ashwin", 1),Map.entry("ashwinsakthi", 2));
        final Map<String, Integer> expectedResult = Map.ofEntries(Map.entry("ashwinsakthi", 2));

        // Run the test
        final Map<String, Integer> result = StringinatorServiceImpl.entriesSortedByValues(sortMap);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testEntriesSortedByValuesFail() {
        // Setup
        final Map<String, Integer> sortMap = Map.ofEntries(Map.entry("ashwin", 1),Map.entry("ashwinsakthi", 2));
        final Map<String, Integer> expectedResult = Map.ofEntries(Map.entry("ashwin", 1));

        // Run the test
        final Map<String, Integer> result = StringinatorServiceImpl.entriesSortedByValues(sortMap);

        // Verify the results
        assertNotEquals(expectedResult, result);
    }
}
