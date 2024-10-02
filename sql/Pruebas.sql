-- Pruebas de Unicidad de Tuplas

-- Insertar un proveedor con clave primaria única
INSERT INTO proveedores (NIT, direccion, nombrePersonaC, telefonoPersonaC) 
VALUES ('123456789', 'Av. Principal 100', 'Juan Pérez', '555-1234');

-- Intentar insertar un proveedor con la misma PK (debe fallar)
INSERT INTO proveedores (id, NIT, direccion, nombrePersonaC, telefonoPersonaC) 
VALUES (1, '987654321', 'Av. Secundaria 200', 'Maria García', '555-5678');

-- Insertar un producto con clave primaria única
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria) 
VALUES ('f0f0f0f0f0', 'Papas Fritas Les frites', 4200, 9000, 'Paquetón', 1000, 1, 150, 15, TO_DATE('2027-12-12', 'YYYY-MM-DD'), 1);

-- Intentar insertar un producto con la misma PK (debe fallar)
INSERT INTO productos (id, codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria) 
VALUES (1, 'a0a0a0a0a0', 'Cereal Chocoflakes', 3000, 5000, 'Caja', 500, 1, 100, 10, TO_DATE('2026-12-12', 'YYYY-MM-DD'), 2);

-- Pruebas de Integridad Referencial (FK)

-- Insertar una ciudad y una sucursal correctamente asociada
INSERT INTO ciudades (codigo, nombre) VALUES (101, 'Bogotá');
INSERT INTO sucursales (nombre, telefono, direccion, tamano, id_ciudad) 
VALUES ('Sucursal Central', '555-1234', 'Calle Principal 100', 500, 1);

-- Insertar una bodega correctamente asociada a la sucursal
INSERT INTO bodegas (nombre, tamano, id_sucursal) 
VALUES ('Bodega Principal', 200, 1);

-- Intentar insertar una bodega asociada a una sucursal inexistente (debe fallar)
INSERT INTO bodegas (nombre, tamano, id_sucursal) 
VALUES ('Bodega Secundaria', 150, 999);

-- Pruebas de Restricciones de Chequeo

-- Intentar insertar una bodega con un tamaño menor que cero (debe fallar)
INSERT INTO bodegas (nombre, tamano, id_sucursal) 
VALUES ('Bodega Pequeña', -50, 1);

-- Intentar insertar un producto con precio de venta negativo (debe fallar)
INSERT INTO productos (codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria) 
VALUES ('b0b0b0b0b0', 'Producto Defectuoso', 5000, -1000, 'Paquete', 100, 1, 100, 50, TO_DATE('2025-12-12', 'YYYY-MM-DD'), 1);

-- Pruebas Funcionales para la Recepción de Productos

-- Insertar recepción de productos en la bodega con un costo de 9000 y 10 unidades
INSERT INTO recepciones (fechaRecepcion, id_proveedor, id_bodega) 
VALUES (TO_DATE('2023-01-01', 'YYYY-MM-DD'), 1, 1);

INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) 
VALUES (1, 1, 10, 9000);

-- Insertar una nueva recepción de productos con un nuevo costo de 9500 y 10 unidades
INSERT INTO recepciones (fechaRecepcion, id_proveedor, id_bodega) 
VALUES (TO_DATE('2023-02-01', 'YYYY-MM-DD'), 1, 1);

INSERT INTO info_recepcion (id_recepcion, id_producto, cantidadRecibida, costoRecibido) 
VALUES (2, 1, 10, 9500);

-- Pruebas de Niveles de Reorden

-- Establecer el nivel de reorden para un producto en una sucursal
INSERT INTO niveles_reorden (nivelMinimo, id_sucursal, id_producto) 
VALUES (50, 1, 1);

-- Simular una venta que reduce el inventario por debajo del nivel de reorden
UPDATE producto_bodega 
SET cantidadExistente = 40 
WHERE id_bodega = 1 AND id_producto = 1;

-- Generar una orden de compra cuando el inventario cae por debajo del nivel de reorden
INSERT INTO ordenes_compra (fechaEsperadaEntrega, precioAcordado, estado, fechaCreacion, id_sucursal, id_proveedor) 
VALUES (TO_DATE('2023-12-31', 'YYYY-MM-DD'), 8000, 'VIGENTE', TO_DATE('2023-10-01', 'YYYY-MM-DD'), 1, 1);
