package pe.cibertec.ProyectoFinal.ApiSede.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiSede.entity.Sede;
import pe.cibertec.ProyectoFinal.ApiSede.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiSede.service.SedeService;

@RestController
@RequestMapping("/api/v1/sede")
@Slf4j

public class SedeController {

    @Autowired

    private SedeService sedeService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Sede>> findAll() {
        log.info("Endpoint: /api/v1/sede/findAll - Buscando todas las sedes");
        return new ResponseEntity<>(sedeService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/findByCodigoS/{codigoS}")

    public ResponseEntity<Sede> findByCodigoS(@PathVariable Long codigoS) {
        try {
            log.info("Endpoint: /api/v1/sede/findByCodigoS/{} - Buscando sede por código: {}", codigoS, codigoS);
            Sede sede = sedeService.findByCodigoS(codigoS);
            return new ResponseEntity<>(sede, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar sede por código {}: {}", codigoS, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Sede> buscarPorId(@PathVariable Long id) {
        try {
            log.info("Endpoint: /api/v1/sede/buscarPorId/{} - Buscando sede por ID: {}", id, id);
            Sede sede = sedeService.buscarPorId(id);
            return new ResponseEntity<>(sede, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar sede por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findByDistrito/{distrito}")

    public ResponseEntity<Sede> findByDistrito(@PathVariable String distrito) {
        try {
            log.info("Endpoint: /api/v1/sede/findByDistrito/{} - Buscando sede por distrito: {}", distrito, distrito);
            Sede sede = sedeService.findByDistrito(distrito);
            return new ResponseEntity<>(sede, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar sede por distrito {}: {}", distrito, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregarSede")

    public ResponseEntity<Sede> agregarSede(@RequestBody Sede sede) {
        log.info("Endpoint: /api/v1/sede/agregarSede - Agregando nueva sede: {}", sede);

        return new ResponseEntity<>(sedeService.agregarSede(sede), HttpStatus.CREATED);

    }

    @PutMapping("/actualizarSede")

    public ResponseEntity<Sede> actualizarSede(@RequestBody Sede sede) {
        log.info("Endpoint: /api/v1/sede/actualizarSede - Actualizando sede con ID {}: {}", sede.getId(), sede);

        return new ResponseEntity<>(sedeService.actualizarSede(sede), HttpStatus.OK);

    }

    @DeleteMapping("/eliminarSede/{id}")

    public void eliminarSede(@PathVariable Long id) {
        try {
            log.info("Endpoint: /api/v1/sede/eliminarSede/{} - Eliminando sede con ID: {}", id, id);
            sedeService.eliminarSede(id);
        } catch (EntityNotFoundException e) {
            log.error("Error al eliminar sede con ID {}: {}", id, e.getMessage());
        }
    }

}
