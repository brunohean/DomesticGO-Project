package pe.edu.upc.domesticgo.servicesinterfaces;

import java.util.List;
import pe.edu.upc.domesticgo.dtos.UsuarioResponde;
import pe.edu.upc.domesticgo.entities.Usuario;

public interface IUsuarioService {
        List<UsuarioResponde> list();
        UsuarioResponde searchId(int id);
        UsuarioResponde insert(Usuario usuario);
        UsuarioResponde update(int id, Usuario usuario);
        boolean delete(int id);
}
