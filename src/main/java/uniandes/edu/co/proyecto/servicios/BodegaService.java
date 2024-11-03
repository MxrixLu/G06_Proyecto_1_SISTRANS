package uniandes.edu.co.proyecto.servicios;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.InfoRecepcion;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.Recepcion;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.InfoRecepcionRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoBodegaRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoOrdenRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.repositorio.RecepcionRepository;

@Service
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
    private ProductoBodegaRepository productoBodegaRepository;

    public BodegaService(ProductoRepository productoRepository, OrdenCompraRepository ordenCompraRepository, BodegaRepository bodegaRepository, RecepcionRepository recepcionRepository, ProductoOrdenRepository pOrdenRepository, InfoRecepcionRepository infoRecepcionRepository, ProductoBodegaRepository productoBodegaRepository) {
        this.productoRepository = productoRepository;
        this.ordenCompraRepository = ordenCompraRepository;
        this.bodegaRepository = bodegaRepository;
        this.recepcionRepository = recepcionRepository;
        this.pOrdenRepository = pOrdenRepository;
        this.infoRecepcionRepository = infoRecepcionRepository;
        this.productoBodegaRepository = productoBodegaRepository;
    }

    @Transactional
    public void registroProductoBodega(int ordenCompraId, int bodega_id) {
        OrdenCompra ordenCompra = ordenCompraRepository.darOrdenCompra(ordenCompraId); 
        System.out.println("Se realizo orden darOrdenCompra");
        if (ordenCompra == null) {
            throw new RuntimeException("La orden de compra no existe.");
        }
       

        Bodega bodega = bodegaRepository.darBodega(bodega_id);
        System.out.println("Se realizo darBodega");

        if (bodega == null) {
            throw new RuntimeException("La bodega no existe.");
        }

        // Obtener fecha actual
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(fechaActual);

        // Obtener los productos de la orden de compra
        Collection<Integer> productos = pOrdenRepository.darProductosPorOrden(ordenCompraId);
        System.out.println("Se realizo darProductosPorOrden");
        System.out.println("oden: " + ordenCompraId);
        System.out.println("Productos: " + productos);

        for (int productoId : productos) {
            System.out.println("Producto: " + productoId);
            Producto producto = productoRepository.darProducto(productoId);
            System.out.println("Se realizo orden darProducto");

            if (producto == null) {
                throw new RuntimeException("El producto con ID " + productoId + " no existe.");
            }

            Recepcion recepcion = recepcionRepository.darRecepcionHoy();
            System.out.println("Se realizo orden darRecepcionHoy");

            if (recepcion == null) {
                throw new RuntimeException("La recepción para el producto con ID " + productoId + " no existe en la fecha dada.");
            }

            InfoRecepcion infoRecepcion = infoRecepcionRepository.darInfoRecepcionPorId(recepcion.getId(), productoId);
            System.out.println("Se realizo orden infoRecepcion");

            if (infoRecepcion == null) {
                throw new RuntimeException("La información de recepción para el producto con ID " + productoId + " no existe.");
            }

            // Actualiza la cantidad y el costo promedio del producto en la bodega
            productoBodegaRepository.agregarNuevoProducto(productoId, bodega_id, infoRecepcion.getCantidadRecibida(), ordenCompra.getPrecioAcordado());
            System.out.println("Se realizo orden agregarNuevoProducto");

        }

        // Cambia el estado de la orden de compra a "ENTREGADA" y guarda los cambios
        ordenCompra.setEstado("ENTREGADA");
    }

}
