package apiTests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemes.pojo.AreaModel;
import utils.JsonReader;


public class FootballTests extends BaseApiTest {

    @Test
    public void firstTest() {
        Response response = requests.getAllAreas();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void secondTest() {
        AreaModel areaModelData = JsonReader.loadDataObject(AreaModel.class);
        Response response = requests.getArea(areaModelData.getId());
        AreaModel areaModel = response.getBody().as(AreaModel.class);
        String valueToCheck = areaModel.getChildAreas().get(0).getName();
        String expectedValueToCheck = areaModelData.getChildAreas().get(0).getName();
        Assert.assertEquals(valueToCheck, expectedValueToCheck);
    }

    @Test(enabled = false)
    public void postTestReq() {
        AreaModel areaModelData = JsonReader.loadDataObject(AreaModel.class);
        Response response = requests.dummyPostReq(areaModelData);
    }
}
