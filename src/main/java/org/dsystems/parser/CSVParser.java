package org.dsystems.parser;

import java.io.Serializable;

import org.dsystems.utils.Attributes;
import org.dsystems.utils.Record;
import org.dsystems.utils.ValidatorResponse;

public class CSVParser extends Parser implements Serializable{

	private static final long serialVersionUID = 1L;
	private String delimeter;
	private Attributes attrs;
	public static final String FIELDS = "fields"; 
	
	public CSVParser(Attributes attrs){
		Object delimeter = null;
		String delimeterStr = "";
		if (attrs != null) {
			delimeter = attrs.get("delimeter");
		}
		if (delimeter != null) {
			delimeterStr = delimeter.toString();
		} else {
			delimeterStr = ",";
		}
		this.delimeter = delimeterStr;
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
	@Override
	public ValidatorResponse validate() {
		if (this.attrs != null && this.attrs.getValue(FIELDS) != null)
			return new ValidatorResponse(true, "");
		return new ValidatorResponse(false, "Required property '" + FIELDS + "' not found!");
	}
	@Override
	public Parser init(Attributes attrs) {
		this.attrs = attrs;
		return new CSVParser(attrs);
	}

}
