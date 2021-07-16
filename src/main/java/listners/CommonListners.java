package listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.Base;
import util.ExtentReportNG;

public class CommonListners extends Base implements ITestListener  {
	
	ExtentReports extent=ExtentReportNG.getReportobject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	
	//public static Logger log=(Logger) LogManager.getLogger(Listners.class.getName());
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test=	extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").
					get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//log.info("Going to capture Screenshot inside TestFailure method");
		//Capture ScreenShot on test failure
		try {
			extentTest.get().addScreenCaptureFromPath(takeScreenShotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		extentTest.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
