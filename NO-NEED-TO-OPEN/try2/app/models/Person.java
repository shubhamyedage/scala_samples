package models;


import util.DBUtil;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Person {
    public String name;
    public int id;
    public static int count = 0;

    public Person(String name) throws SQLException, ClassNotFoundException {
        this.name = name;
        this.id = count++;
    }

    public Person(int id) throws SQLException, ClassNotFoundException {
        this.id = id;
    }

    public Person(int id, String name) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.name = name;
    }


    public static Person getPersonName(Map<String, String[]> stringMap) throws SQLException, ClassNotFoundException {
        String name = getPerson(stringMap, "name");
        if (name.equals("")) {
            throw new ClassNotFoundException("No matches Found");
        }
        return new Person(name);
    }

    public static String getPerson(Map<String, String[]> form, String name) throws SQLException, ClassNotFoundException {
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
            return "";
        }
        return form1.get(name);
    }

    public boolean save() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = DBUtil.getConnection().prepareStatement("insert into person(id,name) values (?,?)");
        if (name.isEmpty()) {
            return false;
        } else {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            return stmt.execute();
        }
    }

//    public List<Person> get() throws SQLException, FileNotFoundException, ClassNotFoundException {
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from person");
//        List<Person> personSet = new ArrayList<>();
//        while (resultSet.next()) {
//            String str = resultSet.getString("name");
//            personSet.add(new Person(str));
//        }
//        return personSet;
//    }

    public static Boolean remove(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement("delete from person where id=?");
        preparedStatement.setInt(1, id);
        return preparedStatement.execute();
    }

    public static Boolean update(int id, String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement("update person set name=? where id=?");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        if (preparedStatement.execute()) {
            throw new FileNotFoundException("ID Not found!");
        }
        return true;
    }

    public static String getListPerson() throws SQLException, ClassNotFoundException {
        Statement stmt = DBUtil.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("select name from person");
        String list = "";
        StringBuffer stringBuffer = new StringBuffer("");
        while (resultSet.next()) {
            list = String.valueOf(stringBuffer.append("<h1>"+resultSet.getString("name")+"</h1>"));
        }
        if(list.trim().isEmpty()) {
            throw new ClassNotFoundException("No Records Found!");
        }
        return list;
    }
}
