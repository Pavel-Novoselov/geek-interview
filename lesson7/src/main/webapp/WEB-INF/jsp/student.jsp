<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.geek.lesson7.helpers.JspUsers" %>
<%@ page import="com.geek.lesson7.models.Student" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<Student> studentsList = JspUsers.getAllStudents();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
</head>
<body class="bg-gradient-primary">

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
<%--                <div class="d-sm-flex align-items-center justify-content-between mb-4">--%>
<%--                    <h1 class="h3 mb-0 text-gray-800">Users</h1>--%>
<%--                    <a href="${pageContext.request.contextPath}/add_user_form" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i--%>
<%--                            class="fas fa-user-plus fa-sm text-white-50"></i> New user</a>--%>
<%--                </div>--%>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Students list</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table stripe table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>First Name</th>
                                    <th>Age</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Id</th>
                                    <th>First Name</th>
                                    <th>Age</th>
                                    <th>Actions</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <%
                                    for (final Student student : studentsList) {
                                        out.println("<tr>");
                                        out.println("<td>" + student.getId() + "</td>");
                                        out.println("<td>" + student.getName() + "</td>");
                                        out.println("<td> " + student.getAge() + "</td>");
                                    }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- Content Row -->
                <div class="row">

                </div>
            </div>

        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->

</div>


<!-- End of Page Wrapper -->
</body>
<%--<jsp:include page="#"/>--%>
</html>
