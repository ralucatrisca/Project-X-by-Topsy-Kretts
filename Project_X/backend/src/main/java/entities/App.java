package entities;

import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import format.json.*;
import implementations.EnviromentalRepository;

/**
 * Created by POF4CLJ on 27.07.2016.
 */
public class App {


    public static void main(String args[]) throws SQLException {

        Date d = new Date(1468396165468L);
        Environmental e = new Environmental();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        //sdf.format(d);
        //e.setTime(d);
        System.out.println(sdf.format(d));

    }


}
