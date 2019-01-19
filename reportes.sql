use poliventas;

select count(v.idVenta) as cantidadVentas, pa.nombre as formaDePago, p.fechaEntrega  
from Venta v 
join Pedido p on p.idPedido=v.pedid 
JOIN Pago pa on pa.idPago = v.formaPago
WHERE p.fechaEntrega like '2018%' 
GROUP BY v.formaPago, v.vend
ORDER BY p.fechaEntrega;

select a.nombre 
from Articulo a JOIN pedido_articulo pa on pa.art = a.idArticulo
JOIN Pedido p ON pa.pedid = p.idPedido 
WHERE vecesBuscadan >= (select avg(vecesBuscadan) from Articulo) 
AND fechaEntrega LIKE '2018%' limit 10;