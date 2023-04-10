package br.edu.infnet.solicitantes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitantes")
public class Solicitantes {
    @Id
    private String cpf;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Solicitantes() {
    	
    }
    
    public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Sexo getSexo() {
		return sexo;
	}



	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public Solicitantes(String cpf, String nome, Sexo sexo) {		
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
	}



	public SolicitantesDto toDto(){
        return new SolicitantesDto(cpf, nome, sexo);
    }
}
