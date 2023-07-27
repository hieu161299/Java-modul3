-- Tạo một database tên abc
-- Một lớp có thể có nhiều học sinh và một học sinh chỉ có thể học tại một lớp.
-- Tạo môt bảng class có id, name không được để trống
-- Tạo một bảng student có id, name không được để trống, age có mặc định là 10 
-- Thêm dữ liệu vào các bảng đã cho.

use student_management;

create table class (
	id int auto_increment not null primary key,
    name varchar(60)
);
create table student(
	id int auto_increment not null primary key,
    name varchar(200) not null,
    age int default 10,
    idClass int ,
    foreign key (idClass) references class(id)
    );
    insert into class(name) values('C04');
    
    select * from class; -- * là tất cả , sau from là tên bảng
    select * from student;
    select id as 'mã học sinh' , name as 'tên học sinh' from student; -- as đổi tên thuộc tính khi in ra
    
    select * from student where id = 2; -- sau where là condition
    select * from student where age between 21 and 23;
    select * from student where age != 23; -- !=  tương đương <> nghĩa là khác
    select * from student where name = 'hiếu'; -- lấy ra thằng có tên là hiếu
    select * from student where name like 't%'; -- lấy ra thằng có tên bắt đầu với chữ t
    select * from student where age in (22 , 26); -- lấy ra thằng có tuổi nằm trong dãy cho trước
    select * from student where age not in (22 , 26); -- not in là phủ định của in
    
    select * from student order by age desc;
    select * from student order by age asc;
    select * from student limit 1;
    
    -- hàm có sẵn ví dụ : min , max , count , avg
    select count(id) as 'số học sinh' from student; -- count để đếm số lượng
    select min(age) as ' tuổi nhỏ nhất' from student;
    select max(age) as ' tuổi lớn nhất' from student;
    select avg(age) as ' tuổi trung bình' from student;
    
    select age,count(id) from student where age < 23 group by age;  -- where đứng trước group by, having nằm sau group by
    select age,count(id) from student group by age; -- where là điều kiện cho cột, having là điều kiện sử với các hàm có sẵn
    
    select * from student , class;
    select * from student , class where class.id = student.idClass;
    select std.* , c.name from student std join class c on c.id = std.idClass;
    select std.* , c.name from student std left join class c on c.id = std.idClass;
    select std.* , c.name from student std right join class c on c.id = std.idClass;
    
    select min(age) from student;
    select name,age from student where age = (select min(age) from student);