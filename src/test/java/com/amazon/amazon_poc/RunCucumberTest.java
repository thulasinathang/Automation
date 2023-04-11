package com.amazon.amazon_poc;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;



import static io.cucumber.junit.platform.engine.Constants.EXECUTION_DRY_RUN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/amazon/amazon_poc")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/result.html")


public class RunCucumberTest {
	

}
