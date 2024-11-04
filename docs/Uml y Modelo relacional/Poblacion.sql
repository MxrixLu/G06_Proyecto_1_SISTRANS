
-- Ciudades
INSERT INTO ciudades (codigo, nombre) VALUES (1001, 'Bogot�');
INSERT INTO ciudades (codigo, nombre) VALUES (1002, 'Medell�n');
INSERT INTO ciudades (codigo, nombre) VALUES (1003, 'Cali');
INSERT INTO ciudades (codigo, nombre) VALUES (1004, 'Barranquilla');
INSERT INTO ciudades (codigo, nombre) VALUES (1005, 'Cartagena');
INSERT INTO ciudades (codigo, nombre) VALUES (1006, 'Bucaramanga');
INSERT INTO ciudades (codigo, nombre) VALUES (1007, 'Pereira');
INSERT INTO ciudades (codigo, nombre) VALUES (1008, 'Manizales');
INSERT INTO ciudades (codigo, nombre) VALUES (1009, 'Ibagu�');
INSERT INTO ciudades (codigo, nombre) VALUES (1010, 'Santa Marta');

-- Sucursales
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Centro', '3200000001', 'Carrera 7 #34-15', 500, 1);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Norte', '3100000002', 'Avenida 19 #153-30', 700, 2);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Sur', '3110000003', 'Calle 50 #12-90', 600, 3);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Centro Hist�rico', '3120000004', 'Carrera 12 #30-60', 550, 4);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Caribe', '3130000005', 'Calle 21 #45-10', 500, 5);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Oriental', '3140000006', 'Avenida 4 #10-50', 450, 6);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Cafetera', '3150000007', 'Carrera 5 #15-20', 600, 7);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Monta�osa', '3160000008', 'Calle 18 #12-70', 400, 8);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Musical', '3170000009', 'Calle 35 #23-15', 500, 9);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) VALUES ('Sucursal Mar�tima', '3180000010', 'Calle 12 #45-67', 450, 10);

-- Proveedores
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900123-1', 'Carrera 8 #10-11', 'Carlos G�mez', '3100000011');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900124-2', 'Calle 13 #20-30', 'Laura P�rez', '3110000012');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900125-3', 'Avenida 30 #40-50', 'Juan Rodr�guez', '3120000013');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900126-4', 'Carrera 20 #30-15', 'Ana Torres', '3130000014');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900127-5', 'Calle 10 #5-55', 'M�nica Rojas', '3140000015');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900128-6', 'Carrera 15 #23-45', 'Pedro Ram�rez', '3150000016');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900129-7', 'Avenida 7 #89-22', 'Isabel Ruiz', '3160000017');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900130-8', 'Calle 8 #12-44', 'Sergio D�az', '3170000018');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900131-9', 'Carrera 9 #13-33', 'Luc�a Guti�rrez', '3180000019');
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) VALUES ('800900132-0', 'Avenida 6 #11-88', 'Mario Mendoza', '3190000020');

-- Categor�as
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (1, 'L�cteos', 'Productos derivados de la leche', 'Refrigeraci�n a 4�C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (2, 'Carnes', 'Productos c�rnicos', 'Congelaci�n a -18�C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (3, 'Bebidas', 'Bebidas no alcoh�licas', 'Almacenar en lugar seco');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (4, 'Aseo', 'Productos de aseo personal', 'Lugar fresco y seco');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (5, 'Granos', 'Legumbres y granos secos', 'Almacenar en lugar seco y ventilado');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (6, 'Verduras', 'Verduras frescas', 'Refrigeraci�n a 5�C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (7, 'Frutas', 'Frutas frescas', 'Refrigeraci�n a 4�C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (8, 'Panader�a', 'Productos de panader�a', 'Lugar seco y ventilado');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (9, 'Bebidas Alcoh�licas', 'Bebidas con contenido de alcohol', 'Almacenar en lugar fresco');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (10, 'Electr�nica', 'Electrodom�sticos y gadgets', 'Almacenar en lugar seco');

-- Bodegas
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Central', 1000, 1);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Norte', 800, 2);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Sur', 700, 3);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Caribe', 600, 4);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Oriente', 750, 5);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Occidente', 950, 6);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Cafetera', 500, 7);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Mar�tima', 450, 8);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Llanera', 400, 9);
INSERT INTO bodegas (nombre, tamano, sucursal_id) VALUES ('Bodega Andina', 550, 10);

