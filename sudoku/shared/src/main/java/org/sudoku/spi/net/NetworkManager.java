package org.sudoku.spi.net;

import java.io.IOException;

import org.sudoku.elements.Square;

public interface NetworkManager
		extends AutoCloseable {

	Square readFromNetwork()
			throws IOException;

	void writeToNetwork(Square square)
			throws IOException;

}