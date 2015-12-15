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
public class Incident extends Model {

  @Id
  public Long id;

  @Required
  public String incidentdesc;


public static Finder<Long, Incident> find = new Finder(long.class, Incident.class);

public static List<Incident> all() {
  return find.all();
}

public static void create(Incident incident){
incident.save();

}

public static Incident show(Long id) {
  return find.byId(id);
}

}
