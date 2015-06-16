package org.sudoku.game.elements;

import org.sudoku.game.conf.GameFieldConfiguration;

public class Element {

	public static final Element EMPTY_ELEMENT = new Element(0);
	public static final Element[] POSSIBLE_ELEMENTS = new Element[] {
			new Element(1),
			new Element(2),
			new Element(3),
			new Element(4),
			new Element(5),
			new Element(6),
			new Element(7),
			new Element(8),
			new Element(9)
	};


	private final int value;

	private Element(final int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return 31 * (17 + Integer.hashCode(value));
	}

	@Override
	public boolean equals(final Object object) {
		if (object == this) {
			return true;
		}
		if (object != null
				&& object.getClass().equals(getClass())) {
			Element element = (Element) object;
			return element.value == value;
		}
		return false;
	}

	@Override
	public String toString() {
		if (value == 0) {
			return "   ";
		}
		return String.format(" %d ", value);
	}

	public static class Builder {

		private final int value;

		public Builder(final GameFieldConfiguration configuration, final int value) {
			if (value < 1
					|| value > configuration.getNumberOfElementsInColumn()) {
				throw new IllegalArgumentException(
						String.format(
								"Value can't be less then 1 and more %d",
								configuration.getNumberOfElementsInColumn()
						)
				);
			}
			this.value = value;
		}

		public Element build() {
			return new Element(value);
		}
	}
}