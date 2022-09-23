package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrera {
    @Id
    int id_carrera;

    String Nombre;

    List<Matriculacion> matriculaciones;


}
