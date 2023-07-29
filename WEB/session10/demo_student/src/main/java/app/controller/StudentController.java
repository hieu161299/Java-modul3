package app.controller;

import app.model.Student;
import app.service.StudentService;
import filter.UserSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean check = UserSession.checkSession(request);
        if (check) {
            String action = request.getParameter("action");
            switch (action) {
                case "showAll":
                    showAllStudent(request, response);
                    break;
                case "create":
                    showFormAdd(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "edit":
                    showFormEdit(request, response);
                    break;
                case "search":
                    searchStudent(request, response);
                    break;
                case "detail":
                    showDetail(request, response);
                    break;

            }
        } else {
            response.sendRedirect("/user?action=login");
        }

    }
    // khi click vào tên hiển thị toàn bộ thông tin của sinh viên đó
    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int index = studentService.findById(id);
        Student student = studentService.findAll().get(index);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student_list/detail.jsp");
        dispatcher.forward(request, response);

    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameSearch");

        request.setAttribute("searchList", studentService.findByName(name));
        RequestDispatcher dispatcher = request.getRequestDispatcher("student_list/search.jsp");
        dispatcher.forward(request, response);
    }

    // Sửa thông tin sv
    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);

        int index = this.studentService.findById(id);
        Student student = this.studentService.findAll().get(index);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student_list/edit.jsp");
        dispatcher.forward(request, response);
    }

    // Xóa sinh viên
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentService.delete(id);
        response.sendRedirect("/students?action=showAll");
    }

    // form thêm sinh viên
    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student_list/create.jsp");
        dispatcher.forward(request, response);
    }

    // hiển thị danh sách sinh viên
    private void showAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student_list/showAll.jsp");
        HttpSession session = request.getSession();
        int idUser = (int) session.getAttribute("idUser");
        request.setAttribute("idUser", idUser);
        List<Student> studentList = studentService.findAll();
        request.setAttribute("studentList", studentList);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
            case "search":
                searchStudent(request, response);
                break;
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Student student = getValue(request, response);
        this.studentService.edit(student.getId(), student);
        response.sendRedirect("/students?action=showAll");
    }

    // doget => tạo form add => method = post => dopost => createStudent
    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Student student = getValue(request, response);
        studentService.add(student);
        response.sendRedirect("/students?action=showAll");
    }

    private Student getValue(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String image = request.getParameter("image");
        Student student = new Student(id, name, age, image);

        return student;
    }
}