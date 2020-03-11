package io.github.asbestosmc.fabricreator.gui.selection;

import io.github.asbestosmc.fabricreator.metadata.ProjectMeta;
import javax.swing.*;
import java.awt.Dimension;
import java.util.function.Consumer;

public class ProjectCreationPanel extends JPanel {
	public ProjectCreationPanel(Consumer<ProjectMeta> metaConsumer) {
		String[] sideItems = {"general", "server", "client"};

		//construct components
		JLabel namespaceLabel = new JLabel("namespace");
		JTextField namespace = new JTextField(100);
		JLabel sideLabel = new JLabel("side?");
		JComboBox<String> side = new JComboBox<>(sideItems);
		JLabel modNameLabel = new JLabel("Mod Name");
		JTextField modname = new JTextField(10);
		JLabel modIdLabel = new JLabel("modid");
		JTextField modid = new JTextField(10);
		JButton create = new JButton("create");

		create.addActionListener(a -> {
			ProjectMeta meta = new ProjectMeta(namespace.getText(), (String) side.getSelectedItem(), modname.getText(), modid.getText());
			metaConsumer.accept(meta);
		});

		//adjust size and set layout
		this.setPreferredSize(new Dimension(197, 184));
		this.setLayout(null);

		//add components
		this.add(namespaceLabel);
		this.add(namespace);
		this.add(sideLabel);
		this.add(side);
		this.add(modNameLabel);
		this.add(modname);
		this.add(modIdLabel);
		this.add(modid);
		this.add(create);

		//set component bounds (only needed by Absolute Positioning)
		namespaceLabel.setBounds(5, 5, 70, 25);
		namespace.setBounds(85, 5, 100, 25);
		sideLabel.setBounds(5, 35, 70, 25);
		side.setBounds(85, 35, 100, 25);
		modNameLabel.setBounds(5, 65, 70, 25);
		modname.setBounds(85, 65, 100, 25);
		modIdLabel.setBounds(5, 95, 70, 25);
		modid.setBounds(85, 95, 100, 25);
		create.setBounds(40, 140, 100, 25);
	}
}
