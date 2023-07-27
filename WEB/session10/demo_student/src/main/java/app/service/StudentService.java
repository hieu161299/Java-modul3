package app.service;

import app.model.Student;
import app.service.iService.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService<Student> {
    private List<Student>  studentList = new ArrayList<>();

    public StudentService() {
        this.studentList.add(new Student(1 , "tom" , 24 , "https://tiki.vn/blog/wp-content/uploads/2023/03/gojou-luc-nhan.webp"));
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (id == this.studentList.get(i).getId()){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(int id, Student student) {
        int index = findById(id);
        this.studentList.set(index , student);
    }

    @Override
    public void delete(int id) {
        int index = findById(id);
        this.studentList.remove(index);
    }

    @Override
    public List<Student> findAll() {
        return this.studentList;
    }
    public List<Student> findByName(String name){
        List<Student> searchList = new ArrayList<>();
        for (Student student: this.studentList) {
            if (student.getName().contains(name)){

                searchList.add(student);
            }
        }
        return searchList;
    }
}
