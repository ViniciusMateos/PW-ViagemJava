package br.com.etechoracio.pw3viagem.repository;

import br.com.etechoracio.pw3viagem.Entity.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViagemRepository extends JpaRepository<Viagem, Long>
{
    List<Viagem> findByDestino(String destino);
}
