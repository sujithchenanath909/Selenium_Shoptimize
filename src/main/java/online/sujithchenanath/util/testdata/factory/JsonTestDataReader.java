package online.sujithchenanath.util.testdata.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonTestDataReader implements TestDataReader {

	private static ObjectMapper mapper=new ObjectMapper();
	
	@Override
	public ArrayList<?> getTestData(String source, String bean) {

		ArrayList<?> testData=null;
		
		try {
			
			InputStream jsonStream=JsonTestDataReader.class.getClassLoader().getResourceAsStream("testData/"+source+".json");
			testData=getFromJsonCollection(jsonStream,Class.forName(bean));
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return testData;
	}

	private ArrayList<?> getFromJsonCollection(InputStream jsonStream, Class<?> forName) {
		// TODO Auto-generated method stub
		try {
			return mapper.readValue(jsonStream,TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, forName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
