package controllers;

import models.*;
import play.data.*;
import play.*;
import play.mvc.*;
import java.util.*;

import views.html.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import play.Logger;
import static play.data.Form.*;

public class AdminController extends Controller {

    public static Result index() {
      return ok(
        views.html.adminhomepage.render()
      );
    }


}
