package online.sujithchenanath.util.testdata.factory;

public class TestDataReaderFactory {

	public static final String JSON="JSON";
	
	public static TestDataReader getTestDataReader(String sourceType) {
		
		TestDataReader reader1=null;
		if(sourceType.equals(TestDataReaderFactory.JSON)) {
			reader1=new JsonTestDataReader();
		}
		return reader1;
	}
	
}
