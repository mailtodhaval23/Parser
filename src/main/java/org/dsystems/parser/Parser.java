package org.dsystems.parser;

import java.io.Serializable;

import org.dsystems.utils.Attributes;
import org.dsystems.utils.Record;
import org.dsystems.utils.ValidatorResponse;

public abstract class Parser implements Serializable{


	private static final long serialVersionUID = 1L;
	public enum Type {CSV, 	JSON};
	public abstract Parser init(Attributes attrs);
	public abstract ValidatorResponse validate();
	public abstract Record parse(byte[] data);
	public Record parse(String data) {
		// TODO Auto-generated method stub
		return null;
	}
}
