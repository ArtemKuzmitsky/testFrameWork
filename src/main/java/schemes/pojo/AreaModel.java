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
    @JsonProperty("ChildAreas")
    private List<ChildAreasModel> childAreas;

    public AreaModel(){

    }
    public AreaModel(String id, String name, String code, String flag, String parentAreaId, String parentArea, List<ChildAreasModel> childAreas) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.flag = flag;
        this.parentAreaId = parentAreaId;
        this.parentArea = parentArea;
        this.childAreas =  childAreas;
    }

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

    public List<ChildAreasModel> getChildAreas() {
        return childAreas;
    }

}
