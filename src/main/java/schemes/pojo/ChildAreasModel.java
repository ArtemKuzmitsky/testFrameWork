package schemes.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class ChildAreasModel {
        String id;
    @JsonProperty("name")
        String name;
        String countryCode;
        String flag;
        String parentAreaId;
        String parentArea;

        public ChildAreasModel(){

        }
        public ChildAreasModel(String id, String name, String countryCode, String flag, String parentAreaId, String parentArea) {
            this.id = id;
            this.name = name;
            this.countryCode = countryCode;
            this.flag = flag;
            this.parentAreaId = parentAreaId;
            this.parentArea = parentArea;
        }

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


}
