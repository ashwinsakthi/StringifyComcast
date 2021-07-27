package com.comcast.stringinator.model;

public class StringinatorResult {
    private final String input;
    private final Integer length;
    private Character popularChar;
    private Integer popularCharCount=0;

    public StringinatorResult(String input, Integer length, Character popularChar, Integer popularCharCount) {
        this.input = input;
        this.length = length;
        this.popularChar = popularChar;
        this.popularCharCount = popularCharCount;
    }

    public StringinatorResult(String input, Integer length) {
        this.input = input;
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public String getInput() {
        return this.input;
    }


    public Character getPopularChar() {
        return popularChar;
    }

    public void setPopularChar(Character popularChar) {
        this.popularChar = popularChar;
    }

    public Integer getPopularCharCount() {
        return popularCharCount;
    }

    public void setPopularCharCount(Integer popularCharCount) {
        this.popularCharCount = popularCharCount;
    }
}
