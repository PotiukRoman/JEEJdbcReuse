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

@WebServlet(name = "deleteContactByIdServlet", value = "/deletecontactbyid")
public class DeleteContactByIdServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "To go back, click on the arrow back in the browser";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException  {
        String idParam = (String) request.getAttribute("idAttr");
        int id = Integer.parseInt(idParam);
        PrintWriter writer = response.getWriter();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        writer.println(message);
        writer.println();
        writer.println("You can enter any existing contact number in the address bar after the slash / to delete it, see the list of existing contacts at the link (Get All Contacts)");
        writer.println();
        new ContactRepositoryImpl().delete(id);
        writer.println("Contact id = "+ id + " has been removed from the table");
        writer.flush();
        writer.close();
    }
    public void destroy() {
    }
}
