package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Usuario;
import pe.edu.upc.homeserveconnect.repositories.IUsuarioRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public Usuario searchById(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<Usuario> buscarPorRol(String nombreRol) {
        return uR.buscarPorRol(nombreRol);
    }

    @Override
    public List<Usuario> buscarPorEmpleo(String empleo) {
        return uR.buscarPorEmpleo(empleo);
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return uR.buscarPorNombre(nombre);
    }
}
