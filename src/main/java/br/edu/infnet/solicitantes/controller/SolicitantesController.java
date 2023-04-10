package br.edu.infnet.solicitantes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.solicitantes.model.SolicitantesDto;

import java.util.List;


@RestController
@RequestMapping("/solicitantes")
public class SolicitantesController {

    private static final Logger log = LoggerFactory.getLogger(SolicitantesController.class);
    private final App solicitantesService;

    public SolicitantesController(App devOpsService) {

        this.solicitantesService = devOpsService;
    }

    @PostMapping(produces = "application/json")
    public SolicitantesDto save(@RequestBody SolicitantesDto usuario) {
        log.info("save got a request");
        return solicitantesService.save(usuario);
    }

    @GetMapping("/{cpf}")
    public SolicitantesDto findById(@PathVariable("cpf") String cpf) {
        log.info("findById got a request");
        return solicitantesService.find(cpf);
    }

    @GetMapping
    public List<SolicitantesDto> findAll(){
        log.info("findAll got a request");
        return solicitantesService.findAll();
    }

    @DeleteMapping("/{cpf}")
    public void deleteById(@PathVariable("cpf") String cpf) {
        log.info("deleteById got a request");
        solicitantesService.delete(cpf);
    }
  
}
