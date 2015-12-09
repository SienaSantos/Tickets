package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import play.Logger;

@Entity
public class Comment extends Model {

  @Id
  public Long comment_id;

  @Required
  public String comment_desc;

  @ManyToOne
  public Ticket id;



  public static Finder<Long,Comment> find = new Finder(Long.class, Comment.class);

  public static List<Comment> all() {

    return find.all();
  }

  public static void create(Comment comment) {
    Logger.debug(comment.comment_id +" "+ comment.comment_desc+" " +comment.id);
    comment.save();
  }

  public static void delete(Long id) {
  	find.ref(id).delete();
  }

  /* public static void update(Ticket tic , Long id) {
  //   Ticket ticket = Ticket.show(id);
  //   ticket.title = tic.title;
  //   ticket.desc = tic.desc;
  //   ticket.severity = tic.severity;
  //   ticket.owner = tic.owner;
  //   ticket.responsible = tic.responsible;
  //   ticket.status = tic.status;
  //   ticket.date = tic.date;
  //   //* Logger.debug(tic.title);
  //   ticket.save();
  // }

  public static Ticket show(Long id) {
    return find.byId(id);
  }*/
}
