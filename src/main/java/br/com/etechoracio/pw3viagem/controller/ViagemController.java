package br.com.etechoracio.pw3viagem.controller;

import br.com.etechoracio.pw3viagem.Entity.Viagem;
import br.com.etechoracio.pw3viagem.repository.ViagemRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Vinicius Mateos

@RestController
@RequestMapping("/viagens")
public class  ViagemController{
    @Autowired
    private ViagemRepository repository;

    @GetMapping()
    public List<Viagem> buscarTodos(@RequestParam(required = false) String destino)
    {
        if(destino == null)
        return repository.findAll();
        else
            return repository.findByDestino(destino);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id)
    {
        Optional<Viagem> existe = repository.findById(id);
        if (existe.isPresent())
            return ResponseEntity.ok(repository.findById(id));
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Viagem inserir(@RequestBody Viagem body)
    {
        Viagem inserida = repository.save(body);
        return inserida;
    }

    @PutMapping("/{id}")
    public ResponseEntity Atualizar (@PathVariable Long id, @RequestBody Viagem obj)
    {
        Optional<Viagem> existe = repository.findById(id);
        if(existe.isPresent()) {
            repository.save(obj);
            return ResponseEntity.ok(obj);
        }
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id)
    {
        Optional<Viagem> existe = repository.findById(id); //Optional - caixa dentro da caixa "Viagem" <Viagem>
                if(existe.isPresent()) {//verifica se há algo na caixa Optional
                    repository.deleteById(id); // se tem, deleta
                    return ResponseEntity.ok().build();
                }
                else
            return ResponseEntity.notFound().build();
    }
}
