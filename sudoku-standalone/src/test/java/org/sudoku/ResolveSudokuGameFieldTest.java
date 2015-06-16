package org.sudoku;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Ignore;
import org.sudoku.game.conf.GameFieldConfiguration;
import org.sudoku.game.elements.Element;
import org.sudoku.game.elements.GameField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Before;
import org.junit.Test;

public class ResolveSudokuGameFieldTest {

	private static final Logger LOG = LoggerFactory.getLogger(ResolveSudokuGameFieldTest.class);

	private GameFieldConfiguration configuration;

	@Before
	public void startUp() {
		configuration = new GameFieldConfiguration.Builder(9).build();
	}

	@Test
	@Ignore
	public void main()
			throws Exception {
		GameField gameField = new GameField.Builder(configuration, ELEMENTS).build();
		LOG.info("Game field at start \n{}", gameField);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		int iteration = 1;
		while (!gameField.isFilled()) {
			int number = (iteration - 1) % 9;
			int i = number / configuration.getNumberOfSquaresInColumn();
			int j = number % configuration.getNumberOfSquaresInRow();
			Runnable resolver = gameField.build(i, j);
			executorService.submit(resolver).get();
			LOG.info("Game field after {} iteration \n{}", iteration, gameField);
			iteration++;
		}
	}

	public static final GameFieldConfiguration CONFIGURATION = new GameFieldConfiguration.Builder(81).build();

	public static final Element[][] ELEMENTS = new Element[][] {
			{
					new Element.Builder(CONFIGURATION, 8).build(),
					new Element.Builder(CONFIGURATION, 4).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 5).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 2).build()
			},
			{
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 5).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 9).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 3).build(),
					new Element.Builder(CONFIGURATION, 6).build()
			},
			{
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 2).build(),
					new Element.Builder(CONFIGURATION, 8).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 6).build(),
					new Element.Builder(CONFIGURATION, 4).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT
			},
			{
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 6).build(),
					new Element.Builder(CONFIGURATION, 8).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 1).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 5).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT
			},
			{
					new Element.Builder(CONFIGURATION, 9).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 5).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 4).build()
			},
			{
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 3).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 6).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 7).build(),
					new Element.Builder(CONFIGURATION, 1).build(),
					Element.EMPTY_ELEMENT,
			},
			{
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 9).build(),
					new Element.Builder(CONFIGURATION, 1).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 7).build(),
					new Element.Builder(CONFIGURATION, 3).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT
			},
			{
					new Element.Builder(CONFIGURATION, 2).build(),
					new Element.Builder(CONFIGURATION, 1).build(),
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 4).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 8).build(),
					Element.EMPTY_ELEMENT
			},
			{
					new Element.Builder(CONFIGURATION, 7).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 8).build(),
					Element.EMPTY_ELEMENT,
					Element.EMPTY_ELEMENT,
					new Element.Builder(CONFIGURATION, 2).build(),
					new Element.Builder(CONFIGURATION, 9).build()
			}
	};
}