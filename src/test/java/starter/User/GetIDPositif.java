package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetIDPositif {

    protected static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set GET endpoints")
    public String setGetEndpoints(){
        return url + "posts/1";
    }

    @Step("I send GET HTTP request")
    public void getHTTPrequest(){
        SerenityRest.given()
                .when()
                .get(setGetEndpoints());

    }
    @Step("I receive valid data for detail user")
    public void HTTPresponse200(){
        restAssuredThat(response ->response.statusCode(200));
    }
    @Step("I receive valid HTTP response code 200")
    public void valiData(){
        restAssuredThat(response ->response.statusCode(200));
    }


}
