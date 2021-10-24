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

@WebServlet(name = "postContactServlet", value = "/postcontact")
public class PostContactServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "To go back, click on the arrow back in the browser";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException  {
        String firstNameParam = (String) request.getAttribute("firstNameAttr");
        String lastNameParam = (String) request.getAttribute("lastNameAttr");
        String phoneParam = (String) request.getAttribute("phoneAttr");
        PrintWriter writer = response.getWriter();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        Contact entity = new Contact();
        entity.setFirstName(firstNameParam);
        entity.setLastName(lastNameParam);
        entity.setPhone(phoneParam);
        System.out.println(entity);
        writer.println(message);
        writer.println();
        writer.println("You can change any field values in the address bar to make changes, see the list of existing contacts at the link (Get All Contacts)");
        writer.println();
        new ContactRepositoryImpl(entity).save(entity);
        writer.println("A new contact "  + entity.getFirstName() +" "+ entity.getLastName()+" "+entity.getPhone() + " has been created");
        writer.flush();
        writer.close();
    }
    public void destroy() {
    }
}

