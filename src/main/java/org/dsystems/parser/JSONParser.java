package org.dsystems.parser;

import java.io.Serializable;

import org.dsystems.utils.Attributes;
import org.dsystems.utils.NaturalDeserializer;
import org.dsystems.utils.Record;
import org.dsystems.utils.ValidatorResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

public class JSONParser extends Parser implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Record parse(byte[] data) {
		return parse(new String(data));
	}

/*	public Record parse(String data) {
		Record record = new Record();

		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		LinkedTreeMap<String, Object> result = gson.fromJson(data , LinkedTreeMap.class);
		for (String key: result.keySet()) {
			record.put(key, result.get(key));
		}
		
		return record;
	}*/

	public Record parse(String data) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Object.class, new NaturalDeserializer());
		Gson gson = gsonBuilder.create();
		
		Object natural = gson.fromJson(data, Object.class);
		return (Record) natural;
	}
	@Override
	public Parser init(Attributes attrs) {
		// TODO Auto-generated method stub
		return new JSONParser();
	}

	@Override
	public ValidatorResponse validate() {
		// TODO Auto-generated method stub
		return new ValidatorResponse(true, "");
	}

}
