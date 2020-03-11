package io.github.asbestosmc.fabricreator.metadata;

import org.inventivetalent.nbt.annotation.NBT;

public abstract class Asset {
	@NBT("namespace")
	private String namespace;
	@NBT("data")
	private byte[] data;

	public Asset(String namespace, byte[] data) {
		this.namespace = namespace;
		this.data = data;
	}
}
