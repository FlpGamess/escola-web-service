package om.faculdade.escola1.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name="professor")
@Entity(name="professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "prof_id")

public class professor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  prof_id;



	private String prof_nome;
	private float prof_salario;
	private String prof_formacao;
	private String prof_endereco;
	private String prof_telefone;
	private String prof_email;
	private String prof_rg;
	
	@OneToOne(mappedBy = "monitor")
	@JsonBackReference
    private clube clubemonitorado;  // Relacionamento com o clube que o aluno é presidente
	
	 public professor() {
	    }
		
	public professor(requestprofessor requestprofessor) {
			this.prof_nome = requestprofessor.prof_nome();
			this.prof_salario = requestprofessor.prof_salario();
			this.prof_formacao = requestprofessor.prof_formacao();
			this.prof_endereco = requestprofessor.prof_endereco();
			this.prof_telefone = requestprofessor.prof_telefone();
			this.prof_email = requestprofessor.prof_email();
			this.prof_rg = requestprofessor.prof_rg();
			
			
		}
	public Integer getprof_id() {
		return prof_id;
		}

	public String getprof_nome() {
	return prof_nome;
	}
	public void setprof_nome(String prof_nome) {
	this.prof_nome = prof_nome;
	}
	public float  getprof_salario() {
	return prof_salario;
	}
	public void setprof_salario(float prof_salario) {
	this.prof_salario = prof_salario;
	}
	public String getprof_formacao() {
	return prof_formacao;
	}
	public void setprof_formacao(String prof_formacao) {
	this.prof_formacao = prof_formacao;
	}
	public String getprof_endereco() {
	return prof_endereco;
	}
	public void setprof_endereco(String prof_endereco) {
	this.prof_endereco = prof_endereco;
	}
	public String getprof_telefone() {
	return prof_telefone;
	}
	public void setprof_telefone(String prof_telefone) {
	this.prof_telefone = prof_telefone;
	}
	public String getprof_email() {
	return prof_email;
	}
	public void setprof_email(String prof_email) {
	this.prof_email = prof_email;
	}
	public String getprof_rg() {
	return prof_rg;
	}
	public void setprof_rg(String prof_rg) {
	this.prof_rg = prof_rg;
	}
	
	public clube getclubemonitorado() {
        return clubemonitorado;
    }

    public void setclubemonitorado(clube clubemonitorado) {
        this.clubemonitorado = clubemonitorado;
    }

}
