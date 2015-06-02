package org.sudoku.net.spi;

import java.io.IOException;

import org.sudoku.game.elements.Square;

public interface NetworkManager
		extends AutoCloseable {

	Square readFromNetwork()
			throws IOException;

	void writeToNetwork(Square square)
			throws IOException;

}