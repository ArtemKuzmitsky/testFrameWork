package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemes.pojo.AreaModel;
import schemes.pojo.ChildAreasModel;
import utils.JsonReader;


public class FootballTests extends BaseApiTest {

    @Test
    public void firstTest() {
       Response response=requests.getAllAreas();
       Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void secondTest() {
        AreaModel areaModelData = JsonReader.loadDataObject(AreaModel.class);
        ChildAreasModel childAreasModel = JsonReader.loadDataObject(ChildAreasModel.class);
        Response response=requests.getArea(areaModelData.getId());
        AreaModel areaModel = response.getBody().as(AreaModel.class);
        String valueToCheck = areaModel.getChildAreas().get(0).getName();
       // Assert.assertEquals(valueToCheck, "Africa");
    }

    @Test(enabled = false)
    public void postTestReq(){
        Response response = requests.dummyPostReq("");
    }
}
