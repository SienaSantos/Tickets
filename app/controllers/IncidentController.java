package controllers;

import models.*;
import play.data.*;
import play.*;
import play.mvc.*;
import java.util.*;
import views.html.admin.*;
import views.html.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import play.Logger;

public class IncidentController extends Controller {

final static Log _log = LogFactory.getLog(IncidentController.class);

    public static Result index() {
        return redirect(routes.IncidentController.incidents());
    }

    public static Result incidents(){
	    return ok(
    		views.html.admin.incidents.render(Incident.all(), incidentForm)
	  	);
    }

    public static Result createIncident(){
    	Form<Incident> filledForm = incidentForm.bindFromRequest();
    	if(filledForm.hasErrors()){
        Logger.debug("hm  "+filledForm);
    		return badRequest(
    			views.html.admin.incidents.render(Incident.all(), filledForm));

    	}
      else {
    		Incident.create(filledForm.get());

    		return redirect(routes.IncidentController.incidents());
    	}
    }

    // public static Result deleteIncident(Long id){
    // 	Incident.delete(id);
    // 	return redirect(routes.IncidentController.incidents());
    // }

    // public static Result updateIncident(Long id){
    //   Form<Incident> filledForm = displayIncidentForm.bindFromRequest();
    //   if(filledForm.hasErrors()){
    //     return badRequest("Please check ");
    // }
    // else{
    //   Incident.update(filledForm.get());
    //   return redirect(routes.IncidentController.incidents());
    // }
    // }
    // public static Result editIncident(Long id){
    //   return ok(views.html.admin.displayIncidentForm.render(Incident.show(id), incidentForm));
    // }


    public static Result showIncident(Long id){
      //*Ticket var = Ticket.show(id);
      //*return ok("hmm"+var.title);
      return ok(views.html.displayIncidentForm.render(Incident.show(id), incidentForm));
    }

    static Form<Incident> incidentForm = Form.form(Incident.class);
    static Form<Incident> displayIncidentForm = Form.form(Incident.class);

}
