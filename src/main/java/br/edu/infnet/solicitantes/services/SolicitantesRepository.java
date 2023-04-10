package br.edu.infnet.solicitantes.services;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.solicitantes.model.Solicitantes;

public interface SolicitantesRepository extends JpaRepository<Solicitantes, String> {
}
