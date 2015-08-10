package com.google.jam.unit.solvers;

import com.google.jam.RoundCreator;
import com.google.jam.infinitehouseofpancakes.InfiniteHouseOfPancakesRoundCreator;
import com.google.jam.standingovation.StandingOvationRoundCreator;

public class RoundCreatorProvider {
    public RoundCreator buildRoundCreator(final char roundLetter) {
        switch (roundLetter) {
            case 'A':
                return new StandingOvationRoundCreator(false);
            case 'B':
                return new InfiniteHouseOfPancakesRoundCreator();
        }
        throw new RuntimeException("Impossible situation!!!");
    }
}