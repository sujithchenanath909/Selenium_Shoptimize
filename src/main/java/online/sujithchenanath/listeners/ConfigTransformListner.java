package online.sujithchenanath.listeners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;

import online.sujithchenanath.util.annottations.TestData;
import online.sujithchenanath.util.dataProviders.TestDataProvider;
import online.sujithchenanath.util.testdata.factory.TestDataReaderFactory;

public class ConfigTransformListner implements IAnnotationTransformer{
	public static Logger log = LogManager.getLogger(TestDataProvider.class.getName());
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		Annotation methodAnnotations[] = testMethod.getAnnotations();
		for (Annotation mAnnotation : methodAnnotations) {
			if (mAnnotation instanceof TestData) {
				log.info("TestData annotation found ,setting dataProvider ..");
				 annotation.setDataProviderClass(online.sujithchenanath.util.dataProviders.TestDataProvider.class);
		         annotation.setDataProvider("getTestData");
			}
	
		} 
	}

	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
	}

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, method);
	}

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, method);
	}

	@Override
	public void transform(IListenersAnnotation annotation, Class<?> testClass) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, testClass);
	}

}
