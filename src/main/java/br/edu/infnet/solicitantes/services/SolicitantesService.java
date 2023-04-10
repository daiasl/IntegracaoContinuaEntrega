package br.edu.infnet.solicitantes.services;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.solicitantes.controller.App;
import br.edu.infnet.solicitantes.model.Sexo;
import br.edu.infnet.solicitantes.model.Solicitantes;
import br.edu.infnet.solicitantes.model.SolicitantesDto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SolicitantesService implements App {

    private static final Logger log = LoggerFactory.getLogger(SolicitantesService.class);
    private final SolicitantesRepository repository;
    private final ObservationRegistry registry;    
    private final Random random = new Random();

    public SolicitantesService(SolicitantesRepository repository, ObservationRegistry registry) {
        this.repository = repository;
        this.registry = registry;
    }

    @Override
    public SolicitantesDto save(SolicitantesDto solicitantesDto) {
        log.info("Salvando solicitante {}", solicitantesDto.getNome());
        Solicitantes solicitantes = repository.save(solicitantesDto.toSolicitantes());
        return solicitantes.toDto();
    }

    @Override
    public SolicitantesDto find(String cpf) {
        log.info("Buscando solicitante com cpf = {}", cpf);
        Solicitantes solicitantes = repository.findById(cpf).orElseThrow();
        return solicitantes.toDto();
    }

    @Override
    public List<SolicitantesDto> findAll() {

        log.info("Buscando todos os solicitantes");
        List<Solicitantes> solicitantes = repository.findAll();
        return solicitantes.stream().map(Solicitantes::toDto).toList();
    }

    @Override
    public void delete(String cpf) {

        log.info("Apagando solicitante com o cpf = <{}>", cpf);
        repository.deleteById(cpf);
    }
}
