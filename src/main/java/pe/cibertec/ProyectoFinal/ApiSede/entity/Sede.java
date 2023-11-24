package pe.cibertec.ProyectoFinal.ApiSede.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Sede {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private Long id;
    private Long codigoS;
    private String distrito;
    private String direccion;
    private String indicaciones;
    private String telefono;
    private String correo;
    
}
