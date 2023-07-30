package app.service;

import app.model.Student;
import app.service.iService.IStudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService<Student> {
    // tạo ra 1 connection để kết nối với dữ liệu từ database
    Connection connection = ConnectionToMySQL.getConnection();

    public StudentService() {
    }

    @Override
    public void add(Student student) {
        String sql = "insert into students(name, age, image) values (? , ? , ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getImage());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findById(int id) {
        List<Student> studentList = findAll();
        for (int i = 0; i < studentList.size() ; i++) {
            if (studentList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(int idEdit, Student student) {
        String sql = "update students set " + "name = ' " + student.getName() + "' age = '" + student.getAge() +
                "' image = '" + student.getImage() + "'" + "where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEdit);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from students where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Bước 2: tạo 1 list để hứng dữ liệu từ database về
    // (lưu ý : trong DB dũ liệu có bao nhiêu trường thì đối tượng có tướng ứng
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        String sql = "select * from students;"; // tạo câu lệnh để đưa lên cơ sở dữ liệu ( nên test câu lệnh mysql trước rồi paste sang bên này)

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); // tạo resultSet hứng dữ liệu từ database

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String image = resultSet.getString("image");

                Student student = new Student(id, name, age, image);
                studentList.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    public List<Student> findByName(String name) {
        List<Student> studentList = findAll();
        List<Student> searchList = new ArrayList<>();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(studentList.get(i).toString());
                searchList.add(studentList.get(i));
            }
        }
        return searchList;
    }
}
