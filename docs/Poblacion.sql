
-- Ciudades
INSERT INTO ciudades (codigo, nombre) VALUES (1001, 'Bogotá');
INSERT INTO ciudades (codigo, nombre) VALUES (1002, 'Medellín');
INSERT INTO ciudades (codigo, nombre) VALUES (1003, 'Cali');
INSERT INTO ciudades (codigo, nombre) VALUES (1004, 'Barranquilla');
INSERT INTO ciudades (codigo, nombre) VALUES (1005, 'Cartagena');
INSERT INTO ciudades (codigo, nombre) VALUES (1006, 'Bucaramanga');
INSERT INTO ciudades (codigo, nombre) VALUES (1007, 'Pereira');
INSERT INTO ciudades (codigo, nombre) VALUES (1008, 'Manizales');
INSERT INTO ciudades (codigo, nombre) VALUES (1009, 'Ibagué');
INSERT INTO ciudades (codigo, nombre) VALUES (1010, 'Santa Marta');

-- Sucursales
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Centro', '3200000001', 'Carrera 7 #34-15', 500, 1);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Norte', '3100000002', 'Avenida 19 #153-30', 700, 2);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Sur', '3110000003', 'Calle 50 #12-90', 600, 3);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Centro Histórico', '3120000004', 'Carrera 12 #30-60', 550, 4);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Caribe', '3130000005', 'Calle 21 #45-10', 500, 5);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Oriental', '3140000006', 'Avenida 4 #10-50', 450, 6);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Cafetera', '3150000007', 'Carrera 5 #15-20', 600, 7);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Montañosa', '3160000008', 'Calle 18 #12-70', 400, 8);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Musical', '3170000009', 'Calle 35 #23-15', 500, 9);
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) VALUES ('Sucursal Marítima', '3180000010', 'Calle 12 #45-67', 450, 10);

-- Proveedores
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900123-1', 'Carrera 8 #10-11', 'Carlos Gómez', '3100000011');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900124-2', 'Calle 13 #20-30', 'Laura Pérez', '3110000012');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900125-3', 'Avenida 30 #40-50', 'Juan Rodríguez', '3120000013');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900126-4', 'Carrera 20 #30-15', 'Ana Torres', '3130000014');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900127-5', 'Calle 10 #5-55', 'Mónica Rojas', '3140000015');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900128-6', 'Carrera 15 #23-45', 'Pedro Ramírez', '3150000016');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900129-7', 'Avenida 7 #89-22', 'Isabel Ruiz', '3160000017');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900130-8', 'Calle 8 #12-44', 'Sergio Díaz', '3170000018');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900131-9', 'Carrera 9 #13-33', 'Lucía Gutiérrez', '3180000019');
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES ('800900132-0', 'Avenida 6 #11-88', 'Mario Mendoza', '3190000020');

-- Categorías
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (1, 'Lácteos', 'Productos derivados de la leche', 'Refrigeración a 4°C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (2, 'Carnes', 'Productos cárnicos', 'Congelación a -18°C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (3, 'Bebidas', 'Bebidas no alcohólicas', 'Almacenar en lugar seco');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (4, 'Aseo', 'Productos de aseo personal', 'Lugar fresco y seco');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (5, 'Granos', 'Legumbres y granos secos', 'Almacenar en lugar seco y ventilado');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (6, 'Verduras', 'Verduras frescas', 'Refrigeración a 5°C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (7, 'Frutas', 'Frutas frescas', 'Refrigeración a 4°C');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (8, 'Panadería', 'Productos de panadería', 'Lugar seco y ventilado');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (9, 'Bebidas Alcohólicas', 'Bebidas con contenido de alcohol', 'Almacenar en lugar fresco');
INSERT INTO categorias (codigo, nombre, descripcion, caracteristicasAlmacenamiento) VALUES (10, 'Electrónica', 'Electrodomésticos y gadgets', 'Almacenar en lugar seco');

-- Bodegas
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Central', 1000, 1);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Norte', 800, 2);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Sur', 700, 3);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Caribe', 600, 4);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Oriente', 750, 5);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Occidente', 950, 6);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Cafetera', 500, 7);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Marítima', 450, 8);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Llanera', 400, 9);
INSERT INTO bodegas (nombre, tamano, id_sucursal) VALUES ('Bodega Andina', 550, 10);

