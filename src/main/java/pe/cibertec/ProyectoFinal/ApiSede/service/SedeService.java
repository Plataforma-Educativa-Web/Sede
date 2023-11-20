package pe.cibertec.ProyectoFinal.ApiSede.service;

import java.util.List;
import pe.cibertec.ProyectoFinal.ApiSede.entity.Sede;

public interface SedeService {

    public List<Sede> findAll();

    public Sede buscarPorId(Long id);
    
    public Sede findByDistrito(String distrito);

    public Sede agregarSede(Sede sede);

    public Sede actualizarSede(Sede sede);

    public void eliminarSede(Long id);
 
}
