package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostIDPositif {

    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set POST api endpoints")
    public String setPostApiEndpoints(){
        return url + "posts";
    }

    @Step("I send POST HTTP request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("user_id","1");
        requestBody.put("title","tugas restfullapi");
        requestBody.put("body","Selamat belajar restfull api testing");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndpoints());
    }

    @Step("I receive valid HTTP response code 201")
    public void receiveHttpResponseCode201(){
        restAssuredThat(response ->response.statusCode(201));
    }

    @Step("I receive valid data for new user")
    public void validateDataNewUser(){
        restAssuredThat(response -> response.body("'user_id'", equalTo("1")));
        restAssuredThat(response -> response.body("'title'", equalTo("tugas restfullapi")));
        restAssuredThat(response -> response.body("'body'", equalTo("Selamat belajar restfull api testing")));
    }

}
