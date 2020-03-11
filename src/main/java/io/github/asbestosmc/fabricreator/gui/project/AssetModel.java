package io.github.asbestosmc.fabricreator.gui.project;

import io.github.asbestosmc.fabricreator.metadata.ProjectMeta;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class AssetModel implements TreeModel {
	public final ProjectMeta meta;

	public AssetModel(ProjectMeta meta) {
		this.meta = meta;
	}

	@Override
	public Object getRoot() {
		return this.meta.getNamespace();
	}

	@Override
	public Object getChild(Object parent, int index) {
		if(meta.getNamespace().equals(parent)) { // root note

		}
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		return 0;
	}

	@Override
	public boolean isLeaf(Object node) {
		return false;
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {

	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		return 0;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {

	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {

	}
}
