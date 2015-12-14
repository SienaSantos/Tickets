package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import play.Logger;

@Entity
public class Access extends Model {
    @Id
    public Long id;

    public Boolean canAdd;
    public Boolean canRead;
    public Boolean canUpdate;
    public Boolean canDelete;

    public Long userId;
}
