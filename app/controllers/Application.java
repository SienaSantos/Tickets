package controllers;

import models.*;
import play.data.*;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
    return redirect(routes.Application.home());
    }

    public static Result home(){
      return ok(
        views.html.homepage.render()
      );
    }
}
