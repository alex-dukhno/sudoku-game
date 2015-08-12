package com.google.jam.creators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.jam.WrongRoundFormatException;

public class InfiniteHouseOfPancakesRoundCreator
        extends RoundCreator {

    @Override
    protected Map<Integer, String> getIntegerStringMap(List<String> strings) {
        final int queueLength;
        try {
            final String length = strings.remove(0);
            queueLength = Integer.parseInt(length);
        }
        catch (NumberFormatException e) {
            throw new WrongRoundFormatException();
        }
        if (queueLength != strings.size() / 2) {
            throw new WrongRoundFormatException();
        }
        Map<Integer, String> tasks = new HashMap<>(strings.size() / 2);
        int counter = 1;
        for (int i = 0; i < strings.size(); i += 2) {
            tasks.put(counter++, strings.get(i) + ' ' + strings.get(i + 1));
        }
        return tasks;
    }
}
