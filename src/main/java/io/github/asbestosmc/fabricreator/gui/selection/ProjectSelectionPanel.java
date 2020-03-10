package io.github.asbestosmc.fabricreator.gui.selection;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class ProjectSelectionPanel extends JFrame {

	public ProjectSelectionPanel(Consumer<File> confirmationActionRunnable) {
		//construct components
		JLabel label = new JLabel("Project Directory");
		JTextField projectDir = new JTextField(5);
		JButton confirm = new JButton("ok");

		//adjust size and set layout
		this.setPreferredSize(new Dimension(160, 152));
		this.setLayout(null);

		//add components
		this.add(label);
		this.add(projectDir);
		this.add(confirm);

		//set component bounds (only needed by Absolute Positioning)
		label.setBounds(30, 20, 100, 25);
		projectDir.setBounds(30, 55, 100, 25);
		confirm.setBounds(30, 95, 100, 25);

		AtomicBoolean createNew = new AtomicBoolean(false);
		String[] oldField = new String[1];
		confirm.addActionListener(a -> {
			String field = projectDir.getText();
			File file = new File(field);
			if (file.exists() && file.isDirectory()) {
				confirmationActionRunnable.accept(file); // join directory
			} else if (createNew.get() && field.equals(oldField[0])) {
				file.mkdirs();
				confirmationActionRunnable.accept(file);
			} else {
				confirm.setBorder(BorderFactory.createLineBorder(Color.GREEN));
				JOptionPane.showConfirmDialog(null, "click \"ok\" again to create a new project");
				createNew.set(true); // attempt to create new file
			}
		});
	}
}
