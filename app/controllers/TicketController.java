package controllers;

import models.*;
import play.data.*;
import play.*;
import play.mvc.*;

import views.html.*;

public class TicketController extends Controller {

    public static Result index() {
        return redirect(routes.TicketController.tickets());
    }

    public static Result tickets(){
	    return ok(
    		views.html.tickets.render(TicketModel.all(), ticketForm)
	  	);
    }

    public static Result newTicket(){
    	Form<TicketModel> filledForm = ticketForm.bindFromRequest();
    	if(filledForm.hasErrors()){
    		return badRequest(
    			views.html.tickets.render(TicketModel.all(), filledForm)
			);
    	} else {
    		TicketModel.create(filledForm.get());
    		return redirect(routes.TicketController.tickets());
    	}
    }

    public static Result deleteTicket(Long id){
    	TicketModel.delete(id);
    	return redirect(routes.TicketController.tickets());
    }

    static Form<TicketModel> ticketForm = Form.form(TicketModel.class);

}
