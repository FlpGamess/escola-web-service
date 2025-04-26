package om.faculdade.escola1.domain;

import java.time.LocalTime;
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



@Table(name="clube")
@Entity(name="clube")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="clu_id")
public class clube {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clu_id;
	
	
	
	
	private String clu_nome;
	private LocalTime clu_horario;
	private Integer clu_infracao;
	private String clu_infra_desc;
	private char clu_estado;
	private float clu_verba;
	private String clu_sala;
	
	
	@OneToOne
    @JoinColumn(name = "clu_id_presidente", referencedColumnName = "alu_id")
    private alunos presidente;  // Relacionamento com o presidente (Aluno)
	
	@OneToOne
    @JoinColumn(name = "clu_monitor", referencedColumnName = "prof_id")
    private professor monitor;  // Relacionamento com o presidente (Aluno)
	
	@OneToMany(mappedBy = "clube")
	@JsonBackReference
    private List<alunos> alunos;
    

    
	
	
    public clube() {
    }
	
	public clube(requestclube requestclube) {
		this.setClu_nome(requestclube.clu_nome());
		this.setClu_horario(requestclube.clu_horario());
		this.setClu_infracao(requestclube.clu_infracao());
		this.setClu_infra_desc(requestclube.clu_infra_desc());
		this.setClu_estado(requestclube.clu_estado());
		this.setClu_verba(requestclube.clu_verba());
		this.setClu_sala(requestclube.clu_sala());
		

		
		
		
	}
	
	public Integer getclu_id() {
        return clu_id;
    }

	public String getClu_nome() {
		return clu_nome;
	}

	public void setClu_nome(String clu_nome) {
		this.clu_nome = clu_nome;
	}

	public LocalTime getClu_horario() {
		return clu_horario;
	}

	public void setClu_horario(LocalTime clu_horario) {
		this.clu_horario = clu_horario;
	}

	public Integer getClu_infracao() {
		return clu_infracao;
	}

	public void setClu_infracao(Integer clu_infracao) {
		this.clu_infracao = clu_infracao;
	}

	public String getClu_infra_desc() {
		return clu_infra_desc;
	}

	public void setClu_infra_desc(String clu_infra_desc) {
		this.clu_infra_desc = clu_infra_desc;
	}

	public char getClu_estado() {
		return clu_estado;
	}

	public void setClu_estado(char clu_estado) {
		this.clu_estado = clu_estado;
	}

	public float getClu_verba() {
		return clu_verba;
	}

	public void setClu_verba(float clu_verba) {
		this.clu_verba = clu_verba;
	}

	public String getClu_sala() {
		return clu_sala;
	}

	public void setClu_sala(String clu_sala) {
		this.clu_sala = clu_sala;
	}
	public Integer getClu_presidente() {
		return presidente.getAlu_id();
	}

	public void setClupresidente(alunos presidente) {
		this.presidente = presidente;
	}
	
	public Integer getClu_monitor() {
	    return monitor != null ? monitor.getprof_id() : null;
	}


	public void setClu_monitor(professor clu_monitor) {
		this.monitor = clu_monitor;
	}
	
	public List<alunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<alunos> alunos) {
        this.alunos = alunos;
    }

}
