package com.example.jpa1.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.xml.stream.events.Attribute;
import java.io.IOException;


@WebFilter("/*")
public class DemoFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      String paramId = request.getParameter("id");
      String paramfirstName = request.getParameter("firstName");
      String paramlastName = request.getParameter("lastName");
      String paramPhone = request.getParameter("phone");

      request.setAttribute("idAttr",paramId);
      request.setAttribute("firstNameAttr",paramfirstName);
      request.setAttribute("lastNameAttr",paramlastName);
      request.setAttribute("phoneAttr",paramPhone);

      chain.doFilter(request, response);
    }
}
