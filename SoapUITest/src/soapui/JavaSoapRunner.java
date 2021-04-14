package soapui;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class JavaSoapRunner {

	@Test
	public  void testsoap() throws XmlException, IOException, SoapUIException {
		// TODO Auto-generated method stub
		WsdlProject project = new WsdlProject(
				"C:\\Users\\Lenovo\\Desktop\\Finistra\\AutomationSoup-soapui-project_extent.xml");
		WsdlTestSuite testSuite = project.getTestSuiteByName("Testsuite_Auto");
		//WsdlTestCase testCase = testSuite.getTestCaseByName("Script");
		//TestRunner runner=testCase.run(new PropertiesMap(), false);
		//Assert.assertEquals(Status.FINISHED, runner.getStatus());
		
		System.out.println("TC count:"+testSuite.getTestCaseCount());
		
		for (int i = 0; i < testSuite.getTestCaseCount(); i++) {
			WsdlTestCase testCase = testSuite.getTestCaseAt(i);
			TestRunner runner=testCase.run(new PropertiesMap(), false);
			Assert.assertEquals(Status.FINISHED, runner.getStatus());
		}
	}

}
