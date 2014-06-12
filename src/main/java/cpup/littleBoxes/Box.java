package cpup.littleBoxes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Box {
	protected int value = -1;
	protected final List<Integer> littleBoxes = new ArrayList<>();

	public Box() {}

	public Box(int _value) {
		value = _value;
	}

	// Getters and Setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Integer> getLittleBoxes() {
		return littleBoxes;
	}
}