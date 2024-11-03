package uniandes.edu.co.proyecto.servicios;

import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.repositorio.RecepcionRepository;
import uniandes.edu.co.proyecto.repositorio.RecepcionRepository.respuestaConsultaIngresoProductoBodega_SERIALIZABLE;

@Service
public class RecepcionService {

    private RecepcionRepository recepcionRepository;
    
    public RecepcionService(RecepcionRepository recepcionRepository)
    {
        this.recepcionRepository=recepcionRepository;
    } 

   @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
   public Collection<respuestaConsultaIngresoProductoBodega_SERIALIZABLE> consultaIngresoProductoBodega_SERIALIZABLE(int sucursal_id, int bodega_id) throws InterruptedException {
       Collection<respuestaConsultaIngresoProductoBodega_SERIALIZABLE> respuestaConsultaIgreso = recepcionRepository.consultaIngresoProductoBodega_SERIALIZABLE(sucursal_id,bodega_id); 
       System.out.println(respuestaConsultaIgreso);
       Thread.sleep(30000);
       respuestaConsultaIgreso = recepcionRepository.consultaIngresoProductoBodega_SERIALIZABLE(sucursal_id,bodega_id);
       return respuestaConsultaIgreso;
   }
    
}
