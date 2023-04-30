package br.fiap.app.mars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fiap.app.mars.models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

}
