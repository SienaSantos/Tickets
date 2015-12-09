package controllers;

import models.*;
import play.data.*;
import play.*;
import play.mvc.*;

import views.html.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TicketsController extends Controller {

final static Log _log = LogFactory.getLog(TicketController.class);

    public static Result index() {
        return redirect(routes.TicketController.tickets());
    }

    public static Result tickets(){
	    return ok(
    		views.html.tickets.render(TicketModel.all(), ticketForm)
	  	);
    }

    public static Result createTicket(){
    	Form<TicketModel> filledForm = ticketForm.bindFromRequest();
    	if(filledForm.hasErrors()){
    		return badRequest(
    			views.html.tickets.render(TicketModel.all(), filledForm));
    	}
      else {
    		TicketModel.create(filledForm.get());
    		return redirect(routes.TicketController.tickets());
    	}
    }

    public static Result deleteTicket(Long id){
    	TicketModel.delete(id);
    	return redirect(routes.TicketController.tickets());
    }

    public static Result updateTicket(Long id){
      Form<TicketModel> filledForm = displayTicketForm.bindFromRequest();
      if(filledForm.hasErrors()){
        return badRequest("mali");
    }
    else{
      TicketModel.update(id);
      return redirect(routes.TicketController.tickets());
    }
    }
    public static Result editTicket(Long id){
      //*TicketModel var = TicketModel.show(id);
      //*return ok("hmm"+var.title);
      return ok(views.html.displayTicketForm.render(TicketModel.show(id), ticketForm));
    }

    //* public static Result updateTicket(Long id){
    //*   TicketModel.delete(id);
    //*   return redirect(routes.TicketController.tickets());
    //* }

    //* public static Result findTicket(Long id){
    //*   TicketModel.show(id);
    //*   return redirect(routes.TicketController.displayTicket());
    //* }

    public static Result showTicket(Long id){
      //*TicketModel var = TicketModel.show(id);
      //*return ok("hmm"+var.title);
      return ok(views.html.displayTicketForm.render(TicketModel.show(id), ticketForm));
    }

    static Form<TicketModel> ticketForm = Form.form(TicketModel.class);
    static Form<TicketModel> displayTicketForm = Form.form(TicketModel.class);

}
