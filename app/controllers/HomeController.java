package controllers;

import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    public HomeController() {
    }

    public Result index() {
        return ok(Json.toJson("Feito por: Humberto Barros de Alencar Terceiro"));
    }
}
