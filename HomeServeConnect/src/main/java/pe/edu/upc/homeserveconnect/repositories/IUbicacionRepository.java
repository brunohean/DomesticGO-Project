package pe.edu.upc.homeserveconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.homeserveconnect.entities.Ubicacion;

import java.util.List;

@Repository
public interface IUbicacionRepository extends JpaRepository<Ubicacion, Integer> {

    @Query("SELECT u FROM Ubicacion u WHERE u.direccion LIKE %:texto%")
    List<Ubicacion> buscarPorDireccion(@Param("texto") String texto); // ✅ Nombre exacto esperado por Service
}
