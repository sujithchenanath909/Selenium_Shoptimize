package online.sujithchenanath.util.dataProviders;

import java.io.FileNotFoundException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import online.sujithchenanath.util.annottations.TestData;
import online.sujithchenanath.util.testdata.factory.TestDataReaderFactory;

public class TestDataProvider {
	public static Logger log = LogManager.getLogger(TestDataProvider.class.getName());

	@DataProvider(name = "getTestData")
	public Object[][] getTestData(Method aMethod) throws FileNotFoundException {

		Object[][] arrayToReturn = null;
		try {
			
				Annotation methodAnnotations[] = aMethod.getAnnotations();
				String source = "", dataBean = "", type = "";
	
				for (Annotation annotation : methodAnnotations) {
	
					if (annotation instanceof TestData) {
	
						TestData testDataAnnotation = (TestData) annotation;
						source = testDataAnnotation.source();
						dataBean = testDataAnnotation.dataBean();
						type = testDataAnnotation.type();
	
					}
				}
	
				if ("".equals(source) || "".equals(dataBean)) {
					log.warn("No testData Source or bean information provided !!");
				} else {
	
					ArrayList<?> testData = TestDataReaderFactory.getTestDataReader(type).getTestData(source, dataBean);
					arrayToReturn = new Object[testData.size()][1];
					for (int i = 0; i < testData.size(); i++) {
						arrayToReturn[i][0] = testData.get(i);
					}
	
					log.info("Data file read successfully");
				}
	
	
				
		}catch(Exception e) {
			log.error("Error reading data file");
		}
				return arrayToReturn;
	}
}
