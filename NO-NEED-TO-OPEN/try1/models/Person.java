package models;


import util.DBUtil;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    public String name;
    public int id;
    public static int count=0;
    private Connection connection = DBUtil.getConnection();

    public Person(String name) throws SQLException, ClassNotFoundException {
        this.name = name;
        this.id=count++;
    }
    public Person() throws SQLException, ClassNotFoundException {
    }
    public static Person getPerson(Map<String, String[]> form) throws SQLException, ClassNotFoundException {
        Map<String, String> form1 = new HashMap<>();

//        Set<Map.Entry<String, String[]>> entries = form.entrySet();
//                .filter(e -> e.getValue().length > 0)
//                .forEach(e -> form1.put(e.getKey(), e.getValue()[0]));
//

        for (String key : form.keySet()) {
            if (key.trim().length() > 0 && form.get(key).length > 0) {
                form1.put(key, form.get(key)[0]);
            }
        }
        if (form1.size() < 1) {
           //throw new IllegalArgumentException("Insufficient Parameters");
        return new Person("");
        }
        String name = form1.get("name");

        return new Person(name);
    }

    public boolean save() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = connection.prepareStatement("insert into person(id,name) values (?,?)");
        if(name.isEmpty())
        {
            return false;
        }
        else {
            stmt.setInt(1,id);
            stmt.setString(2, name);
            return stmt.execute();
        }
    }

    public List<Person> get() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from person");
        List<Person> personSet = new ArrayList<>();
        while (resultSet.next()) {
            String str = resultSet.getString("name");
            personSet.add(new Person(str));
        }
        return personSet;
    }

    public Boolean remove(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from person where id=?");
        preparedStatement.setInt(1, id);
        return preparedStatement.execute();
    }

    public Boolean update(int id, String name) throws SQLException, FileNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement("update person set name=? where id=?");
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2, id);

        if(preparedStatement.execute()) {
            throw new FileNotFoundException("ID Not found!");
        }

        return true;
    }
}
