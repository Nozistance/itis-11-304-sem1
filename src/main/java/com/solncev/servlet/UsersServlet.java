package com.solncev.servlet;

import com.solncev.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Processing GET request for users");
        req.setAttribute("users", List.of(new UserDto("Ivan", 100, "Ivan228")));
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}
