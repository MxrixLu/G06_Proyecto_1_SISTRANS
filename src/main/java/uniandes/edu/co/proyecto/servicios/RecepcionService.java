package uniandes.edu.co.proyecto.servicios;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.repositorio.RecepcionRepository;
import uniandes.edu.co.proyecto.repositorio.RecepcionRepository.respuestaConsultaIngresoProductoBodega_READ_COMMITTED;
import uniandes.edu.co.proyecto.repositorio.RecepcionRepository.respuestaConsultaIngresoProductoBodega_SERIALIZABLE;

@Service
public class RecepcionService {

    private RecepcionRepository recepcionRepository;
    
    public RecepcionService(RecepcionRepository recepcionRepository)
    {
        this.recepcionRepository=recepcionRepository;
    } 

   @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
   public Collection<respuestaConsultaIngresoProductoBodega_SERIALIZABLE> consultaIngresoProductoBodega_SERIALIZABLE(int sucursal_id, int bodega_id) throws InterruptedException {
       Collection<respuestaConsultaIngresoProductoBodega_SERIALIZABLE> respuestaConsultaIgreso = recepcionRepository.consultaIngresoProductoBodega_SERIALIZABLE(sucursal_id,bodega_id); 
       System.out.println(respuestaConsultaIgreso);
       Thread.sleep(30000);
       respuestaConsultaIgreso = recepcionRepository.consultaIngresoProductoBodega_SERIALIZABLE(sucursal_id,bodega_id);
       return respuestaConsultaIgreso;
   }

   @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Collection<respuestaConsultaIngresoProductoBodega_READ_COMMITTED> consultaIngresoProductoBodega_READ_COMMITTED(int sucursal_id, int bodega_id) throws InterruptedException {
        Collection<respuestaConsultaIngresoProductoBodega_READ_COMMITTED> respuestaConsultaIngreso = recepcionRepository.consultaIngresoProductoBodega_READ_COMMITTED(sucursal_id, bodega_id);
        System.out.println(respuestaConsultaIngreso);
        Thread.sleep(30000);
        respuestaConsultaIngreso = recepcionRepository.consultaIngresoProductoBodega_READ_COMMITTED(sucursal_id, bodega_id);
        return respuestaConsultaIngreso;
    }
    
}