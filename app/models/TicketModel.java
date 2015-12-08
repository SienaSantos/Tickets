package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
public class TicketModel extends Model {

  @Id
  public Long id;

  @Required
  public String title;
  public String desc;
  public String severity;

  public String owner;
  public String responsible;
  public String status;

  public Date date;

  public static Finder<Long,TicketModel> find = new Finder(
  	Long.class, TicketModel.class
  );

  public static List<TicketModel> all() {
    return find.all();
  }

  public static void create(TicketModel ticket) {
  	ticket.save();
  }

  public static void delete(Long id) {
  	find.ref(id).delete();
  }

}
