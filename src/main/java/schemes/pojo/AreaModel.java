package schemes.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class AreaModel {

    @JsonProperty("id")
    private String id;
    private String name;
    private String code;
    private String flag;
    private String parentAreaId;
    private String parentArea;
    @JsonProperty("childAreas")
    private List <ChildAreasModel> childAreas;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getFlag() {
        return flag;
    }

    public String getParentAreaId() {
        return parentAreaId;
    }

    public String getParentArea() {
        return parentArea;
    }

    public List <ChildAreasModel> getChildAreas() {
        return childAreas;
    }

   public static class ChildAreasModel {
        String id;
        @JsonProperty("name")
        String name;
        String countryCode;
        String flag;
        String parentAreaId;
        String parentArea;


        public String getCountryCode() {
            return countryCode;
        }

        public String getFlag() {
            return flag;
        }

        public String getParentAreaId() {
            return parentAreaId;
        }

        public String getParentArea() {
            return parentArea;
        }


        public String getName() {
            return name;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public void setParentAreaId(String parentAreaId) {
            this.parentAreaId = parentAreaId;
        }

        public void setParentArea(String parentArea) {
            this.parentArea = parentArea;
        }


    }
}
