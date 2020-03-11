package io.github.asbestosmc.fabricreator.gui.project;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JTextureCreator extends JPanel {
	public JTextureCreator() {
		Canvas canvas = new Canvas();
		JColorChooser chooser = new JColorChooser();
		chooser.addPropertyChangeListener(evt -> {
			Object newVal = evt.getNewValue();
			if(newVal instanceof Color)

		});
		BorderLayout layout = new BorderLayout(0, 0);
		this.setLayout(layout);
		this.add(canvas);
	}
}
