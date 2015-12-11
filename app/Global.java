import play.*;
import play.libs.*;
import java.util.*;
import models.*;
import play.data.format.Formatters;
import play.data.format.Formatters.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.avaje.ebean.*;

public class Global extends GlobalSettings {
  public void onStart(Application app) {
    InitialData.insert(app);
  Formatters.register(Date.class,new SimpleFormatter<Date>()
  {
    private final static String PATTERN = "dd-MM-yyyy";

      public Date parse(String text, Locale locale)throws java.text.ParseException
      {
        if(text == null || text.trim().isEmpty()) {
        return null;
        }
        SimpleDateFormat sdf =new SimpleDateFormat(PATTERN, locale);
        sdf.setLenient(false);
        return sdf.parse(text);
      }

      public String print(Date value, Locale locale)
      {
        if(value == null) {
        return "";
        }
        return new SimpleDateFormat(PATTERN, locale).format(value);
      }
    });


  }

  static class InitialData {

      public static void insert(Application app) {
          if(Ebean.find(User.class).findRowCount() == 0) {

              @SuppressWarnings("unchecked")
              Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");

              // Insert users first
              Ebean.save(all.get("users"));

          }
      }

  }
}
