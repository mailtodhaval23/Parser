package org.dsystems.parser;

import org.dsystems.utils.Attributes;

import org.dsystems.parser.Parser.Type;

public class ParserFactory {

	public static Parser getParser(Type type, Attributes attrs) {
		
		switch(type) {
		case CSV:
		{
			Object delimeter = attrs.get("delimeter");
			String delimeterStr = "";
			if (delimeter != null) {
				delimeterStr = delimeter.toString();
				return new CSVParser(delimeterStr, attrs);
			}
			else
				return new CSVParser(attrs);
				
		}
		default:
			return null;
				
		}
		
	}
}
