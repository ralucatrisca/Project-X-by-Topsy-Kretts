package interfaces.services;

import entities.Person;

import java.sql.SQLException;

/**
 * Created by POF4CLJ on 25.07.2016.
 */
public interface IDbService {

    void connectToDerby() throws SQLException;

    void createTable() throws SQLException;

    void insertObject(Person person);

    void deleteValues(String s) throws SQLException;

    void query(String s) throws SQLException;

}
