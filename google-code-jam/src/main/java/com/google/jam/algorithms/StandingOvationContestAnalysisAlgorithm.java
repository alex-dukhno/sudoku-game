package com.google.jam.algorithms;

import java.util.function.Function;

public final class StandingOvationContestAnalysisAlgorithm
        implements Function<String, String> {

    @Override
    public String apply(String task) {
        final String[] array = task.split("\\s+");
        final int shineMaxLevel = Integer.parseInt(array[0]);
        final String audience = array[1];
        int temp = 0;
        int value = 0;
        for (int currentShineLevel = 0; currentShineLevel < shineMaxLevel + 1; currentShineLevel++) {
            value = Math.max(value, currentShineLevel - temp);
            temp += audience.charAt(currentShineLevel) - '0';
        }
        return Integer.toString(value);
    }
}