-- Clientes
INSERT INTO clientes (cedula, nombre) VALUES (1012345678, 'Juan P�rez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345679, 'Ana G�mez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345680, 'Luis Rodr�guez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345681, 'Carlos Torres');
INSERT INTO clientes (cedula, nombre) VALUES (1012345682, 'Marta Rojas');
INSERT INTO clientes (cedula, nombre) VALUES (1012345683, 'Sof�a D�az');
INSERT INTO clientes (cedula, nombre) VALUES (1012345684, 'Laura Ram�rez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345685, 'Pedro Gonz�lez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345686, 'Sergio Mendoza');
INSERT INTO clientes (cedula, nombre) VALUES (1012345687, 'Luc�a Guti�rrez');

-- Productos
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567890', 'Leche Entera', 1200, 1500, 'Litro', 1, 1, 1.0, 1.1, TO_DATE('2024-12-01', 'YYYY-MM-DD'), 1);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567891', 'Carne de Res', 8000, 10000, 'Kilo', 1, 2, 0.8, 1.0, TO_DATE('2024-10-15', 'YYYY-MM-DD'), 2);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567892', 'Jugo de Naranja', 2000, 2500, 'Litro', 1, 1, 1.1, 1.2, TO_DATE('2024-11-01', 'YYYY-MM-DD'), 3);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567893', 'Shampoo', 3000, 3500, 'Botella', 1, 1, 0.7, 0.8, NULL, 4);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567894', 'Arroz Blanco', 2000, 2500, 'Kilo', 1, 2, 1.0, 1.1, NULL, 5);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567895', 'Tomate', 1000, 1200, 'Kilo', 1, 2, 0.9, 0.95, TO_DATE('2024-10-05', 'YYYY-MM-DD'), 6);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567896', 'Manzana Roja', 1500, 1800, 'Kilo', 1, 2, 1.1, 1.2, TO_DATE('2024-10-08', 'YYYY-MM-DD'), 7);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567897', 'Pan Tajado', 1500, 1800, 'Paquete', 1, 2, 0.6, 0.65, TO_DATE('2024-10-10', 'YYYY-MM-DD'), 8);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567898', 'Cerveza', 2500, 3000, 'Botella', 1, 1, 1.3, 1.35, NULL, 9);
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id)
VALUES ('7701234567899', 'Televisor LED', 800000, 950000, 'Unidad', 1, 1, 30.0, 15.0, NULL, 10);

