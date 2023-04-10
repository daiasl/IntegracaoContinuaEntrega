package br.edu.infnet.solicitantes.controller;

import java.util.List;

import br.edu.infnet.solicitantes.model.SolicitantesDto;

public interface App {
    
    SolicitantesDto save(SolicitantesDto solicitantesDto);
    SolicitantesDto find(String cpf);
    List<SolicitantesDto> findAll();
    void delete(String cpf);
}
