use demo2006;
select * from product;

-- Mức 1 ---
-- 1. In ra các sản phẩm có số lượng từ 30 trở lên. --
select * from product where quantity >= 30; 
-- 2. In ra các sản phẩm có số lượng từ 30 trở lên và có giá trong khoảng 100 đến 200.
select * from product where quantity >= 30 and price between 100 and 200;
-- 3. In ra thông tin khách hàng tuổi lớn hơn 18
select * from customer where age > 18;
--  4. In ra thông tin khách hàng họ Nguyễn và lớn hơn 20 tuổi
select * from customer where age > 20 and name like '%nguyễn%';
-- 5. In ra sản phẩm tên bắt đầu bằng chữ M
select * from product where name like 'm%';
-- 6. In ra sản phẩm kết thúc bằng chữ E
select * from product where name like '%e';
-- 7. In ra danh sách sản phẩm số lượng tăng dần
select * from product order by quantity asc;
-- 8. In ra danh sách sản phẩm số lượng giảm dần
select * from product order by quantity desc;

-- Mức 2 
-- 1. In ra tổng số lượng sản phẩm giá nhỏ hơn 300
select sum(quantity) from product where price < 300 ;
-- 2. In tổng số sản phẩm theo từng giá
select price,sum(quantity) from product group by price;
-- 3. In ra sản phẩm có giá cao nhất
select * from product where price = ( select max(price) from product);
-- 4. In ra giá trung bình của tất cả các sản phẩm
select avg(price) as ' giá trung bình tất cả các sản phảm ' from product;
-- 5. In ra tổng số tiền nếu bán hết tất cả sản phẩm.
select sum(price * quantity) from product;
-- 6. Tính tổng số tiền của các sản phẩm giá <300.
select sum(price ) from product where price < 300;
-- 7. Tìm giá bán cao nhất của các sản phẩm bắt đầu bằng chữ M.
select max(price) from product where name like 'm%';
-- 8. Tìm giá bán thấp nhất của các sản phẩm bắt đầu bằng chữ M.
select min(price) from product where name like 'm%';
-- 9. Tìm giá bán trung bình của các sản phẩm bắt đầu bằng chữ M.

-- Mức 3 -- 
-- Thêm bảng category: id, tên
create table category (
	id int auto_increment not null primary key ,
    name varchar(60) not null
);
-- Thêm trường idCategory cho bảng Product
alter table product 
add idCategory int ;
-- tạo trường idCategory là forgeign key 
alter table product 
add foreign key(idCategory) references category(id);

-- 1. In ra tên khách hàng và thời gian mua hàng.
select c.name,o.time from customer c,`order` o where c.id = o.customerId; -- cách 1
select c.name,o.time from customer c join  `order` o on c.id = o.customerId; -- cách 2

-- 2. In ra tên khách hàng và tên sản phẩm đã mua
select c.name,p.name from customer c join `order` o on c.id = o.customerId join orderdetail od on o.id = od.orderId join product p on od.productId = p.id;

-- 3. In ra tổng số lượng sản phẩm từng loại
select c.id,c.name,sum(p.quantity) from category c join product p on c.id = p.idCategory group by idCategory;
-- 4. Đếm số mặt hàng từng loại
select c.id,
c.name,count(p.id) as 'số lượng mặt hàng'
from category c 
join product p on c.id = p.idCategory group by c.id;
-- 5. Tính giá trung bình tất cả các sản phẩm
select avg(price) from product;
-- 6. Tính giá trung bình từng loại
select c.id,c.name,avg(price) as 'giá trung bình từng loại' from category c join product p on c.id = p.idCategory group by c.id;
 -- 7. Tìm sản phẩm có giá lớn nhất theo từng loại
select p.name,
 c.name as 'loại sản phẩm',
 p.price from product p
 join category c on p.idCategory = c.id
 where price = (select max(price) from product);
