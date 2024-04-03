#Simple Selenium Test FrameWork

##Uses:
* UI: Selenium, TestNG
* API: RestAssured
* Reported: Allure

## Hor to run:

* UI tests: _mvn clean test -Dsurefire.suiteXmlFiles=src\test\resources\suites\smokeTests.xml_

* API test: _mvn clean test -Dsurefire.suiteXmlFiles=src\test\resources\suites\apiTests.xml_

### OR
* Run all tests : _mvn clean test_

## Get report:

* _allure serve target/allure-results_

