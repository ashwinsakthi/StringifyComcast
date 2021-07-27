package com.comcast.stringinator.service;


import com.comcast.stringinator.model.StatsResult;
import com.comcast.stringinator.model.StringinatorInput;
import com.comcast.stringinator.model.StringinatorResult;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StringinatorServiceImpl implements StringinatorService {

    private Map<String, Integer> seenStrings = new HashMap<>();

    Map<String, Integer> statsMap = new HashMap<>();

    @Override
    public StringinatorResult stringinate(StringinatorInput input) {
        seenStrings.compute(input.getInput(), (k, v) -> (v == null) ? Integer.valueOf(1) : v + 1);
        Optional<Character> key = null;
        Map<Character, Integer> charCountMap = getMaxOccurringChar(input.getInput());
        Optional<Character> firstKey = charCountMap.keySet().stream().findFirst();
        if (firstKey.isPresent()) {
            key = Optional.of(firstKey.get());
        }
        String inputStr = input.getInput();

        StringinatorResult result = new StringinatorResult
                (inputStr, Integer.valueOf(input.getInput().length()),key.get(),charCountMap.get(key.get()));

        if(statsMap.get(inputStr)==null){
            statsMap.put(inputStr,1);
        }else{
            statsMap.put(inputStr,statsMap.get(inputStr)+1);
        }

        return result;
    }

    @Override
    public StatsResult stats() {

        return new StatsResult(statsMap,entriesSortedByValues(statsMap),getPopularValue(statsMap));
    }

    static String getPopularValue(Map<String, Integer> statsMap){
        if(statsMap!=null && statsMap.size()!=0){
            return statsMap.keySet().stream()
                    .max(Comparator.comparingInt(String::length))
                    .get();
        }else{
            return null;
        }

    }

    static Map<Character, Integer> getMaxOccurringChar(String str)
    {
        Map<Character, Integer> charCountMap = new HashMap<>();
        final int ASCII_SIZE = 256;
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[ASCII_SIZE];

        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        charCountMap.put(result,max);

        return charCountMap;
    }

    static Map<String, Integer> entriesSortedByValues(Map<String, Integer> sortMap) {

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : sortMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        if(maxEntry==null){
            return null;
        }else{
            return Map.ofEntries(maxEntry);
        }

    }
}
