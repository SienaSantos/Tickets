package controllers;

import models.*;
import play.data.*;
import play.*;
import play.mvc.*;

import views.html.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import play.Logger;

public class TicketsController extends Controller {

final static Log _log = LogFactory.getLog(TicketsController.class);

    public static Result index() {
        return redirect(routes.TicketsController.tickets());
    }

    public static Result tickets(){
	    return ok(
    		views.html.tickets.render(Ticket.all(), ticketForm)
	  	);
    }

    public static Result createTicket(){
    	Form<Ticket> filledForm = ticketForm.bindFromRequest();
    	if(filledForm.hasErrors()){
        Logger.debug("hm  "+filledForm);
    		return badRequest(
    			views.html.tickets.render(Ticket.all(), filledForm));

    	}
      else {
    		Ticket.create(filledForm.get());
        
    		return redirect(routes.TicketsController.tickets());
    	}
    }

    public static Result deleteTicket(Long id){
    	Ticket.delete(id);
    	return redirect(routes.TicketsController.tickets());
    }

    public static Result updateTicket(Long id){
      Form<Ticket> filledForm = displayTicketForm.bindFromRequest();
      if(filledForm.hasErrors()){
        return badRequest("Please check ");
    }
    else{
      Ticket.update(filledForm.get(), id);
      return redirect(routes.TicketsController.tickets());
    }
    }
    public static Result editTicket(Long id){
      return ok(views.html.displayTicketForm.render(Ticket.show(id), ticketForm));
    }


    public static Result showTicket(Long id){
      //*Ticket var = Ticket.show(id);
      //*return ok("hmm"+var.title);
      return ok(views.html.displayTicketForm.render(Ticket.show(id), ticketForm));
    }

    static Form<Ticket> ticketForm = Form.form(Ticket.class);
    static Form<Ticket> displayTicketForm = Form.form(Ticket.class);

}
