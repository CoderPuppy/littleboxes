package cpup.littleBoxes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game extends Part {
	protected final int boxSize;
	protected final Box[][] boxes;
	protected final Set<Part> parts = new HashSet<>();
	protected final BigBox[][] bigBoxes;
	protected final Column[] columns;
	protected final Row[] rows;

	protected void commonInit() {
		for(int x = 0; x < bigBoxes.length; x++) {
			for(int y = 0; y < bigBoxes.length; y++) {
				BigBox bigBox = new BigBox(this, x, y);
				parts.add(bigBox);
				bigBoxes[x][y] = bigBox;
			}
		}
		for(int x = 0; x < columns.length; x++) {
			Column column = new Column(this, x);
			parts.add(column);
			columns[x] = column;
		}
		for(int y = 0; y < rows.length; y++) {
			Row row = new Row(this, y);
			parts.add(row);
			rows[y] = row;
		}
	}

	public Game(int _boxSize) {
		boxSize = _boxSize;
		boxes = new Box[boxSize * boxSize][boxSize * boxSize];
		for(int x = 0; x < boxes.length; x++) {
			for(int y = 0; y < boxes.length; y++) {
				boxes[x][y] = new Box();
			}
		}
		bigBoxes = new BigBox[boxSize][boxSize];
		rows = new Row[boxSize * boxSize];
		columns = new Column[boxSize * boxSize];
		commonInit();
	}

	public Game(Box[][] _boxes) {
		boxes = _boxes;
		boxSize = getBoxesSize(boxes.length);
		bigBoxes = new BigBox[boxSize][boxSize];
		rows = new Row[boxSize * boxSize];
		columns = new Column[boxSize * boxSize];
		commonInit();
	}

	public static int getBoxesSize(int length) {
		double sqrtD = Math.sqrt(length);
		long sqrtL = Math.round(sqrtD);
		if(sqrtD != sqrtL)
			throw new IllegalArgumentException("The box must be nested?");
		return safeLongToInt(sqrtL);
	}

	public static int safeLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException
				(l + " cannot be cast to int without changing its value.");
		}
		return (int) l;
	}

	// Getters and Setters
	@Override
	public Game getGame() {
		return this;
	}

	public int getBoxSize() {
		return boxSize;
	}

	public Box[][] getRawBoxes() {
		return boxes;
	}

	@Override
	public Set<Box> getBoxes() {
		Set<Box> set = new HashSet<>();
		for(Box[] boxe : boxes) {
			set.addAll(Arrays.asList(boxe));
		}
		return set;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int getWidth() {
		return boxes.length;
	}

	@Override
	public int getHeight() {
		return boxes.length;
	}

	@Override
	public boolean isValid() {
		boolean isValid = true;
		for(Part part : parts)
			if (!part.isValid())
				isValid = false;
		return isValid;
	}

	public Box getBox(int x, int y) {
		return boxes[x][y];
	}

	public Set<Part> getParts() {
		return parts;
	}

	public BigBox[][] getBigBoxes() {
		return bigBoxes;
	}

	public Column[] getColumns() {
		return columns;
	}

	public Row[] getRows() {
		return rows;
	}
}