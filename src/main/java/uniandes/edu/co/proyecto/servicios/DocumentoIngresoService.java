package uniandes.edu.co.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.DocumentoIngreso;
import uniandes.edu.co.proyecto.repositorio.DocumentoIngresoRepository;

@Service
public class DocumentoIngresoService {

    @Autowired
    private DocumentoIngresoRepository documentoIngresoRepository;

    public List<DocumentoIngreso> getDocumentosIngreso(Long sucursalId, Long bodegaId) {
        return documentoIngresoRepository.findDocumentosIngreso(sucursalId, bodegaId);
    }
    
}