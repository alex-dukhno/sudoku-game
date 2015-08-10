package com.google.jam.unit.solvers;

import java.util.function.Function;

import com.google.jam.solvers.RoundResolver;
import com.google.jam.solvers.SingleThreadRoundResolver;

import org.junit.Before;

public class SingleThreadRoundResolversTest
        extends AbstractRoundResolversTest {

    private RoundResolver resolver;

    public SingleThreadRoundResolversTest(
            Function<String, Integer> algorithm,
            char roundLetter,
            String smokeTestLocation,
            String smokeTestComplexity,
            String smokeTestRoundType,
            String smallLocation,
            String smallComplexity,
            String smallRoundType,
            String largeLocation,
            String largeComplexity,
            String largeRoundType) {
        super(
                algorithm,
                roundLetter,
                smokeTestLocation,
                smokeTestComplexity,
                smokeTestRoundType,
                smallLocation,
                smallComplexity,
                smallRoundType,
                largeLocation,
                largeComplexity,
                largeRoundType);
    }

    @Override
    @Before
    public void setUp()
            throws Exception {
        super.setUp();
        resolver = new SingleThreadRoundResolver();
    }

    @Override
    protected RoundResolver getResolver() {
        return resolver;
    }
}