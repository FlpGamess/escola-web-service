package om.faculdade.escola1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Table(name="alunos")
@Entity(name="alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "alu_id")


public class alunos {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  alu_id;
	
	
	
	private String alu_rg;
	private String alu_nome;
	private Integer alu_idade;
	private String alu_turma;
	private String alu_endereco;
	private char alu_sexo;
	private String alu_responsavel;
	private String alu_telefone;
	private String alu_tel_responsavel;
	private String alu_email;
	
	@OneToOne(mappedBy = "presidente")
	@JsonBackReference
    private clube cluberesp;  // Relacionamento com o clube que o aluno é presidente
	
	@ManyToOne
    @JoinColumn(name = "alu_clu_id", referencedColumnName = "clu_id")
    private clube clube;
	

	
	
    public alunos() {
    }
	
	public alunos(requestalunos requestalunos) {
		this.alu_rg = requestalunos.alu_rg();
		this.alu_nome = requestalunos.alu_nome();
		this.alu_idade = requestalunos.alu_idade();
		this.alu_turma = requestalunos.alu_turma();
		this.alu_endereco = requestalunos.alu_endereco();
		this.alu_sexo = requestalunos.alu_sexo();
		this.alu_responsavel = requestalunos.alu_responsavel();
		this.alu_telefone = requestalunos.alu_telefone();
		this.alu_tel_responsavel = requestalunos.alu_tel_responsavel();
		this.alu_email = requestalunos.alu_email();
		
		
	}
	public Integer getAlu_id() {
		return alu_id;
	}
	
	public String getAlu_rg() {
		return alu_rg;
	}
	public void setAlu_rg(String alu_rg) {
		this.alu_rg = alu_rg;
	}
	public String getAlu_nome() {
		return alu_nome;
	}
	public void setAlu_nome(String alu_nome) {
		this.alu_nome = alu_nome;
	}
	public Integer getAlu_idade() {
		return alu_idade;
	}
	public void setAlu_idade(int alu_idade) {
		this.alu_idade = alu_idade;
	}
	public String getAlu_turma() {
		return alu_turma;
	}
	public void setAlu_turma(String alu_turma) {
		this.alu_turma = alu_turma;
	}
	public String getAlu_endereco() {
		return alu_endereco;
	}
	public void setAlu_endereco(String alu_endereco) {
		this.alu_endereco = alu_endereco;
	}
	public char getAlu_sexo() {
		return alu_sexo;
	}
	public void setAlu_sexo(char alu_sexo) {
		this.alu_sexo = alu_sexo;
	}
	public String getAlu_responsavel() {
		return alu_responsavel;
	}
	public void setAlu_responsavel(String alu_responsavel) {
		this.alu_responsavel = alu_responsavel;
	}
	public String getAlu_telefone() {
		return alu_telefone;
	}
	public void setAlu_telefone(String alu_telefone) {
		this.alu_telefone = alu_telefone;
	}
	public String getAlu_tel_responsavel() {
		return alu_tel_responsavel;
	}
	public void setAlu_tel_responsavel(String alu_tel_responsavel) {
		this.alu_tel_responsavel = alu_tel_responsavel;
	}
	public String getAlu_email() {
		return alu_email;
	}
	public void setAlu_email(String alu_email) {
		this.alu_email = alu_email;
	}
	/*public Integer getalu_clu_id() {
		return clube.getclu_id();
	}*/

	  public clube getClube() {
	        return clube;
	    }

	    public void setClube(clube clube) {
	        this.clube = clube;
	    }
	
	   
	

}
