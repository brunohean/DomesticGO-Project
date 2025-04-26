package pe.edu.upc.domesticgo.repositories;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.domesticgo.entities.Resenias;
@Registered
public interface ReseniasReposiroies extends JpaRepository<Resenias, Integer> {
}
