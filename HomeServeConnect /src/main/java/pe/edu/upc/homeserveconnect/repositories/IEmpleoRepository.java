package pe.edu.upc.homeserveconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.homeserveconnect.entities.Empleo;

import java.util.List;

@Repository
public interface IEmpleoRepository extends JpaRepository<Empleo, Integer> {

    @Query("SELECT e FROM Empleo e WHERE e.nombreEmpleo LIKE %:nombreEmpleo%")
    List<Empleo> buscarPorNombre(@Param("nombreEmpleo") String nombreEmpleo);
}
