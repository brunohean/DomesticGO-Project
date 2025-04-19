package pe.edu.upc.homeserveconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.homeserveconnect.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

    @Query("SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol")
    List<Rol> buscarPorNombre(@Param("nombreRol") String nombreRol);
}
