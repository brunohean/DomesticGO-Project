package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Empleo;
import pe.edu.upc.domesticgo.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

    @Query("Select e from Rol e where e.nombreRol like %:na%")
    public List<Rol> buscarNombre(@Param("na") String na);
}
