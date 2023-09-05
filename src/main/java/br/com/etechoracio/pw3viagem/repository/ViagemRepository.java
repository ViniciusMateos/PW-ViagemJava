package br.com.etechoracio.pw3viagem.repository;

import br.com.etechoracio.pw3viagem.Entity.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository<Viagem, Long>
{

}
