package cpup.littleBoxes;

public class Game {
	protected final int boxSize;
	protected final Box[][] boxes;

	public Game(int _boxSize) {
		boxSize = _boxSize;
		boxes = new Box[boxSize * boxSize][boxSize * boxSize];
		for(int x = 0; x < boxes.length; x++) {
			for(int y = 0; y < boxes.length; y++) {
				boxes[x][y] = new Box();
			}
		}
	}

	public Game(Box[][] _boxes) {
		boxes = _boxes;
		boxSize = getBoxesSize(boxes.length);
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
	public int getBoxSize() {
		return boxSize;
	}

	public Box[][] getBoxes() {
		return boxes;
	}
}