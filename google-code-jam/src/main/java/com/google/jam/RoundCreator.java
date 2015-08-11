package com.google.jam;

import java.util.List;

public interface RoundCreator {

    Round createRound(final List<String> strings);

    Round createRoundForMultiThreadEnvironment(final List<String> strings);
}
