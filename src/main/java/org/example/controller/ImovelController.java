package org.example.controller;

import org.example.model.Imovel;
import org.example.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;
    @CrossOrigin(origins = "*")  // Permite requisições de qualquer origem
    // Endpoint para retornar a lista de imóveis ordenada pela data mais antiga (ultimoContato)
    @GetMapping("/ordenados")
    public List<Imovel> getImoveisOrdenados() {
        return imovelService.getImoveisOrdenadosPorUltimoContato();
    }
}

