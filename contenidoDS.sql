use poliventas;

insert into Rol values
(1,'Administrador'),
(2,'Vendedor'),
(3,'Comprador');

insert into usuario values 
('0932162228','Eduardo','Tigse',967735014,true,'eduatigs@gmail.com','Duran','eduatigs','admi',1,1),
('0968201528','Henry','Maticurema',968300512,true,'hmaticu@gmail.com','Alborada','hmaticu','vend',2,1),
('0969842028','Lorena','Espinoza',912307522,true,'loresp@gmail.com','Brisas del rio','loresp','vend',2,1),
('0923210424','Alvaro','De la Fuente',968421044,false,'alvfue@gmail.com','Orquideas','alvfue','comp',3,1),
('0928650317','Luis','Villamar',968471032,false,'luisvil@gmail.com','Alborada','luisvil','comp',3,1);

insert into articulo values
(1,'marcador','oficina','2018-12-12',12.50,2,3.5,1),
(2,'pizarra','oficina','2018-06-01',20.00,5,4.1,1),
(3,'computadora','oficina','2018-07-24',200.00,5,2.3,1),
(4,'maleta verde','educacion','2018-08-19',45.50,3,2.5,1),
(5,'maleta roja','educacion','2018-10-09',60.00,0,1.8,1),
(6,'maleta verde','educacion','2018-11-05',50.00,6,2.5,1),
(7,'zapatos','moda','2018-07-15',32.00,4,3.5,1),
(8,'camisa rayas','moda','2018-05-11',25.00,2,4.1,1),
(9,'billetera','moda','2018-08-12',26.00,3,4.5,1),
(10,'baterias','tecnologia','2018-10-28',1.25,5,3.9,1),
(11,'audifonos','tecnologia','2018-12-30',2.00,1,4.8,1);

insert into administrador values
(101,1,'0932162228');

insert into comprador values
(301,3,'0923210424'),
(302,3,'0928650317');

insert into vendedor values
(201,2.3,2,'0968201528'),
(202,3.5,2,'0969842028');

insert into pago values 
(1,'efectivo'),
(2,'aplicacion'),
(3,'aplicacion');

insert into pedido values
(1001,'entregado','2016-05-16',600.00,301,202),
(1002,'pendiente','2018-10-20',25.00,301,201),
(1003,'pendiente','2018-11-27',645.50,302,201),
(1004,'entregado','2017-10-09',80.00,301,202),
(1005,'pendiente','2018-11-15',50.00,302,201),
(1006,'entregado','2018-12-21',32.00,301,202),
(1007,'entregado','2018-11-19',80.00,301,202);

insert into PagoEfectivo values
(110,1);

insert into Tarjeta values
(1245634512781547,'2019-12-01','luis villamar','Pacifico'),
(6532155201200478,'2020-08-01','alvaro de la fuente','Bolivariano');

insert into PagoApp values
(220,40,1245634512781547,2),
(221,60,6532155201200478,3);

insert into venta values
(2001,'exitosa','City Mall',1001,202,1),
(2002,'pendiente','Duran',1002,201,1),
(2003,'exitosa','Aerp. Guayaquil',1003,201,2),
(2004,'exitosa','Mall del Sol',1004,202,3),
(2005,'pediente','Comisariato Sam',1005,201,1),
(2006,'pendiente','Comisariato Alb',1006,202,1),
(2007,'anulada','Mall del Sol',1007,202,3);


insert into calificacion values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

insert into calificacion_articulo values
(1,3),
(1,3),
(1,3),
(2,4),
(3,1),
(3,1),
(4,5),
(5,2),
(6,3),
(7,4),
(8,2),
(9,4),
(10,5),
(11,2);

insert into calificacion_vendedor values
(201,2),
(201,3),
(202,4),
(202,4),
(202,5),
(201,3);

insert into pedido_articulo values
(1001,3,3),
(1002,1,2),
(1004,2,4),
(1003,3,3),
(1003,4,1),
(1005,8,2),
(1006,7,1),
(1007,5,1),
(1007,2,1);

insert into vendedor_articulo values
(201,1,10),
(201,3,20),
(202,2,12),
(202,4,15),
(201,5,21),
(202,6,23),
(202,7,15),
(201,8,18),
(201,9,19),
(202,10,16),
(201,11,14);

create user 'eduatigs' identified by 'admi';
create user 'hmaticu' identified by 'vend';
create user 'loresp' identified by 'vend';
create user 'alvfue' identified by 'comp';
create user 'luisvil' identified by 'comp';

grant select, insert, update on poliventas.Pedido to 'alvfue';
grant select, insert,  update on poliventas.Pedido to 'luisvil';

grant select, insert, update on poliventas.Pedido to 'hmaticu';
grant select, insert,  update on poliventas.Pedido to 'loresp';
grant select, insert, update on poliventas.Articulo to 'hmaticu';
grant select, insert, update on poliventas.Articulo to 'loresp';
grant select, insert, update on poliventas.Venta to 'hmaticu';
grant select, insert, update on poliventas.Venta to 'loresp';

grant select, insert, update on poliventas.Usuario to 'eduatigs';
grant select, insert, update on poliventas.Articulo to 'eduatigs';
grant select, insert, update on poliventas.Pedido to 'eduatigs';