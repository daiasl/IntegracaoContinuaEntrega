package br.edu.infnet.solicitantes.model;

public class SolicitantesDto {
    private String cpf;
    private String nome;
    private Sexo sexo;

    public SolicitantesDto() {
    	
    }
    
    public SolicitantesDto(String cpf, String nome, Sexo sexo) {		
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
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


	public Solicitantes toSolicitantes(){
        return new Solicitantes(cpf, nome, sexo);
    }
}
