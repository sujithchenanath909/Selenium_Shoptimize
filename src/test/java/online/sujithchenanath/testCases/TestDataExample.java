package online.sujithchenanath.testCases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import online.sujithchenanath.testdatabean.TestDataFile;
import online.sujithchenanath.testdatabean.userdetailsTestData;
import online.sujithchenanath.util.annottations.TestData;
import online.sujithchenanath.util.testdata.factory.TestDataReaderFactory;

@Listeners(online.sujithchenanath.listeners.ConfigTransformListner.class)

public class TestDataExample {

	@Test(groups="dataExample",description="TestCase for testing test data configuration")
	@TestData(source = "userDetails", type = TestDataReaderFactory.JSON,dataBean="online.sujithchenanath.testdatabean.userdetailsTestData")
	public void testMethod(userdetailsTestData data) {
		System.out.println(data.getUsername());
		System.out.println(data.getPassword());
	}

	@Test(groups="dataExample",description="TestCase for testing test data configuration")
	@TestData(source = "testDataFile", type = TestDataReaderFactory.JSON,dataBean="online.sujithchenanath.testdatabean.TestDataFile")
	public void testMethod2(TestDataFile data) {
		System.out.println(data.getUsername());
		System.out.println(data.getPassword());
		System.out.println(data.getTestCase());
	}

}
