package pe.cibertec.ProyectoFinal.ApiSede.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ProyectoFinal.ApiSede.entity.Sede;

public interface SedeRepository extends JpaRepository<Sede, Long> {

    Optional<Sede> findByDistrito(String distrito);

}
