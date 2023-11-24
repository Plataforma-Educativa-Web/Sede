package pe.cibertec.ProyectoFinal.ApiSede.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiSede.dao.SedeRepository;
import pe.cibertec.ProyectoFinal.ApiSede.entity.Sede;
import pe.cibertec.ProyectoFinal.ApiSede.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiSede.service.SedeService;

@Service

public class SedeServiceImpl implements SedeService {

    @Autowired

    private SedeRepository sedeRepository;

    @Override
    public List<Sede> findAll() {

        return (List<Sede>) sedeRepository.findAll();

    }

    @Override
    public Sede buscarPorId(Long id) {

        return sedeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sede no encontrada por el id" + id.toString()));

    }

    @Override
    public Sede findByDistrito(String distrito) {

        return sedeRepository.findByDistrito(distrito).orElseThrow(() -> new EntityNotFoundException("Distrito no encontrado con el nombre" + distrito.toString()));

    }

    @Override
    public Sede agregarSede(Sede sede) {

        return sedeRepository.save(sede);

    }

    @Override
    public Sede actualizarSede(Sede sede) {

        var SedeF = sedeRepository.findById(sede.getId()).get();
        SedeF.setCodigoS(sede.getCodigoS());
        SedeF.setDistrito(sede.getDistrito());
        SedeF.setDireccion(sede.getDireccion());
        SedeF.setIndicaciones(sede.getIndicaciones());
        SedeF.setTelefono(sede.getTelefono());
        SedeF.setCorreo(sede.getCorreo());

        return sedeRepository.save(SedeF);

    }

    @Override
    public void eliminarSede(Long id) {

        var SedeF = sedeRepository.findById(id).get();

        sedeRepository.delete(SedeF);

    }

    @Override
    public Sede findByCodigoS(Long codigoS) {
        
        return sedeRepository.findByCodigoS(codigoS).orElseThrow(() -> new EntityNotFoundException("Sede no encontrado con el codigo"+codigoS.toString()));
        
    }

}
