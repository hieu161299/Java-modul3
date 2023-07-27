package app.bt_hocsinh;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements Management<Student> {
    private List<Student> studentList ;

    public StudentManagement() {
        this.studentList = new ArrayList<>();
        Student student1 = new Student("1","hieu","24");
        Student student2 = new Student("2","trieu","21");
        Student student3 = new Student("3","son","23");
        Student student4 = new Student("4","tuan","26");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
    }


    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void delete(int index, Student student) {

    }

    @Override
    public int findIndex(int index) {
        return 0;
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }
}
