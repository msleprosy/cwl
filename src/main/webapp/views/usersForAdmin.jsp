<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CWLHub Users for admin</title>
    <style>
        a {
            color: #000 !important;
            text-decoration: none;
        }
    </style>
</head>
<body>
<table width="100%">
    <tr>
        <div style="background: #E0E0E0; height: 40px; padding: 5px;">
            <div style="float: left">
                <h3><a href="<%=request.getContextPath()+"/home"%>">CWLHub</a></h3>
            </div>

            <div style="float: left; padding-left: 20px">
                <h3><a href="<%=request.getContextPath()+"/admin"%>">Admin page</a></h3>
            </div>

            <div style="float: right; padding: 10px; text-align: right;">
                <a href="<%=request.getContextPath()+"/views/usersForAdmin.jsp"%>">Users</a>
                <a href="<%=request.getContextPath()+"/views/groupsForAdmin.jsp"%>">Groups</a>
                <a href="<%=request.getContextPath()+"/views/groupsForAdmin.jsp"%>">Snippets</a>
                <a href="">Profile</a>
                <a href="<%=request.getContextPath()+"/logout"%>">Logout</a>
            </div>
        </div>
    </tr>

    <tr>
        <table border="2px black" style="margin: auto">
            <thead>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Ban</th>
            </thead>
            <tbody>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td align="center">
                    <% if (true) { %>
                    <button>
                        <a href="">Ban</a>
                    </button>
                    <%} else { %>
                    <button>
                        <a href="">Unban</a>
                    </button>
                    <%} %>
                </td>
            </tbody>
        </table>
    </tr>

    <tr>
        <div style="background: #E0E0E0; text-align: center; padding: 5px; margin-top: 10px;">
            @Copyright BestCommandEpam
        </div>
    </tr>
</table>
</body>
</html>