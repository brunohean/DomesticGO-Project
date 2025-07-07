package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.User;

import java.util.List;

public interface IUserService {
    // Metodos de CRUD
    public List<User> list();
    public void insert(User user);
    public void update(User user);
    public void delete(Long id);
    public User searchId(Long id);
    // Metodos personalizados
    public List<User> searchNameUser(String tipo);
}
