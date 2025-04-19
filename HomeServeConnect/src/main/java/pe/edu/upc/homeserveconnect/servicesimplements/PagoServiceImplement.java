package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Pago;
import pe.edu.upc.homeserveconnect.repositories.IPagoRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IPagoService;

import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {

    @Autowired
    private IPagoRepository pR;

    @Override
    public void insert(Pago pago) {
        pR.save(pago);
    }

    @Override
    public List<Pago> list() {
        return pR.findAll();
    }

    @Override
    public Pago searchById(int id) {
        return pR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public void update(Pago pago) {
        pR.save(pago);
    }

    @Override
    public List<Pago> buscarPorContrato(int contratoId) {
        return pR.buscarPorContrato(contratoId);
    }

    @Override
    public List<Pago> buscarPorBanco(String banco) {
        return pR.buscarPorBanco(banco);
    }
}