-- InfoRecepcion
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (1, 1, 100, 120000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (1, 2, 50, 400000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (2, 3, 200, 400000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (2, 4, 80, 240000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (3, 5, 300, 600000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (3, 6, 150, 150000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (4, 7, 100, 150000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (4, 8, 200, 300000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (5, 9, 250, 625000);
INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (5, 10, 10, 8000000);

-- Recepciones
INSERT INTO recepciones (fecha_recepcion, proveedor_id, bodega_id) VALUES (TO_DATE('2024-09-15', 'YYYY-MM-DD'), 1, 1);
INSERT INTO recepciones (fecha_recepcion, proveedor_id, bodega_id) VALUES (TO_DATE('2024-09-16', 'YYYY-MM-DD'), 2, 2);
INSERT INTO recepciones (fecha_recepcion, proveedor_id, bodega_id) VALUES (TO_DATE('2024-09-17', 'YYYY-MM-DD'), 3, 3);
INSERT INTO recepciones (fecha_recepcion, proveedor_id, bodega_id) VALUES (TO_DATE('2024-09-18', 'YYYY-MM-DD'), 4, 4);
INSERT INTO recepciones (fecha_recepcion, proveedor_id, bodega_id) VALUES (TO_DATE('2024-09-19', 'YYYY-MM-DD'), 5, 5);

-- Niveles de Reorden
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (50, 1, 1);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (30, 2, 2);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (20, 3, 3);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (10, 4, 4);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (40, 5, 5);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (60, 6, 6);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (70, 7, 7);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (80, 8, 8);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (90, 9, 9);
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) VALUES (100, 10, 10);

-- Ordenes de Compra
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precio_acordado, estado, fechaCreacion, sucursal_id, proveedor_id)
VALUES (TO_DATE('2024-10-01', 'YYYY-MM-DD'), 120000, 'Pendiente', TO_DATE('2024-09-01', 'YYYY-MM-DD'), 1, 1);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precio_acordado, estado, fechaCreacion, sucursal_id, proveedor_id)
VALUES (TO_DATE('2024-10-02', 'YYYY-MM-DD'), 400000, 'Pendiente', TO_DATE('2024-09-02', 'YYYY-MM-DD'), 2, 2);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precio_acordado, estado, fechaCreacion, sucursal_id, proveedor_id)
VALUES (TO_DATE('2024-10-03', 'YYYY-MM-DD'), 200000, 'Pendiente', TO_DATE('2024-09-03', 'YYYY-MM-DD'), 3, 3);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precio_acordado, estado, fechaCreacion, sucursal_id, proveedor_id)
VALUES (TO_DATE('2024-10-04', 'YYYY-MM-DD'), 800000, 'Pendiente', TO_DATE('2024-09-04', 'YYYY-MM-DD'), 4, 4);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precio_acordado, estado, fechaCreacion, sucursal_id, proveedor_id)
VALUES (TO_DATE('2024-10-05', 'YYYY-MM-DD'), 625000, 'Pendiente', TO_DATE('2024-09-05', 'YYYY-MM-DD'), 5, 5);

-- ProductoBodega
INSERT INTO producto_bodega (producto_id, bodega_id, cantidad_existente, costo_promedio, capacidad_bodega)
VALUES (1, 1, 100, 1200, 500);
INSERT INTO producto_bodega (producto_id, bodega_id, cantidad_existente, costo_promedio, capacidad_bodega)
VALUES (2, 2, 50, 8000, 300);
INSERT INTO producto_bodega (producto_id, bodega_id, cantidad_existente, costo_promedio, capacidad_bodega)
VALUES (3, 3, 200, 2000, 400);
INSERT INTO producto_bodega (producto_id, bodega_id, cantidad_existente, costo_promedio, capacidad_bodega)
VALUES (4, 4, 80, 3000, 250);
INSERT INTO producto_bodega (producto_id, bodega_id, cantidad_existente, costo_promedio, capacidad_bodega)
VALUES (5, 5, 300, 2000, 600);

-- ProductoOrden
INSERT INTO producto_orden (producto_id, orden_compra_id, precio_acordado, cantidad_solicitada) VALUES (1, 1, 1500, 100);
INSERT INTO producto_orden (producto_id, orden_compra_id, precio_acordado, cantidad_solicitada) VALUES (2, 2, 10000, 50);
INSERT INTO producto_orden (producto_id, orden_compra_id, precio_acordado, cantidad_solicitada) VALUES (3, 3, 2500, 200);
INSERT INTO producto_orden (producto_id, orden_compra_id, precio_acordado, cantidad_solicitada) VALUES (4, 4, 3500, 80);
INSERT INTO producto_orden (producto_id, orden_compra_id, precio_acordado, cantidad_solicitada) VALUES (5, 5, 2500, 300);

-- Ventas
INSERT INTO ventas (fecha, cantidad, precio_unitario, cedula, cliente_id, producto_id) VALUES (TO_DATE('2024-09-10', 'YYYY-MM-DD'), 10, 1500, 1012345678, 1, 1);
INSERT INTO ventas (fecha, cantidad, precio_unitario, cedula, cliente_id, producto_id) VALUES (TO_DATE('2024-09-11', 'YYYY-MM-DD'), 5, 10000, 1012345679, 2, 2);
INSERT INTO ventas (fecha, cantidad, precio_unitario, cedula, cliente_id, producto_id) VALUES (TO_DATE('2024-09-12', 'YYYY-MM-DD'), 20, 2500, 1012345680, 3, 3);
INSERT INTO ventas (fecha, cantidad, precio_unitario, cedula, cliente_id, producto_id) VALUES (TO_DATE('2024-09-13', 'YYYY-MM-DD'), 8, 3500, 1012345681, 4, 4);
INSERT INTO ventas (fecha, cantidad, precio_unitario, cedula, cliente_id, producto_id) VALUES (TO_DATE('2024-09-14', 'YYYY-MM-DD'), 30, 2500, 1012345682, 5, 5);

