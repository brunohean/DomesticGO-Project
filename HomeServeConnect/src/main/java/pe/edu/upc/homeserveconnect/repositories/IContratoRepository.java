package pe.edu.upc.homeserveconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.homeserveconnect.entities.Contrato;

import java.util.List;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer> {

    @Query("SELECT c FROM Contrato c WHERE c.contratante.idUsuario = :idContratante")
    List<Contrato> buscarPorContratante(@Param("idContratante") int idContratante);

    @Query("SELECT c FROM Contrato c WHERE c.contratado.idUsuario = :idContratado")
    List<Contrato> buscarPorContratado(@Param("idContratado") int idContratado);
}
