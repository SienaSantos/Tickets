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

public class MessagesController extends Controller {

final static Log _log = LogFactory.getLog(MessagesController.class);

    public static Result index() {
        return redirect(routes.MessagesController.messages());
    }

    public static Result messages(){
	    return ok(
    		views.html.inbox.render(Ticket.all(), inboxForm)
	  	);
    }

    /////////////////////

    public static Result showTicket(Long id){
      //*Ticket var = Ticket.show(id);
      //*return ok("hmm"+var.title);
      List<Comment> comments = Comment.all();
      Ticket ticket = Ticket.show(id);
      Comment.status(id);

      return ok(views.html.message.render(ticket, inboxForm, comments));
    }

    public static Result deleteTicket(Long id){
    	Ticket.delete(id);
    	return redirect(routes.TicketsController.tickets());
    }

    public static Result createComment(Long id){
      Form<Comment> filledForm = messageForm.bindFromRequest();
      if(filledForm.hasErrors()){
        return badRequest("mali");
      }
      else {
        Comment.create(filledForm.get(), id);
        return redirect(routes.MessagesController.showTicket(id));
      }
    }
    //* public static Result deleteComment(Long id){
    //*   Comment.delete(id);
    //*   return redirect(routes.MessageController.showTicket(id));
    //* }
    static Form<Ticket> inboxForm = Form.form(Ticket.class);
    static Form<Comment> messageForm = Form.form(Comment.class);

}
