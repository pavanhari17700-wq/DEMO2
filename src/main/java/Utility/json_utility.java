package Utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.protobuf.TextFormat.ParseException;

public class json_utility {

	
	public class JsonUtility {

		/**
		 * This Method Is Used To Fetch Data From Json File Using Key
		 * @param key
		 * @return
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws ParseException
		 * @throws org.json.simple.parser.ParseException 
		 */
		public String fetchdatafromJsonFile(String key) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
			
			//Fetch Data From Json File By Using Json Parse
			JSONParser parsers=new JSONParser();
			
			Object obj = parsers.parse(new FileReader("./src/test/resources/vtigerCD.json"));
			
			//To Perform Type Castying Json File To Object
			JSONObject js=(JSONObject)obj;
			
			//Convert Value Into String Format( In Json We Can't Understand Object So Again Change to String)
			String data = js.get(key).toString();
			
			return data;
			
		}
	
	
	}
	
}
