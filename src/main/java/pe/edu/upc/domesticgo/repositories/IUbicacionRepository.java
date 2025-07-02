package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Ubicacion;

import java.util.List;

@Repository
public interface IUbicacionRepository extends JpaRepository<Ubicacion, Integer> {

    @Query("Select u from Ubicacion u where u.direccion like %:na%")
    public List<Ubicacion> buscarDireccion(@Param("na") String na);
}
