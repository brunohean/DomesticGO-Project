package pe.edu.upc.domesticgo.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.dtos.UsuarioResponde;
import pe.edu.upc.domesticgo.entities.Usuario;
import pe.edu.upc.domesticgo.repositories.IUsuarioRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service  // Asegúrate de que esta anotación esté presente
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponde> list() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioResponde(usuario))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponde searchId(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            return new UsuarioResponde(usuario);
        }
        return null;
    }

    @Override
    public UsuarioResponde insert(Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return new UsuarioResponde(savedUsuario);
    }

    @Override
    public UsuarioResponde update(int id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setIdUsuario(id);
            Usuario updatedUsuario = usuarioRepository.save(usuario);
            return new UsuarioResponde(updatedUsuario);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
