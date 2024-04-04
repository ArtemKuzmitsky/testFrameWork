package schemes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "searchData",
        "login",
        "password"
})
public class TestData {
    @JsonProperty("searchData")
    String searchData;
    @JsonProperty("login")
    String login;
    @JsonProperty("password")
    String password;

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("searchData")
    public String getSearchData() {
        return searchData;
    }
}
