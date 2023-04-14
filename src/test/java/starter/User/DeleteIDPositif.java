package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


public class DeleteIDPositif {

    protected static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set DELETE api endpoints")
    public String setDeleteApiEndpoints(){
        return url + "post/1";
    }
    @Step("I send DELETE HTTP request")
    public void sendDeleteHttpRequest(){
        SerenityRest.given().delete(setDeleteApiEndpoints());
    }
}
