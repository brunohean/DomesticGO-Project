package pe.edu.upc.homeserveconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.homeserveconnect.entities.Pago;

import java.util.List;

@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {

    @Query("SELECT p FROM Pago p WHERE p.contrato.idContrato = :idContrato")
    List<Pago> buscarPorContrato(@Param("idContrato") int idContrato);

    @Query("SELECT p FROM Pago p WHERE p.banco LIKE %:banco%")
    List<Pago> buscarPorBanco(@Param("banco") String banco);


}
