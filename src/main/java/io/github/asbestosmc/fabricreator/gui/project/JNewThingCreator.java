package io.github.asbestosmc.fabricreator.gui.project;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.function.Consumer;

public class JNewThingCreator extends JPanel {
	public JNewThingCreator() {
		this.goToMainMenu();
	}

	public final void display(Consumer<JNewThingCreator> consumer) {
		this.removeAll();
		consumer.accept(this);
		this.repaint();
	}

	/**
	 * return to main menu
	 */
	public final void goToMainMenu() {
		this.display(i -> {
			//construct components
			JButton newItem = new JButton("create new item");
			JButton newBlock = new JButton("create new block");
			JButton newDimension = new JButton("create new dimension");
			JButton newBiome = new JButton("create new biome");
			JButton newGui = new JButton("create new gui");
			JButton newEntity = new JButton("create new entity");
			JButton newHook = new JButton("create new hook");
			JButton newCommand = new JButton("create new command");
			JButton newTexture = new JButton("create new texture");

			//adjust size and set layout
			i.setPreferredSize(new Dimension(627, 411));
			GridLayout layout = new GridLayout(3, 3, 16, 16);
			i.setLayout(layout);

			//add components
			i.add(newItem);
			i.add(newBlock);
			i.add(newDimension);
			i.add(newBiome);
			i.add(newGui);
			i.add(newEntity);
			i.add(newHook);
			i.add(newCommand);
			i.add(newTexture);
		});
	}
}
