package online.sujithchenanath.util.testdata.factory;

public class TestDataReaderFactory {

	public static final String JSON="JSON";
	
	public static TestDataReader getTestDataReader(String sourceType) {
		
		TestDataReader sampleReader=null;
		if(sourceType.equals(TestDataReaderFactory.JSON)) {
			sampleReader=new JsonTestDataReader();
		}
		return sampleReader;
	}
	
}
