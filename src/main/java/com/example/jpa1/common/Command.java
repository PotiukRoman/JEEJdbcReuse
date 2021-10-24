package com.example.jpa1.common;

import com.example.jpa1.common.Connect;
import com.example.jpa1.common.Contact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Command {

    public static void insertIon(String firstName, String lastName, String phone, String command) {
        Connect.doTransaction((con) -> {
            try {
                PreparedStatement preparedStatement = con.prepareStatement(command);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, phone);
                preparedStatement.executeUpdate();
                preparedStatement.cancel();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public static void deletIon(int id, String command) {
        Connect.doTransaction((con) -> {
            try {
                PreparedStatement preparedStatement = con.prepareStatement(command);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                preparedStatement.cancel();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public static Contact selectIon(int id, String command) {
        Contact contact = new Contact();
        Connect.doTransaction((con) -> {
            try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(command);//отримання резкльтату запиту
                while (resultSet.next()) {
                    contact.setId(resultSet.getInt(1));
                    contact.setFirstName(resultSet.getString(2));
                    contact.setLastName(resultSet.getString(3));
                    contact.setPhone(resultSet.getString(4));
                //    System.out.println(" " + resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        return contact;
    }

    public static List<Contact> allDataToList(String command) {
        List<Contact> list = new ArrayList<>(10);
        Connect.doTransaction((con) -> {
            try {
                PreparedStatement preparedStatement = con.prepareStatement(command);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString(1));
                    list.add(new ContactRepositoryImpl().getContactById(id));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        return list;
    }

    public static void renovatIon(int id, String first_name, String last_name, String phone, String command) {
        Connect.doTransaction((con) -> {
            try {
                PreparedStatement preparedStatement = con.prepareStatement(command);
                preparedStatement.setString(1, first_name);
                preparedStatement.setString(2, last_name);
                preparedStatement.setString(3, phone);
                preparedStatement.setInt(4, id);
                preparedStatement.executeUpdate();
                preparedStatement.cancel();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public static void listToTable(List<Contact> list, String command) {
        Connect.doTransaction((con) -> {
            try {
                PreparedStatement preparedStatement = con.prepareStatement(command);
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement.setString(1, list.get(i).getFirstName());
                    preparedStatement.setString(2, list.get(i).getLastName());
                    preparedStatement.setString(3, list.get(i).getPhone());
                    preparedStatement.executeUpdate();
                    preparedStatement.cancel();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
       // System.out.println("Метод записує контакти з List<Contact> до таблиці contacts бази даних test2 ");
    }

}
