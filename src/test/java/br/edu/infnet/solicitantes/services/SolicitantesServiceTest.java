package br.edu.infnet.solicitantes.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.edu.infnet.solicitantes.model.Sexo;
import br.edu.infnet.solicitantes.model.Solicitantes;
import br.edu.infnet.solicitantes.model.SolicitantesDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolicitantesServiceTest {
	SolicitantesRepository repository;
	SolicitantesService solicitantesService;
    
	@BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.repository=Mockito.mock(SolicitantesRepository.class);
        this.solicitantesService = new SolicitantesService(repository, null);
    }

    /*@Test
    void save() {        
    	        
    	SolicitantesDto solNovo = new SolicitantesDto("123456789-10", "Solicitante Novo", Sexo.MASCULINO);
        System.out.println(solNovo.getNome());
        Mockito.when(repository.save(solNovo.toSolicitantes())).thenReturn(solNovo.toSolicitantes());

        SolicitantesDto solNovoGravado = solicitantesService.save(solNovo);

        assertEquals(solNovo.getCpf(), solNovoGravado.getCpf());
        assertEquals(solNovo.getNome(), solNovoGravado.getNome());
        assertEquals(solNovo.getSexo(), solNovoGravado.getSexo());
    }*/

    @Test
    void find() {
        SolicitantesDto solOriginal = new SolicitantesDto("333333333-33", "Solicitante Pesquisado", Sexo.FEMININO);
        Mockito.when(repository.findById("333333333-33")).thenReturn(Optional.ofNullable(solOriginal.toSolicitantes()));

        SolicitantesDto solRetornado = solicitantesService.find("333333333-33");

        assertEquals(solOriginal.getCpf(), solRetornado.getCpf());
        assertEquals(solOriginal.getNome(), solRetornado.getNome());
        assertEquals(solOriginal.getSexo(), solRetornado.getSexo());
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(solicitantes());

        List<SolicitantesDto> list = solicitantesService.findAll();

        assertEquals(2, list.size());
    }

    private List<Solicitantes> solicitantes(){
        Solicitantes u1 = new Solicitantes("111111111-11", "Fulano", Sexo.MASCULINO);
        Solicitantes u2 = new Solicitantes("222222222-22", "Fulana", Sexo.FEMININO);
        List<Solicitantes> solicitantes = new ArrayList<>();
        solicitantes.add(u1);
        solicitantes.add(u2);
        return solicitantes;
    }

    @Test
    void delete() {
        solicitantesService.delete("111111111-11");
        Mockito.verify(repository).deleteById("111111111-11");
    }
}