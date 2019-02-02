use poliventas;

-- cantidad de ventas por semana
create view ventasPorSemana as
select count(v.idVenta) as cantidadVentas, pa.nombre as formaDePago, p.fechaEntrega  
from Venta v 
join Pedido p on p.idPedido=v.pedid 
JOIN Pago pa on pa.idPago = v.formaPago
WHERE p.fechaEntrega like '2018%' 
GROUP BY v.formaPago, v.vend
ORDER BY p.fechaEntrega;

-- articulos mas buscados 
create view ArticulosMasBuscados as 
select a.nombre 
from Articulo a JOIN pedido_articulo pa on pa.art = a.idArticulo
JOIN Pedido p ON pa.pedid = p.idPedido 
WHERE vecesBuscadas >= (select avg(vecesBuscadas) from Articulo) 
AND fechaEntrega LIKE '2018%' limit 10;

-- consultar informacion de un usuario
delimiter ||
create procedure consultarUsuario(in id varchar(10))
begin
	select * from Usuario JOIN Rol on rol = idRol where cedula = id;
end ||
delimiter ;

-- consultar articulo por su nombre
delimiter ||
create procedure consultarArticulo(in nombArt varchar(20))
begin
	select * from Articulo where nombre like '%nombArt%';
end ||
delimiter ;

-- eliminar usuario
delimiter ||
create procedure eliminarUsuario(in id varchar(10) )
begin
	update usuario set disponible = false where id=cedula;
end ||
delimiter ;

-- eliminar articulo
delimiter ||
create procedure eliminarArticulo(in id varchar(10) )
begin
	update articulo set disponible = false where id=idArticulo;
end ||
delimiter ;

delimiter ||
create trigger calcularTotal before insert on pedido for each row
begin
	set new.costoTotal = (select sum(a.precio * pa.cantidad) from articulo a, pedido_articulo pa, pedido p WHERE
    a.idArticulo=pa.art and pa.pedid=p.idPedido and p.idPedido=new.idPedido);
end ||
delimiter ;

-- encontrar los pedidos pendientes de un comprador.
delimiter ||
create procedure pedidosPendientes (in id varchar(10))
begin
select *
from pedido p, usuario u, comprador c
where u.cedula = c.idUser and c.idComprador = p.compr and p.estado = 'pendiente' and u.cedula = id;
end ||
delimiter ;

-- crear un usuario nuevo
delimiter ||
create procedure crearUsuario(in id varchar(10), in nomb varchar(20), in apell varchar(20), in phone int, in ws boolean, in mail varchar(30), in address varchar(30), in username varchar(20), in passwd varchar(20), in rol int)
begin

insert into Usuario values(id,nomb,apell,phone,ws, mail,address,username,passwd,rol,1);

end ||
delimiter ;

-- crear un articulo nuevo
delimiter ||
create procedure crearArticulo(in id varchar(10), in nomb varchar(20), in catgo varchar(20), in timeMax date, in cost decimal(5,2))
begin

insert into Articulo values(id,nomb,catgo,timeMax,cost,0,0,1);

end ||
delimiter ;

-- actualiza la calificacion promedio de un usuario
delimiter ||
create procedure calificarUser(in id varchar(10))
begin

update vendedor rateProm set rateProm = (select avg(cantidad) from calificacion join Calificacion_Vendedor on idc=rate where vend = id)
where idVendedor=id;

end ||
delimiter ;

-- actualiza la calificacion promedio de un articulo
delimiter ||
create procedure calificarProduc(in id int)
begin

update Articulo rateProm set rateProm = (select avg(cantidad) from calificacion join Calificacion_Articulo on idc=rate where art = id)
where idArticulo=id;

end ||
delimiter ;

-- metodo para conocer los pedidos pendientes de un comprador (idcompra)
delimiter ||
create procedure conocerPedidosPendientes(IN idcompra int)
begin
select * from Pedido 
where compr = idcompra and estado = 'pendiente';
end ||
delimiter ;

delimiter ||
create procedure conocerVentasPorVendedor(in idVende int)
begin
select * from Venta
where vend = idVende;
end ||
delimiter ;