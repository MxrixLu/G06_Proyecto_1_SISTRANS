package uniandes.edu.co.proyecto.servicios;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.InfoRecepcion;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.Recepcion;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.InfoRecepcionRepository;
import uniandes.edu.co.proyecto.repositorio.NivelReOrdenRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoBodegaRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoOrdenRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.repositorio.RecepcionRepository;

public class BodegaService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired 
    private RecepcionRepository recepcionRepository;

    @Autowired
    private ProductoOrdenRepository pOrdenRepository;

    @Autowired
    private InfoRecepcionRepository infoRecepcionRepository;

    @Autowired 
    ProductoBodegaRepository productoBodegaRepository;

    @Autowired
    NivelReOrdenRepository nivelReordenRepository;

    @Transactional
    public void registroProductoBodega(int ordenCompraId, int bodegaId) {
        OrdenCompra ordenCompra = ordenCompraRepository.darOrdenCompra(ordenCompraId); 
        if (ordenCompra == null) {
            throw new RuntimeException("La orden de compra no existe.");
        }
        if (!"VIGENTE".equals(ordenCompra.getEstado())) {
            throw new RuntimeException("La orden de compra no está vigente.");
        }

        Bodega bodega = bodegaRepository.darBodega(bodegaId);
        if (bodega == null) {
            throw new RuntimeException("La bodega no existe.");
        }

        // Obtener fecha actual
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(fechaActual);

        // Obtener los productos de la orden de compra
        Collection<Integer> productos = pOrdenRepository.darProductosPorOrden(ordenCompraId);
        for (int productoId : productos) {
            Producto producto = productoRepository.darProducto(productoId);
            if (producto == null) {
                throw new RuntimeException("El producto con ID " + productoId + " no existe.");
            }

            Recepcion recepcion = recepcionRepository.darRecepcionHoy(productoId, bodegaId, fechaString);
            if (recepcion == null) {
                throw new RuntimeException("La recepción para el producto con ID " + productoId + " no existe en la fecha dada.");
            }

            InfoRecepcion infoRecepcion = infoRecepcionRepository.darInfoRecepcionPorId(recepcion.getId(), productoId);
            if (infoRecepcion == null) {
                throw new RuntimeException("La información de recepción para el producto con ID " + productoId + " no existe.");
            }

            // Actualiza la cantidad y el costo promedio del producto en la bodega
            productoBodegaRepository.agregarNuevoProducto(productoId, bodegaId, infoRecepcion.getCantidadRecibida(), ordenCompra.getPrecioAcordado());
        }

        // Cambia el estado de la orden de compra a "ENTREGADA" y guarda los cambios
        ordenCompra.setEstado("ENTREGADA");
        ordenCompraRepository.save(ordenCompra); 
    }

}
