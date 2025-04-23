package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.homeserveconnect.entities.Usuario;
import pe.edu.upc.homeserveconnect.repositories.IUsuarioRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario searchId(int id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }


}
