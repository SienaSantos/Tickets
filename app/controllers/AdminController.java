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

    public static Result userCreate()
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
        Long user_id = filledForm.get().id;
        Logger.debug("id :  "+user_id);
        return redirect(routes.AdminController.accessNew(user_id));
      }
    }

    public static Result userNew()
    {
      return ok(views.html.admin.usercreation.render(User.findAll(),userCreationForm));
    }

    public static Result accessCreate(Long id)
    {
      Form<UserAccess> filledForm = userAccessForm.bindFromRequest();
      Long user_id = id;
      Logger.debug("id na napasa mula sa form :  "+user_id);
      if(filledForm.hasErrors())
      {
        Logger.debug("hm  "+filledForm);
        return badRequest(
          views.html.admin.useraccess.render(User.findAll(),user_id));
      }
      else {
        UserAccess.create(filledForm.get(), user_id);
        Logger.debug("user access create :  "+filledForm);
        return ok(views.html.admin.display.render(UserAccess.findAll()));
        //*return redirect(routes.AdminController.index());
      }
    }

    public static Result accessNew(Long id)
    {
      Logger.debug("accessnew_id "+ id);
      return ok(views.html.admin.useraccess.render(User.findAll(), id));
    }

    static Form<User> userCreationForm = Form.form(User.class);
    static Form<UserAccess> userAccessForm = Form.form(UserAccess.class);

}