-- 8. Tính tuổi trung bình của các khách hàng
select avg(age) as 'tuổi trung bình' from customer;
-- 9. Đếm số khách hàng tuổi lớn hơn 30
select count(age) as 'số khách hàng tuổi lớn hơn 30 ' from customer where age > 30;
-- 10. Đếm số lần mua hàng của từng khách hàng
select c.id,c.name, count(o.id) as 'số lần mua hang' from customer c join `order` o on c.id = o.customerId  group by c.id ;
-- 11. Đếm số lượng hóa đơn theo từng tháng
 select month(o.time) as 'tháng' ,count(o.id) from `order` o group by month(o.time) ;
 
 -- 12. In ra mã hoá đơn và giá trị hoá đơn
select od.orderId as 'mã hóa đơn' ,
 sum(p.price * od.quantity) as total_value
 from orderdetail od
 join product p on od.productId = p.id  
 group by od.orderId;

-- 13. In ra mã hoá đơn và giá trị hoá đơn giảm dần
select od.orderId as 'mã hóa đơn' ,
 sum(p.price * od.quantity) as 'total_value'
 from orderdetail od join product p on od.productId = p.id   
 group by od.orderId 
 order by sum(p.price * od.quantity)  desc;

-- 14. Tính tổng tiền từng khách hàng đã mua
select c.id , c.name , sum((p.price * od.quantity))
 from customer c 
 join `order` o on c.id = o.customerId 
 join orderdetail od on o.id = od.orderId
 join product p on od.productId = p.id
 group by c.id;
 
 -- Mức 4 - 10 --
 -- 1. In ra các mã hóa đơn, trị giá hóa đơn bán ra trong ngày 19/6/2006 và ngày 20/6/2006.
select date(o.time) as 'ngày', 
o.id as 'mã hóa đơn',
sum(p.price * od.quantity) as 'trị giá hóa đơn'
from `order` o 
join orderdetail od on o.id = od.orderId
join product p on od.productId = p.id
where month(o.time) = 06 and year(o.time) = 2006 and day(o.time) in (19,20)
group by o.id;
-- 2. In ra các mã hóa đơn, trị giá hóa đơn trong tháng 6/2006, sắp xếp theo ngày (tăng dần) và trị giá của hóa đơn (giảm dần).
select date(o.time) as 'ngày', 
o.id as 'mã hóa đơn',
sum(p.price * od.quantity) as 'trị giá hóa đơn'
from `order` o 
join orderdetail od on o.id = od.orderId
join product p on od.productId = p.id
where month(o.time) = 06 and year(o.time) = 2006 
group by o.id
order by o.time asc,
sum(p.price * od.quantity) desc;
-- 3. In ra danh sách các khách hàng (MAKH, HOTEN) đã mua hàng trong ngày 19/06/2007.
select date(o.time) as 'ngày',  
 c.id as 'mã khách hàng' ,
 c.name as 'tên khách hàng'
 from customer c
 join `order` o on c.id = o.customerId 
 where o.time in ('2006-06-19');
 -- 4. In ra danh sách các sản phẩm (MASP, TENSP) được khách hàng có tên “Nguyen Van A” mua trong tháng 10/2006.
 select p.id as 'mã sản phẩm',
 p.name as 'tên sản phẩm'
 from product p
 join orderdetail od on p.id = od.productId
 join `order` o on od.orderId = o.id
 join customer c on o.customerId = c.id
 where c.name = 'Nguyen Van A' and o.time like '%2006-10%'
 group by p.id
 order by p.id asc;
 
 -- 5. Tìm các số hóa đơn đã mua sản phẩm “Máy giặt” hoặc “Tủ lạnh”.
select o.id as 'mã hóa đơn'
from `order` o 
join orderdetail od on o.id = od.orderId
join product p on p.id = od.productId
where p.name in ('máy giặt', 'tủ lạnh')
group by o.id;

-- 6. In ra danh sách các sản phẩm (MASP, TENSP) không bán được : sản phẩm chưa bán đc thì ở bảng detail ko có thông tin => sản phẩm chưa bán nên ở bảng detail id = null
select p.id as 'mã sản phẩm',
p.name as 'tên sản phẩm'
from product p
left join orderdetail od on p.id = od.productId 
where od.productId is null;

-- 7. In ra danh sách các sản phẩm (MASP, TENSP) không bán được trong năm 2006.



 

 


 