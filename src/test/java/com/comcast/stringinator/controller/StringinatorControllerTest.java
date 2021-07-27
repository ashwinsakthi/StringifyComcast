package com.comcast.stringinator.controller;

import com.comcast.stringinator.model.StatsResult;
import com.comcast.stringinator.model.StringinatorInput;
import com.comcast.stringinator.model.StringinatorResult;
import com.comcast.stringinator.service.StringinatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StringinatorControllerTest {

    @Mock
    private StringinatorService mockStringinatorService;

    @InjectMocks
    private StringinatorController stringinatorControllerUnderTest;

    @Test
    void testIndex() {
        // Setup

        // Run the test
        final String result = stringinatorControllerUnderTest.index();

        // Verify the results
        assertNotNull(result);
    }

    @Test
    void testStringinateGet() {
        // Setup

        // Configure StringinatorService.stringinate(...).
        final StringinatorResult stringinatorResult = new StringinatorResult("input", 0, 'a', 0);
        when(mockStringinatorService.stringinate(any(StringinatorInput.class))).thenReturn(stringinatorResult);

        // Run the test
        final StringinatorResult result = stringinatorControllerUnderTest.stringinateGet("input");

        // Verify the results
    }

    @Test
    void testStringinate() {
        // Setup
        final StringinatorInput input = new StringinatorInput("input");

        // Configure StringinatorService.stringinate(...).
        final StringinatorResult stringinatorResult = new StringinatorResult("input", 0, 'a', 0);
        when(mockStringinatorService.stringinate(any(StringinatorInput.class))).thenReturn(stringinatorResult);

        // Run the test
        final StringinatorResult result = stringinatorControllerUnderTest.stringinate(input);

        // Verify the results
    }

    @Test
    void testStats() {
        // Setup

        // Configure StringinatorService.stats(...).
        final StatsResult statsResult = new StatsResult(Map.ofEntries(Map.entry("value", 0)), Map.ofEntries(Map.entry("value", 0)), "longest_input_received");
        when(mockStringinatorService.stats()).thenReturn(statsResult);

        // Run the test
        final StatsResult result = stringinatorControllerUnderTest.stats();

        // Verify the results
    }
}
