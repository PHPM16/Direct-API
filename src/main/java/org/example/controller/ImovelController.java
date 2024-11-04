package org.example.controller;

import org.example.model.Imovel;
import org.example.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    // Permite requisições de qualquer origem para o endpoint de listagem
    @CrossOrigin(origins = "*")
    @GetMapping("/ordenados")
    public List<Imovel> getImoveisOrdenados() {
        return imovelService.getImoveisOrdenadosPorUltimoContato();
    }

    // Permite requisições de qualquer origem para o endpoint de cadastro
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<String> cadastrarImovel(@RequestBody Imovel imovel) {
        imovelService.salvarImovel(imovel);  // Método para salvar o imóvel no banco
        return ResponseEntity.ok("Imóvel cadastrado com sucesso!");
    }

    // Endpoint para atualizar um imóvel existente com base no ID
    @CrossOrigin(origins = "*")
    @PatchMapping("/{id}")
    public ResponseEntity<String> atualizarImovel(@PathVariable int id, @RequestBody Imovel imovel) {
        try {
            imovelService.atualizarImovel(id, imovel);
            return ResponseEntity.ok("Imóvel atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao atualizar o imóvel: " + e.getMessage());
        }
    }
}
