package com.epam.cwlhub.servlets.group;

import com.epam.cwlhub.dao.group.GroupException;
import com.epam.cwlhub.entities.group.Group;
import com.epam.cwlhub.services.group.GroupService;
import com.epam.cwlhub.services.group.GroupServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ViewUsersGroups", urlPatterns = "/usersgroups")
public class ViewUsersGroupsServlet extends HttpServlet {

    private String TARGET_PAGE_ROOT = "/WEB-INF/jsp/";
    private GroupService groupService = GroupServiceImpl.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Group> groups = groupService.findUsersGroups(getUserId(req)
                            .orElseThrow(() -> new GroupException("Can't get user_id from request")));
            if (!groups.isEmpty()) {
                req.setAttribute("groups", groups);
            }
            forwardToPage(req, resp, "usersGroups.jsp");
        } catch (Exception e) {
            throw new GroupException("Can't display user's groups", e);
        }
    }

    private void forwardToPage(HttpServletRequest req, HttpServletResponse resp, String dest)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(TARGET_PAGE_ROOT + dest);
        dispatcher.forward(req, resp);
    }

    private Optional<Long> getUserId(HttpServletRequest request) {
        try {
            return Optional.of(Long.parseLong(request.getParameter("user_id")));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
