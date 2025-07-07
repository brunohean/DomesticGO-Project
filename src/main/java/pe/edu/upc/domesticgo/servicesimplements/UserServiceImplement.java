package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.User;
import pe.edu.upc.domesticgo.repositories.IUserRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Para encriptar contraseña que proviene de FrontEnd

    // Implementacion de Metodos CRUD
    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public void insert(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
userRepository.save(user);
    }

    @Override
    public void update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
userRepository.deleteById(id);
    }

    @Override
    public User searchId(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    // Metodos personalizados

    @Override
    public List<User> searchNameUser(String na) {
        return userRepository.buscarNombreUser(na);
    }
}
