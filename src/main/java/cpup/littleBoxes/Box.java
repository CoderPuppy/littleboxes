package cpup.littleBoxes;

import java.util.HashSet;
import java.util.Set;

public class Box {
	protected int value = -1;
	protected final Set<Integer> littleBoxes = new HashSet<>();

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

	public Set<Integer> getLittleBoxes() {
		return littleBoxes;
	}
}