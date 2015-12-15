package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import models.*;

import play.Logger;

@Entity
public class UserAccess extends Model {
    @Id
    public Long id;

    public boolean canadd;
    public boolean canread;
    public boolean canupdate;
    public boolean candelete;

    @OneToOne
  	@JoinColumn(name = "userId")
  	public User user;

  public static Model.Finder<Long,UserAccess> find = new Model.Finder<Long,UserAccess>(Long.class, UserAccess.class);
  /**
   * Retrieve all users.
   */
  public static List<UserAccess> findAll() {
      return find.all();
  }

  public static void create(UserAccess useraccess, Long id) {
    User user = User.show(id);
    useraccess.user = user;
    useraccess.save();
  }
  /**
   * Retrieve a UserAccess from email.
   */
  public static UserAccess findByEmail(String email) {
      return find.where().eq("email", email).findUnique();
  }

  // --

  public static UserAccess show(Long id) {
    return find.byId(id);
  }

}
