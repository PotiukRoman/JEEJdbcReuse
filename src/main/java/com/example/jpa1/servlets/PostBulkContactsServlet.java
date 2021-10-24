package com.example.jpa1.servlets;

import com.example.jpa1.common.Contact;
import com.example.jpa1.common.ContactRepositoryImpl;
import java.io.*;
import javax.management.Attribute;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "postBulkContactsServlet", value = "/postbulkcontact")
public class PostBulkContactsServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "To go back, click on the arrow back in the browser";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException  {
        List<Contact> list = new ArrayList<>(3);
        Contact contact1 = new Contact("Stepan", "Petrov", "322");
        Contact contact2  = new Contact("Vasil", "Ivanov", "644");
        Contact contact3 = new Contact("Bogdan", "Pidkova", "862");

        list.add(contact1);
        list.add(contact2);
        list.add(contact3);

        PrintWriter writer = response.getWriter();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        writer.println(message);
        new ContactRepositoryImpl().saveBulk(list);
        writer.println();
        writer.println("Contact list saved, see the list of existing contacts at the link (Get All Contacts)");
        writer.flush();
        writer.close();
    }
    public void destroy() {
    }
}