package br.com.etechoracio.pw3viagem.controller;

import br.com.etechoracio.pw3viagem.Entity.Viagem;
import br.com.etechoracio.pw3viagem.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viagens")
public class  ViagemController{
    @Autowired
    private ViagemRepository repository;

    @GetMapping()
    public List<Viagem> buscarTodos()
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Viagem> buscarPorId(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public Viagem inserir(@RequestBody Viagem body)
    {
        Viagem inserida = repository.save(body);
        return inserida;
    }

    @PutMapping("/{id}")
    public Viagem Atualizar (@PathVariable Long id, @RequestBody Viagem obj)
    {
        Optional<Viagem> existe = buscarPorId(id);
        if(existe.isPresent())
            repository.save(obj);
        return obj;
    }
}
