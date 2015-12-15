package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import play.Logger;

@Entity
public class UserAccess extends Model {
    @Id
    public Long id;

    public Boolean canAdd;
    public Boolean canRead;
    public Boolean canUpdate;
    public Boolean canDelete;

    public Long user_id;

    @OneToOne
	@JoinColumn(name = "user_id")
	public User user;
}
