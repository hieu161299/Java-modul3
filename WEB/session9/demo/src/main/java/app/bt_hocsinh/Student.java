package app.bt_hocsinh;

public class Student {
    private String id ;
    private String name;
    private String age;

    public Student() {
    }

    public Student(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mã sinh viên : " + id + " \n " + "Tên sinh viên : " + name + " \n " + "Tuổi sinh viên : " + age + " \n ";
    }
}
