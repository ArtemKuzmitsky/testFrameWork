package apiTests;

import api.ApiTestConfig;
import api.requests.ApiRequests;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    public static ApiRequests requests;

    @BeforeClass
    public void setUpTests() {
        ApiTestConfig.setUp();
        requests = new ApiRequests();
    }
}
