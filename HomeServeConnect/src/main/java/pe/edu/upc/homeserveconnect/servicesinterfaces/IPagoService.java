package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Pago;

import java.util.List;

public interface IPagoService {
    void insert(Pago pago);
    List<Pago> list();
    Pago searchById(int id);
    void delete(int id);
    void update(Pago pago);

    List<Pago> buscarPorContrato(int contratoId);
    List<Pago> buscarPorBanco(String banco);
}
