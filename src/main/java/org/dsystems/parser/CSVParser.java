package org.dsystems.parser;

import java.io.Serializable;

import org.dsystems.utils.Attributes;
import org.dsystems.utils.Record;

public class CSVParser extends Parser implements Serializable{

	private static final long serialVersionUID = 1L;
	private String delimeter;
	private Attributes attrs;
	public static final String FIELDS = "fields"; 
	
	public CSVParser(Attributes attrs){
		this(",", attrs);
	}
	public CSVParser(String delimeter, Attributes attrs) {
		this.delimeter = delimeter;
		this.attrs = attrs;
	}

	@Override
	public Record parse(byte[] data) {
		return parse(new String(data));
	}

	public Record parse(String data) {
		Record record = new Record();

		String fieldNames = attrs.getValue(FIELDS);
		String[] fields = fieldNames.split(",");
		
		String[] values = data.split(delimeter);
		for (int i=0; i <fields.length; i++) {
			if (i < values.length)
				record.put(fields[i], values[i]);
			else 
				record.put(fields[i], null);
		}
		
		return record;
	}

}
