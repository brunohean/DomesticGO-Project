package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Contrato;

import java.util.List;

public interface IContratoService {
    void insert(Contrato contrato);
    List<Contrato> list();
    Contrato searchById(int id);
    void delete(int id);
    void update(Contrato contrato);

    List<Contrato> buscarPorContratante(int usuarioId);
    List<Contrato> buscarPorContratado(int usuarioId);
}
