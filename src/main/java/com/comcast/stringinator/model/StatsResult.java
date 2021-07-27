package com.comcast.stringinator.model;

import java.util.Map;

public class StatsResult {
    private final Map<String, Integer> inputs;
    private final Map<String, Integer> mostPopular;
    private final String longest_input_received;


    public StatsResult(Map<String, Integer> inputs, Map<String, Integer> mostPopular, String longest_input_received) {
        this.inputs = inputs;
        this.mostPopular = mostPopular;
        this.longest_input_received = longest_input_received;
    }

    public Map<String, Integer> getMostPopular() {
        return mostPopular;
    }

    public String getLongest_input_received() {
        return longest_input_received;
    }

    public Map<String, Integer> getInputs() {
        return inputs;
    }
}
