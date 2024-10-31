-- Pruebas de Unicidad de Tuplas

-- Insertar un proveedor con clave primaria �nica
INSERT INTO proveedores (NIT, direccion, nombre_personac, telefono_personac) 
VALUES ('123456789', 'Av. Principal 100', 'Juan P�rez', '555-1234');

-- Intentar insertar un proveedor con la misma PK (debe fallar)
INSERT INTO proveedores (id, NIT, direccion, nombre_personac, telefono_personac) 
VALUES (1, '987654321', 'Av. Secundaria 200', 'Maria Garc�a', '555-5678');

-- Insertar un producto con clave primaria �nica
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id) 
VALUES ('f0f0f0f0f0', 'Papas Fritas Les frites', 4200, 9000, 'Paquet�n', 1000, 1, 150, 15, TO_DATE('2027-12-12', 'YYYY-MM-DD'), 1);

-- Intentar insertar un producto con la misma PK (debe fallar)
INSERT INTO productos (id, codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id) 
VALUES (1, 'a0a0a0a0a0', 'Cereal Chocoflakes', 3000, 5000, 'Caja', 500, 1, 100, 10, TO_DATE('2026-12-12', 'YYYY-MM-DD'), 2);

-- Pruebas de Integridad Referencial (FK)

-- Insertar una ciudad y una sucursal correctamente asociada
INSERT INTO ciudades (codigo, nombre) VALUES (101, 'Bogot�');
INSERT INTO sucursales (nombre, telefono, direccion, tamano, ciudad_id) 
VALUES ('Sucursal Central', '555-1234', 'Calle Principal 100', 500, 1);

-- Insertar una bodega correctamente asociada a la sucursal
INSERT INTO bodegas (nombre, tamano, sucursal_id) 
VALUES ('Bodega Principal', 200, 1);

-- Intentar insertar una bodega asociada a una sucursal inexistente (debe fallar)
INSERT INTO bodegas (nombre, tamano, sucursal_id) 
VALUES ('Bodega Secundaria', 150, 999);

-- Pruebas de Restricciones de Chequeo

-- Intentar insertar una bodega con un tama�o menor que cero (debe fallar)
INSERT INTO bodegas (nombre, tamano, sucursal_id) 
VALUES ('Bodega Peque�a', -50, 1);

-- Intentar insertar un producto con precio de venta negativo (debe fallar)
INSERT INTO productos (codigo_barras, nombre, costo_bodega, precio_venta, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, categoria_id) 
VALUES ('b0b0b0b0b0', 'Producto Defectuoso', 5000, -1000, 'Paquete', 100, 1, 100, 50, TO_DATE('2025-12-12', 'YYYY-MM-DD'), 1);

-- Pruebas Funcionales para la Recepci�n de Productos

-- Insertar recepci�n de productos en la bodega con un costo de 9000 y 10 unidades
INSERT INTO recepciones (fecha_recepcion, proveedor_id, bodega_id) 
VALUES (TO_DATE('2023-01-01', 'YYYY-MM-DD'), 1, 1);

INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) 
VALUES (1, 1, 10, 9000);

-- Insertar una nueva recepci�n de productos con un nuevo costo de 9500 y 10 unidades
INSERT INTO recepciones (fecha_recepcion, proveedor_id, bodega_id) 
VALUES (TO_DATE('2023-02-01', 'YYYY-MM-DD'), 1, 1);

INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) 
VALUES (2, 1, 10, 9500);

-- Pruebas de Niveles de Reorden

-- Establecer el nivel de reorden para un producto en una sucursal
INSERT INTO niveles_reorden (nivel_minimo, sucursal_id, producto_id) 
VALUES (50, 1, 1);

-- Simular una venta que reduce el inventario por debajo del nivel de reorden
UPDATE producto_bodega 
SET cantidad_existente = 40 
WHERE bodega_id = 1 AND producto_id = 1;

-- Generar una orden de compra cuando el inventario cae por debajo del nivel de reorden
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precio_acordado, estado, fechaCreacion, sucursal_id, proveedor_id) 
VALUES (TO_DATE('2023-12-31', 'YYYY-MM-DD'), 8000, 'VIGENTE', TO_DATE('2023-10-01', 'YYYY-MM-DD'), 1, 1);
