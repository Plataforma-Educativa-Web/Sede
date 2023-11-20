package pe.cibertec.ProyectoFinal.ApiSede.controller;

import java.util.List;
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
import pe.cibertec.ProyectoFinal.ApiSede.service.SedeService;

@RestController
@RequestMapping("/api/v1/sede")

public class SedeController {
    
    @Autowired
    
    private SedeService sedeService;
    
    @GetMapping("/findAll")
    
    public ResponseEntity<List<Sede>> findAll(){ 
        
        return new ResponseEntity<>(sedeService.findAll(),HttpStatus.OK);
        
    }
    
    @GetMapping("/buscarPorId/{id}")
    
    public ResponseEntity<Sede> buscarPorId(@PathVariable Long id) {
        
        return new ResponseEntity<>(sedeService.buscarPorId(id), HttpStatus.OK);
        
    }
    
    @GetMapping("/findByDistrito/{distrito}")
    
    public ResponseEntity<Sede> findByDistrito (@PathVariable String distrito) {
        
        return new ResponseEntity<>(sedeService.findByDistrito(distrito), HttpStatus.OK);
        
    }
    
    @PostMapping("/agregarSede")
    
    public ResponseEntity<Sede> agregarSede (@RequestBody Sede sede) {
        
        return new ResponseEntity<>(sedeService.agregarSede(sede), HttpStatus.CREATED);
        
    }
    
    @PutMapping("/actualizarSede")
    
    public ResponseEntity<Sede> actualizarSede (@RequestBody Sede sede) {
        
        return new ResponseEntity<>(sedeService.actualizarSede(sede), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarSede/{id}")
    
    public void eliminarSede(@PathVariable Long id) {
        
        sedeService.eliminarSede(id);
        
    }
    
    
}
