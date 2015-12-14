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

public class Application extends Controller {

    public static Result index() {
    return redirect(routes.Application.login());
    }

    public static Result home(){
      return ok(views.html.homepage.render());
    }

    public static class Login {

        public String email;
        public String password;

        public String validate()
        {
            if(User.authenticate(email, password) == null)
            {
                return "Invalid user or password";
            }
            return null;

        }
        public String check(){
          if(User.isAdmin(email, password) == "true"){
            return "true";
          }
          return "false";
        }

    }//*login


    public static Result createUser()
    {
      Form<User> filledForm = userForm.bindFromRequest();
      if(filledForm.hasErrors())
      {
        Logger.debug("hm  "+filledForm);
        return badRequest(
          views.html.login.render(form(Login.class),User.findAll()));
      }
      else {
        User.create(filledForm.get());
        Logger.debug("hm  "+filledForm);
        return redirect(routes.Application.index());
      }
    }

    public static Result login()
    {
        return ok(login.render(form(Login.class),User.findAll()));
    }

    /**
     * Handle login form submission.
     */
    public static Result authenticate()
    {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        Logger.debug("eto:  " + loginForm.get().email);
        if(loginForm.hasErrors())
        {
            return badRequest(login.render(loginForm,User.findAll()));
        }
        else {
            String level = User.isAdmin(loginForm.get().email,loginForm.get().password);
            Logger.debug("eto yung nireturn:  " + level);
            session("email", loginForm.get().email);
              if(level.equals("true")){
                return ok(views.html.adminhomepage.render());
              }
              else
              return redirect(
                  routes.Application.home()
              );
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout()
    {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
    }

    static Form<User> userForm = Form.form(User.class);
}
