package com.epam.cwlhub.servlets;

import com.epam.cwlhub.entities.snippet.Snippet;
import com.epam.cwlhub.services.SnippetService;
import com.epam.cwlhub.services.impl.SnippetServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.epam.cwlhub.constants.Endpoints.*;

@WebServlet(name = "HomeServlet", urlPatterns = HOME_URL)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SnippetService snippetService = SnippetServiceImpl.getInstance();
        List<Snippet> snippets = snippetService.findByGroupId(1L);
        System.out.println(snippets.size());
        req.setAttribute("snippets", snippets);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(HOME);
        dispatcher.forward(req, resp);
    }
}
