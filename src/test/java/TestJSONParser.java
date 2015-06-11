import static org.junit.Assert.*;

import org.dsystems.parser.Parser;
import org.dsystems.parser.ParserFactory;
import org.dsystems.utils.Attributes;
import org.dsystems.utils.Record;
import org.junit.Test;


public class TestJSONParser {

	//@Test
	public void testParser1() {
		String data = 
				"{\"header\":{\"alerts\":[{\"AlertID\":\"2\",\"TSExpires\":null,\"Target\":\"1\",\"Text\":\"woot\",\"Type\":\"1\"},{\"AlertID\":\"3\",\"TSExpires\":null,\"Target\":\"1\",\"Text\":\"woot\",\"Type\":\"1\"}],\"session\":\"0bc8d0835f93ac3ebbf11560b2c5be9a\"},\"result\":\"4be26bc400d3c\"}";
		
		Attributes attrs = new Attributes();
		Parser p = ParserFactory.getParser(Parser.Type.JSON, attrs);
		
		Record r = p.parse(data);
		System.out.println("Record: " + r.get("header.session").toString());
	}
	
	@Test
	public void testCSVParser() {
		String data = 
				"2015-06-08-10,LOC1,21";
		
		Attributes attrs = new Attributes();
		attrs.put("fields", "TimeStamp,Location,Temperature");
		Parser p = ParserFactory.getParser(Parser.Type.CSV, attrs);
		
		Record r = p.parse(data);
		System.out.println("Record: " + r.toString());
	}

}