-- Clientes
INSERT INTO clientes (cedula, nombre) VALUES (1012345678, 'Juan Pérez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345679, 'Ana Gómez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345680, 'Luis Rodríguez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345681, 'Carlos Torres');
INSERT INTO clientes (cedula, nombre) VALUES (1012345682, 'Marta Rojas');
INSERT INTO clientes (cedula, nombre) VALUES (1012345683, 'Sofía Díaz');
INSERT INTO clientes (cedula, nombre) VALUES (1012345684, 'Laura Ramírez');
INSERT INTO clientes (cedula, nombre) VALUES (1012345685, 'Pedro González');
INSERT INTO clientes (cedula, nombre) VALUES (1012345686, 'Sergio Mendoza');
INSERT INTO clientes (cedula, nombre) VALUES (1012345687, 'Lucía Gutiérrez');

-- Productos
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567890', 'Leche Entera', 1200, 1500, 'Litro', 1, 1, 1.0, 1.1, TO_DATE('2024-12-01', 'YYYY-MM-DD'), 1);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567891', 'Carne de Res', 8000, 10000, 'Kilo', 1, 2, 0.8, 1.0, TO_DATE('2024-10-15', 'YYYY-MM-DD'), 2);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567892', 'Jugo de Naranja', 2000, 2500, 'Litro', 1, 1, 1.1, 1.2, TO_DATE('2024-11-01', 'YYYY-MM-DD'), 3);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567893', 'Shampoo', 3000, 3500, 'Botella', 1, 1, 0.7, 0.8, NULL, 4);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567894', 'Arroz Blanco', 2000, 2500, 'Kilo', 1, 2, 1.0, 1.1, NULL, 5);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567895', 'Tomate', 1000, 1200, 'Kilo', 1, 2, 0.9, 0.95, TO_DATE('2024-10-05', 'YYYY-MM-DD'), 6);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567896', 'Manzana Roja', 1500, 1800, 'Kilo', 1, 2, 1.1, 1.2, TO_DATE('2024-10-08', 'YYYY-MM-DD'), 7);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567897', 'Pan Tajado', 1500, 1800, 'Paquete', 1, 2, 0.6, 0.65, TO_DATE('2024-10-10', 'YYYY-MM-DD'), 8);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567898', 'Cerveza', 2500, 3000, 'Botella', 1, 1, 1.3, 1.35, NULL, 9);
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria)
VALUES ('7701234567899', 'Televisor LED', 800000, 950000, 'Unidad', 1, 1, 30.0, 15.0, NULL, 10);

