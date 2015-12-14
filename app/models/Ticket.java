package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import play.data.format.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import play.Logger;

@Entity
public class Ticket extends Model {

  @Id
  public Long id;

  @Required
  public String title;
  public String desc;
  public String severity;

  public String owner;
  public String responsible;
  public String status;

  @Formats.DateTime(pattern="MM/dd/yy")
  public String date;

  @ManyToOne(cascade = CascadeType.ALL)
  public User user;

  @OneToMany(mappedBy = "ticket", cascade=CascadeType.ALL)
  public List<Comment> comment = new ArrayList<Comment>();



  public static Finder<Long,Ticket> find = new Finder(Long.class, Ticket.class);

  public static List<Ticket> all() {

    return find.all();
  }

  public static void create(Ticket ticket) {
  	ticket.save();
  }

  public static void delete(Long id) {
  	find.ref(id).delete();
  }

  public static void update(Ticket tic , Long id) {
    Ticket ticket = Ticket.show(id);
    ticket.title = tic.title;
    ticket.desc = tic.desc;
    ticket.severity = tic.severity;
    ticket.owner = tic.owner;
    ticket.responsible = tic.responsible;
    ticket.status = tic.status;
    ticket.date = tic.date;
    //* Logger.debug(tic.title);
    ticket.save();
  }

  public static void status(long id){
    Ticket ticket = Ticket.show(id);
    ticket.status = "open";
    ticket.save();
  }
  public static Ticket show(Long id) {
    return find.byId(id);
  }
}
