package com.epam.cwlhub.servlets;

import com.epam.cwlhub.entities.group.Group;
import com.epam.cwlhub.entities.snippet.Snippet;
import com.epam.cwlhub.entities.user.UserEntity;
import com.epam.cwlhub.services.GroupService;
import com.epam.cwlhub.services.SnippetService;
import com.epam.cwlhub.services.impl.GroupServiceImpl;
import com.epam.cwlhub.services.impl.SnippetServiceImpl;
import com.epam.cwlhub.services.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.epam.cwlhub.constants.Endpoints.GROUP;
import static com.epam.cwlhub.constants.Endpoints.GROUP_URL;
import static com.epam.cwlhub.listeners.CWLAppServletContextListener.USER_SESSION_DATA;

@WebServlet(name = "SnippetsList", urlPatterns = GROUP_URL)
public class GroupContentServlet extends HttpServlet {
    private final SnippetService snippetService = SnippetServiceImpl.getInstance();
    private final GroupService groupService = GroupServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = ((Map<String, Long>) req.getServletContext().getAttribute(USER_SESSION_DATA))
                .get(req.getSession().getId());
        Optional<UserEntity> receivedUser = UserServiceImpl.getInstance().findById(userId);

        if (receivedUser.isPresent()) {
            if (req.getParameterMap().containsKey("id")) {
                Long groupId = Long.parseLong(req.getParameter("id"));
                List<Snippet> snippets = snippetService.findByGroupId(groupId);
                req.setAttribute("snippets", snippets);

                List<Group> userGroups = groupService.findUsersGroups(receivedUser.get().getId());
                req.setAttribute("userGroups", userGroups);

                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(GROUP);
                dispatcher.forward(req, resp);
            }
        }
    }
}