CREATE TABLE productos (
                           producto_id int PRIMARY KEY,
                           nombre varchar(50) NOT NULL,
                           descripcion text,
                           precio varchar(8) NOT NULL,
                           stock int NOT NULL,
                           fecha_creacion date
);
