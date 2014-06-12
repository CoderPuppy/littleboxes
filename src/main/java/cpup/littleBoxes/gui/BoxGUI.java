package cpup.littleBoxes.gui;

import cpup.littleBoxes.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoxGUI extends JComponent {
	protected final Box box;

	protected final Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	protected final Font smallFont = new Font(Font.MONOSPACED, Font.PLAIN, 15);
	protected boolean isFocused = false;

	public BoxGUI(Box _box) {
		box = _box;
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
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		final FontMetrics fontMetrics = getFontMetrics(font);
		final int charWidth = fontMetrics.getWidths()[0];
		final int charHeight = fontMetrics.getHeight();

		g.setFont(font);
		if(isFocused) {
			g.setColor(Color.gray);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight()); //, getWidth() / 4, getHeight() / 4);

		g.setColor(Color.black);
		g.drawString(Integer.toString(box.getValue()), (getWidth() - charWidth) / 2 + 1, (getHeight() - charHeight) / 2 + 12);

		final FontMetrics littleMetrics = getFontMetrics(smallFont);
		final int littleWidth = littleMetrics.getWidths()[0];
		final int littleHeight = littleMetrics.getHeight();

		int littlePlace = getWidth() - box.getLittleBoxes().size() * (littleWidth + 2) - 2;

		g.setFont(smallFont);
		for(Integer littleBox : box.getLittleBoxes()) {
			g.drawString(littleBox.toString(), littlePlace, 10 + littleHeight / 2);
			littlePlace += littleWidth + 2;
		}
	}

	// Getters and Setters
	public Box getBox() {
		return box;
	}
}