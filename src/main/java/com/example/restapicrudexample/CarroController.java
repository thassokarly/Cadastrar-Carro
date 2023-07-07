package com.example.restapicrudexample;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CarroController {


    CarroRepository repository;
    @GetMapping("/carro")
    public List<Carro> getAllCarros(){
        return repository.findAll();
    }

    @GetMapping("/carro/{id}")
    public Carro getCarroById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @PostMapping("/carro")
    public Carro saveCarro(@RequestBody @Valid  Carro carro) {
        return repository.save(carro);
    }

    @PutMapping("/carro/{id}")
    public Carro updateCarro(@PathVariable Long id, @RequestBody  Carro carroDetails) {
        Optional<Carro> optionalCarro = repository.findById(id);
        if (optionalCarro.isPresent()) {
            Carro carro = optionalCarro.get();
            carro.setMarca(carroDetails.getMarca());
            carro.setModelo(carroDetails.getModelo());
            carro.setAno(carroDetails.getAno());
            carro.setCor(carroDetails.getCor());
            carro.setValor(carroDetails.getValor());
            // Adicione essa linha para atualizar o ano
            // Atualize outras propriedades conforme necessário
            return repository.save(carro);
        } else {
            throw new IllegalArgumentException("Carro com o ID fornecido não encontrado: " + id);
        }
    }

    @DeleteMapping("/carro/{id}")
    public void deleteCarro(@PathVariable Long id){
        repository.deleteById(id);
    }


}