-- InfoRecepcion
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (1, 1, 100, 120000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (1, 2, 50, 400000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (2, 3, 200, 400000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (2, 4, 80, 240000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (3, 5, 300, 600000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (3, 6, 150, 150000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (4, 7, 100, 150000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (4, 8, 200, 300000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (5, 9, 250, 625000);
INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (5, 10, 10, 8000000);

-- Recepciones
INSERT INTO recepciones (fechaRecepcion, id_proveedor, id_bodega) VALUES (TO_DATE('2024-09-15', 'YYYY-MM-DD'), 1, 1);
INSERT INTO recepciones (fechaRecepcion, id_proveedor, id_bodega) VALUES (TO_DATE('2024-09-16', 'YYYY-MM-DD'), 2, 2);
INSERT INTO recepciones (fechaRecepcion, id_proveedor, id_bodega) VALUES (TO_DATE('2024-09-17', 'YYYY-MM-DD'), 3, 3);
INSERT INTO recepciones (fechaRecepcion, id_proveedor, id_bodega) VALUES (TO_DATE('2024-09-18', 'YYYY-MM-DD'), 4, 4);
INSERT INTO recepciones (fechaRecepcion, id_proveedor, id_bodega) VALUES (TO_DATE('2024-09-19', 'YYYY-MM-DD'), 5, 5);

-- Niveles de Reorden
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (50, 1, 1);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (30, 2, 2);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (20, 3, 3);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (10, 4, 4);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (40, 5, 5);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (60, 6, 6);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (70, 7, 7);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (80, 8, 8);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (90, 9, 9);
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) VALUES (100, 10, 10);

-- Ordenes de Compra
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precioAcordado, estado, fechaCreacion, id_sucursal, id_proveedor)
VALUES (TO_DATE('2024-10-01', 'YYYY-MM-DD'), 120000, 'Pendiente', TO_DATE('2024-09-01', 'YYYY-MM-DD'), 1, 1);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precioAcordado, estado, fechaCreacion, id_sucursal, id_proveedor)
VALUES (TO_DATE('2024-10-02', 'YYYY-MM-DD'), 400000, 'Pendiente', TO_DATE('2024-09-02', 'YYYY-MM-DD'), 2, 2);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precioAcordado, estado, fechaCreacion, id_sucursal, id_proveedor)
VALUES (TO_DATE('2024-10-03', 'YYYY-MM-DD'), 200000, 'Pendiente', TO_DATE('2024-09-03', 'YYYY-MM-DD'), 3, 3);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precioAcordado, estado, fechaCreacion, id_sucursal, id_proveedor)
VALUES (TO_DATE('2024-10-04', 'YYYY-MM-DD'), 800000, 'Pendiente', TO_DATE('2024-09-04', 'YYYY-MM-DD'), 4, 4);
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precioAcordado, estado, fechaCreacion, id_sucursal, id_proveedor)
VALUES (TO_DATE('2024-10-05', 'YYYY-MM-DD'), 625000, 'Pendiente', TO_DATE('2024-09-05', 'YYYY-MM-DD'), 5, 5);

-- ProductoBodega
INSERT INTO producto_bodega (id_producto, id_bodega, cantidadExistente, costoPromedio, capacidadBodega)
VALUES (1, 1, 100, 1200, 500);
INSERT INTO producto_bodega (id_producto, id_bodega, cantidadExistente, costoPromedio, capacidadBodega)
VALUES (2, 2, 50, 8000, 300);
INSERT INTO producto_bodega (id_producto, id_bodega, cantidadExistente, costoPromedio, capacidadBodega)
VALUES (3, 3, 200, 2000, 400);
INSERT INTO producto_bodega (id_producto, id_bodega, cantidadExistente, costoPromedio, capacidadBodega)
VALUES (4, 4, 80, 3000, 250);
INSERT INTO producto_bodega (id_producto, id_bodega, cantidadExistente, costoPromedio, capacidadBodega)
VALUES (5, 5, 300, 2000, 600);

-- ProductoOrden
INSERT INTO producto_orden (id_producto, id_ordenCompra, precioAcordado, cantidadSolicitada) VALUES (1, 1, 1500, 100);
INSERT INTO producto_orden (id_producto, id_ordenCompra, precioAcordado, cantidadSolicitada) VALUES (2, 2, 10000, 50);
INSERT INTO producto_orden (id_producto, id_ordenCompra, precioAcordado, cantidadSolicitada) VALUES (3, 3, 2500, 200);
INSERT INTO producto_orden (id_producto, id_ordenCompra, precioAcordado, cantidadSolicitada) VALUES (4, 4, 3500, 80);
INSERT INTO producto_orden (id_producto, id_ordenCompra, precioAcordado, cantidadSolicitada) VALUES (5, 5, 2500, 300);

-- Ventas
INSERT INTO ventas (fecha, cantidad, precioUnitario, cedula, id_cliente, id_producto) VALUES (TO_DATE('2024-09-10', 'YYYY-MM-DD'), 10, 1500, 1012345678, 1, 1);
INSERT INTO ventas (fecha, cantidad, precioUnitario, cedula, id_cliente, id_producto) VALUES (TO_DATE('2024-09-11', 'YYYY-MM-DD'), 5, 10000, 1012345679, 2, 2);
INSERT INTO ventas (fecha, cantidad, precioUnitario, cedula, id_cliente, id_producto) VALUES (TO_DATE('2024-09-12', 'YYYY-MM-DD'), 20, 2500, 1012345680, 3, 3);
INSERT INTO ventas (fecha, cantidad, precioUnitario, cedula, id_cliente, id_producto) VALUES (TO_DATE('2024-09-13', 'YYYY-MM-DD'), 8, 3500, 1012345681, 4, 4);
INSERT INTO ventas (fecha, cantidad, precioUnitario, cedula, id_cliente, id_producto) VALUES (TO_DATE('2024-09-14', 'YYYY-MM-DD'), 30, 2500, 1012345682, 5, 5);

