package org.dsystems.parser;

import java.io.Serializable;

import org.dsystems.utils.Record;

public abstract class Parser implements Serializable{

	public enum Type {CSV, 	JSON};
	public abstract Record parse(byte[] data);
	public Record parse(String data) {
		// TODO Auto-generated method stub
		return null;
	}
}
