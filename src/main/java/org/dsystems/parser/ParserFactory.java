package org.dsystems.parser;

import org.dsystems.utils.Attributes;
import org.dsystems.utils.ValidatorResponse;
import org.dsystems.parser.Parser.Type;

public class ParserFactory {

	public static Parser getParser(Type type, Attributes attrs) {
		if (type != null && attrs != null)
			System.out.println("ParserFactory :: getParser : " + type.toString() + attrs.toString());
		
		Parser p = null;
		switch(type) {
		case CSV:
		{	
			p = new CSVParser(attrs);
			break;
		}
		case JSON:
		{
			p = new JSONParser();
			break;
		}
		default:
			return null;
				
		}
		if (p != null) {
			ValidatorResponse vr = p.validate();
			System.out.println("Parser Validator: Response: "+ vr.isValid + " : "+ vr.message);
			if (vr.isValid) {
				return p.init(attrs);
			} else {
				System.out.println("Invalid Parser Configuration : ERROR: " + vr.message);
			}
		}
		return null;
	}
}
