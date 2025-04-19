package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Contrato;
import pe.edu.upc.homeserveconnect.repositories.IContratoRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IContratoService;

import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {

    @Autowired
    private IContratoRepository cR;

    @Override
    public void insert(Contrato contrato) {
        cR.save(contrato);
    }

    @Override
    public List<Contrato> list() {
        return cR.findAll();
    }

    @Override
    public Contrato searchById(int id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Contrato contrato) {
        cR.save(contrato);
    }

    @Override
    public List<Contrato> buscarPorContratante(int usuarioId) {
        return cR.buscarPorContratante(usuarioId);
    }

    @Override
    public List<Contrato> buscarPorContratado(int usuarioId) {
        return cR.buscarPorContratado(usuarioId);
    }
}
