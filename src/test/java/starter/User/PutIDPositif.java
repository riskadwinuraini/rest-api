package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutIDPositif {

    protected String url = "https://jsonplaceholder.typicode.com";

    @Step("I set PUT api endpoints")
    public String setPutApiEndpoints(){
        return url + "/posts/1";
    }

    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("user_id", "1");
        requestBody.put("title","tugas restfullapi");
        requestBody.put("body","Selamat belajar restfull api testing");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).put(setPutApiEndpoints());
    }

    @Step("I receive valid data for update user")
    public void validateDataUpdateUser(){
        restAssuredThat(response -> response.body("'user_id'", equalTo("1")));
        restAssuredThat(response -> response.body("'title'", equalTo("tugas restfullapi")));
        restAssuredThat(response -> response.body("'body'", equalTo("Selamat belajar restfull api testing")));
    }
}
