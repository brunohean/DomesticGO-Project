package pe.edu.upc.homeserveconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.homeserveconnect.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.rol.nombreRol = :nombreRol")
    List<Usuario> buscarPorRol(@Param("nombreRol") String nombreRol);

    @Query("SELECT u FROM Usuario u WHERE u.empleo.nombreEmpleo = :nombreEmpleo")
    List<Usuario> buscarPorEmpleo(@Param("nombreEmpleo") String nombreEmpleo);

    @Query("SELECT u FROM Usuario u WHERE u.nombres LIKE %:nombre%")
    List<Usuario> buscarPorNombre(@Param("nombre") String nombre);
}
