package com.codeup.reviewlister.controllers;


import com.codeup.reviewlister.Config;
import com.codeup.reviewlister.QuotesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/quotes/star")
public class StarQuoteServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("quote_id"));
        System.out.println(id);
        Config config = new Config();
        QuotesDao quotesDao = new QuotesDao(config);
        quotesDao.star(id);
        resp.sendRedirect("/quotes");
    }
}
