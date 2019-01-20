use poliventas;

create view ventasPorSemana as
select count(v.idVenta) as cantidadVentas, pa.nombre as formaDePago, p.fechaEntrega  
from Venta v 
join Pedido p on p.idPedido=v.pedid 
JOIN Pago pa on pa.idPago = v.formaPago
WHERE p.fechaEntrega like '2018%' 
GROUP BY v.formaPago, v.vend
ORDER BY p.fechaEntrega;

create view ArticulosMasBuscados as 
select a.nombre 
from Articulo a JOIN pedido_articulo pa on pa.art = a.idArticulo
JOIN Pedido p ON pa.pedid = p.idPedido 
WHERE vecesBuscadan >= (select avg(vecesBuscadan) from Articulo) 
AND fechaEntrega LIKE '2018%' limit 10;

-- consultar informacion de un usuario
delimiter ||
create procedure consultarUsuario(in id varchar(10), out nmb varchar(20), out apl varchar(20), out tel int, out dir varchar(30) )
begin
	select nombre, apellido, telefono, direccion into 
    nmb, apl, tel, dir from Usuario where cedula = id;
end ||
delimiter ;

-- consultar articulo por su nombre
delimiter ||
create procedure consultarArticulo(in nombArt varchar(20), out cod int, out nb varchar(20), out dat date, out costo decimal(5,2))
begin
	select idArticulo, nombre, categoria, tiempoMaximo, precio into 
    cod, nb, dat, costo from Articulo where nombre like '%nombArt%';
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
create procedure pedidosPendientes (in id varchar(10), out cod int, out state varchar(10), out dat date, out total decimal(5,2), out nmb varchar(20))
begin
select p.idPedido, p.estado, p.fechaEntrega, p.costoTotal, u.nombre 
into cod, state, dat, total, nmb
from pedido p, usuario u, comprador c
where u.cedula = c.idUser and c.idComprador = p.compr and p.estado = 'pendiente' and u.cedula = id;
end ||
delimiter ;