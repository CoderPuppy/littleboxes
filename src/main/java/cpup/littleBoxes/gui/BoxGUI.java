package cpup.littleBoxes.gui;

import cpup.littleBoxes.Box;
import cpup.littleBoxes.BoxPos;
import cpup.littleBoxes.IPartContainer;
import cpup.littleBoxes.Part;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoxGUI extends JComponent implements IPartContainer {
	protected final BoxPos boxPos;
	protected final Box box;

	protected final Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	protected final Font smallFont = new Font(Font.MONOSPACED, Font.PLAIN, 15);
	protected boolean isFocused = false;

	public BoxGUI(BoxPos _boxPos) {
		boxPos = _boxPos;
		box = boxPos.getBox();
		setFont(font);
		setFocusable(true);
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				grabFocus();
			}

			@Override
			public void mousePressed(MouseEvent mouseEvent) {}

			@Override
			public void mouseReleased(MouseEvent mouseEvent) {}

			@Override
			public void mouseEntered(MouseEvent mouseEvent) {}

			@Override
			public void mouseExited(MouseEvent mouseEvent) {}
		});
		addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent focusEvent) {
				isFocused = true;
				repaint();
			}

			@Override
			public void focusLost(FocusEvent focusEvent) {
				isFocused = false;
				repaint();
			}
		});
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ev) {}

			@Override
			public void keyPressed(KeyEvent ev) {
				System.out.printf("key: %s / %s%n", ev.getKeyChar(), KeyEvent.getKeyText(ev.getKeyCode()));
				try {
					Integer val = Integer.parseInt(KeyEvent.getKeyText(ev.getKeyCode()));
					System.out.printf("num: %d%n", val);
					if(ev.isShiftDown()) {
						box.setValue(val);
//						box.getLittleBoxes().clear();
					} else {
						if(box.getLittleBoxes().contains(val)) {
							box.getLittleBoxes().remove(val);
						} else {
							box.getLittleBoxes().add(val);
						}
					}
					repaint();
				} catch(NumberFormatException ignored) {}
			}

			@Override
			public void keyReleased(KeyEvent keyEvent) {}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		final int x = 6;
		final int y = 6;
		final int width = getWidth() - 12;
		final int height = getHeight() - 12;

		final FontMetrics fontMetrics = getFontMetrics(font);
		final int charWidth = fontMetrics.getWidths()[0];
		final int charHeight = fontMetrics.getHeight();

		g.setFont(font);
		if(isFocused) {
			g.setColor(Color.gray);
//			g.fillRect(x, y, width, height);
			g.fillRoundRect(x, y, width, height, 5, 5);
		}
		g.setColor(Color.black);
//		g.drawRect(x, y, width, height);
		g.drawRoundRect(x, y, width, height, 5, 5);

		g.setColor(Color.black);
		g.drawString(Integer.toString(box.getValue()), x + (width - charWidth) / 2 + 1, y + (height - charHeight) / 2 + 12);

		final FontMetrics littleMetrics = getFontMetrics(smallFont);
		final int littleWidth = littleMetrics.getWidths()[0];
		final int littleHeight = littleMetrics.getHeight();

		int littlePlace = width - box.getLittleBoxes().size() * (littleWidth + 2) - 2;

		g.setFont(smallFont);
		for(Integer littleBox : box.getLittleBoxes()) {
			g.drawString(littleBox.toString(), x + littlePlace, y + 10 + littleHeight / 2);
			littlePlace += littleWidth + 2;
		}
	}

	// Getters and Setters
	public Box getBox() {
		return box;
	}

	@Override
	public Part getPart() {
		return boxPos;
	}
}