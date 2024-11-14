package com.solncev.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Processing GET request for hello");
        PrintWriter writer = resp.getWriter();
        writer.println("Hello!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Processing POST request for hello");
        PrintWriter writer = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.println(requestBody);
    }
}
