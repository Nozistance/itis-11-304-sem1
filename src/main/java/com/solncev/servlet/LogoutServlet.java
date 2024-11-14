package com.solncev.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNullElseGet;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Processing GET request for logout");
        clear(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Processing POST request for logout");
        clear(req, resp);
    }

    private void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Clearing session and cookies");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c :
                    cookies) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }

        HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();
        }

        LOG.info("Redirecting to index.html");
        resp.sendRedirect("index.html");
    }
}
