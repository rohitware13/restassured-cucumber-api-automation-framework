# API Automation Framework

# Technologies

 - RestAssured
 - Java
 - Cucumber
 - Maven
 - Extent Report


# Writing a test
The cucumber features goes in the src/test/resources/FeatureFiles library and should have the ".feature" extension.
You can start out by looking at FeatureFiles/Users.feature. You can extend this feature or make your own features.

# Application Test Data
You can keep application specific test data under main/resources/application.conf

# Executing of test
Provide tag to the scenario and mention the tag in runner file (src/test/java/runner/RunnerClass.java)

# Reporting
You can find execution report under test-output directory
 - Extent HTML Report
 - Logger Report

You can customize the report details from `extent-config.xml`
