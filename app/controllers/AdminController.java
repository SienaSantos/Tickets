package controllers;

import models.*;
import play.data.*;
import play.*;
import play.mvc.*;
import java.util.*;

import views.html.admin.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import play.Logger;
import static play.data.Form.*;

public class AdminController extends Controller {

    public static Result index() {
      return ok(
        views.html.admin.adminhomepage.render()
      );
    }

    public static Result createUser()
    {
      Form<User> filledForm = userCreationForm.bindFromRequest();
      if(filledForm.hasErrors())
      {
        Logger.debug("hm  "+filledForm);
        return badRequest(
          views.html.admin.usercreation.render(User.findAll(),filledForm));
      }
      else {
        User.create(filledForm.get());
        Logger.debug("create :  "+filledForm);
        return redirect(routes.AdminController.index());
      }
    }

    public static Result createNew()
    {
      return ok(views.html.admin.usercreation.render(User.findAll(),userCreationForm));
    }

    static Form<User> userCreationForm = Form.form(User.class);
}
