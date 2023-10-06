package dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	private String matricula;
	private String nome;
	private String email;
	
	public Aluno() {}
	
	public Aluno(String matricula, String nome, String email ){	
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
}

