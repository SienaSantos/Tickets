package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import play.Logger;

/**
 * User entity managed by Ebean
 */
@Entity
public class User extends Model {

    private static final long serialVersionUID = 1L;

	@Id
    @Constraints.Required
    @Formats.NonEmpty
    public String email;
    @Constraints.Required
    public String first_name;
    @Constraints.Required
    public String last_name;
    @Constraints.Required
    public String phone;
    @Constraints.Required
    public String dept;
    @Constraints.Required
    public String password;
    @Constraints.Required
    public String company;

    public String admin;

    // -- Queries

    public static Model.Finder<String,User> find = new Model.Finder<String,User>(String.class, User.class);

    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

    public static void create(User user) {
      user.save();
    }

    /**
     * Retrieve a User from email.
     */
    public static User findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }

    /**
     * Authenticate a User.
     */
    public static User authenticate(String email, String password) {
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }

    public static String isAdmin(String email , String password){
      User user = User.show(email);
      String str = user.admin;
      return str;
    }

    // --

    public String toString() {
        return "User(" + email + ")";
    }

    public static User show(String email) {
      return find.byId(email);
    }

}
