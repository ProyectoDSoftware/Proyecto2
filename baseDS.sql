drop database Poliventas;
create database Poliventas;
use Poliventas;

create table Rol(
idRol int primary key,
nombreRol varchar(15)
);

create table Usuario(
cedula varchar(10) primary key,
nombre varchar(20),
apellido varchar(20),
telefono int,
whatsapp boolean,
email varchar(30),
direccion varchar(30),
usuario varchar(20),
passwd varchar(20),
rol int,
disponible bit default 1,
FOREIGN KEY (rol) REFERENCES Rol(idRol)
);

create table Comprador(
idComprador int primary key,
idr int,
userID varchar(10),
FOREIGN KEY (idr) REFERENCES Rol(idRol),
FOREIGN KEY (userID) REFERENCES Usuario(cedula)
);

create table Vendedor(
idVendedor int primary key,
rateProm decimal(5,2),
idr int,
userID varchar(10),
FOREIGN KEY (idr) REFERENCES Rol(idRol),
FOREIGN KEY (userID) REFERENCES Usuario(cedula)
);

create table Administrador(
idAdmi int primary key,
idr int,
userID varchar(10),
FOREIGN KEY (idr) REFERENCES Rol(idRol),
FOREIGN KEY (userID) REFERENCES Usuario(cedula)
);

create table Tarjeta(
idTarjeta varchar(16) primary key,
fechaValida date,
nombreDueno varchar(30),
banco varchar(20)
);

create table Pago(
idPago int primary key,
nombre varchar(10)
);

create table PagoEfectivo(
idPE int primary key,
idp int,
FOREIGN KEY (idp) REFERENCES Pago(idPago) 
);

create table PagoApp(
idPA int primary key,
saldo decimal(5,2),
tarjeta varchar(16),
idp int,
FOREIGN KEY (idp) REFERENCES Pago(idPago),
FOREIGN KEY (tarjeta) REFERENCES Tarjeta(idTarjeta)
);

create table Pedido(
idPedido int primary key,
estado varchar(10),
fechaEntrega date,
costoTotal decimal(5,2),
compr int,
vend int,
FOREIGN KEY (compr) REFERENCES Comprador(idComprador),
FOREIGN KEY (vend) REFERENCES Vendedor(idVendedor)
);

create table Venta(
idVenta int primary key,
estado varchar(10),
lugarEntrega varchar(20),
pedid int,
vend int,
formaPago int,
FOREIGN KEY (pedid) REFERENCES Pedido(idPedido),
FOREIGN KEY (vend) REFERENCES Vendedor(idVendedor),
FOREIGN KEY (formaPago) REFERENCES Pago(idPago)
);

create table Articulo(
idArticulo int primary key,
nombre varchar(20),
categoria varchar(20),
tiempoMaxima date,
precio decimal(5,2),
vecesBuscadas int,
rateProm decimal(5,2),
disponible bit default 1
);

create table Vendedor_articulo(
vend int,
art int,
stock int,
FOREIGN KEY (vend) REFERENCES Vendedor(idVendedor),
FOREIGN KEY (art) REFERENCES Articulo(idArticulo)
);

create table Pedido_articulo(
pedid int,
art int,
cantidad int,
FOREIGN KEY (pedid) REFERENCES Pedido(idPedido),
FOREIGN KEY (art) REFERENCES Articulo(idArticulo)
);

create table Calificacion(
idC int primary key,
cantidad int
);

create table Calificacion_Vendedor(
vend int,
rate int,
FOREIGN KEY (vend) REFERENCES Vendedor(idVendedor),
FOREIGN KEY (rate) REFERENCES Calificacion(idC)
);

create table Calificacion_Articulo(
art int,
rate int,
FOREIGN KEY (art) REFERENCES Articulo(idArticulo),
FOREIGN KEY (rate) REFERENCES Calificacion(idC)
);
