package org.example.service;

import org.example.model.Imovel;
import org.example.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    private ImovelRepository imovelRepository;

    public ImovelService() {
        // Instancia manual da classe ImovelRepository
        this.imovelRepository = new ImovelRepository();
    }
    // Método para buscar imóveis ordenados pela data mais antiga
    public List<Imovel> getImoveisOrdenadosPorUltimoContato() {
        return imovelRepository.findAllByOrderByUltimoContatoDesc();
    }
    // Salva um novo imóvel no banco de dados
    public void salvarImovel(Imovel imovel) {
        imovelRepository.save(imovel);
    }

    public void atualizarImovel(int id, Imovel imovel) {
        imovelRepository.updateImovel(id, imovel);
    }
}

