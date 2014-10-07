package cpup.littleBoxes.gui;

import cpup.littleBoxes.IPartContainer;
import cpup.littleBoxes.Part;

import javax.swing.*;
import java.awt.*;

public class PartGUI extends JComponent implements IPartContainer {
	protected final Part part;
	protected final int offset;

	public PartGUI(Part _part, int _offset) {
		part = _part;
		offset = _offset;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		final int width = getWidth() - offset * 2;
		final int height = getHeight() - offset * 2;

		if(part.isValid()) {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.red);
		}
		g.drawRoundRect(offset, offset, width, height, 5, 5);
	}

	// Getters and Setters
	@Override
	public Part getPart() {
		return part;
	}
}