package om.faculdade.escola1.crontroller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;
import om.faculdade.escola1.domain.alunos;
import om.faculdade.escola1.domain.alunosrepository;
import om.faculdade.escola1.domain.clube;
import om.faculdade.escola1.domain.cluberepository;
import om.faculdade.escola1.domain.requestclube;
import om.faculdade.escola1.dto.countalunosporclube;
import om.faculdade.escola1.dto.countmonitores;
import om.faculdade.escola1.dto.sumverbat;
import om.faculdade.escola1.domain.professor;
import om.faculdade.escola1.domain.professorrepository;

@RestController
@RequestMapping("/clube")
public class ClubeController {
	@Autowired
	private cluberepository repository;
	
	@Autowired
	private alunosrepository alunosrepository;
	
	@Autowired
	private professorrepository professorrepository;
	
    @GetMapping
    public ResponseEntity getAllclube(){
        var allclube = repository.findAll();
        	
       return ResponseEntity.ok(allclube);
       
    }
    
    @GetMapping("/monitores")
    public List<countmonitores> monitores() {
    	List<countmonitores> lista = repository.totais();
    	return lista;
    }
    
    @GetMapping("/verbatotal")
    public List<sumverbat> verbatotal() {
    	List<sumverbat> lista = repository.verbat();
    	return lista;
    }
    
    @GetMapping("/alunospclube")
    public List<countalunosporclube> contaralunos() {
    	List<countalunosporclube> lista = repository.ContarAlunos();
    	return lista;
    }
    
    
    
    @PostMapping
    public ResponseEntity registrarclube(@RequestBody @Valid requestclube data) {
    	clube newclube = new clube(data);
    	  
              alunos presidenteAssociado = alunosrepository.findById(data.clu_id_presidente()).orElse(null);
                  // Associar o clube ao aluno
                  newclube.setClupresidente(presidenteAssociado);
               // Verificar se o ID do clube foi fornecido
                  if (data.clu_monitor() != null) {
                      professor professorAssociado = professorrepository.findById(data.clu_monitor()).orElse(null);
                      if (professorAssociado != null) {
                          // Associar o clube ao aluno
                          newclube.setClu_monitor(professorAssociado);
                      }
                  }
              
          
          
    	System.out.println(data);
    	repository.save(newclube);
    	return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarclube(@PathVariable Integer id, @RequestBody @Valid requestclube data) {
        Optional<clube> clubeExistente = repository.findById(id);
        
        if (clubeExistente.isPresent()) {
            clube clubeAtualizado = clubeExistente.get();
            clubeAtualizado.setClu_nome(data.clu_nome());
            clubeAtualizado.setClu_horario(data.clu_horario());
            clubeAtualizado.setClu_infracao(data.clu_infracao());
            clubeAtualizado.setClu_infra_desc(data.clu_infra_desc());
            clubeAtualizado.setClu_estado(data.clu_estado());
            clubeAtualizado.setClu_verba(data.clu_verba());
            clubeAtualizado.setClu_sala(data.clu_sala());
 
        
            // Buscando o clube pelo ID
            if (data.clu_id_presidente() != null) {
                Optional<alunos> alunos = alunosrepository.findById(data.clu_id_presidente());  // Usando seu clubeRepository para buscar o clube
                if (alunos.isPresent()) {
                    clubeAtualizado.setClupresidente(alunos.get());  // Associando o clube ao aluno
                }
                else {
                    return ResponseEntity.badRequest().body("Presidente não encontrado.");
                }
            }
            
            if (data.clu_monitor() != null) {
                Optional<professor> professor = professorrepository.findById(data.clu_monitor());  // Usando seu clubeRepository para buscar o clube
                if (professor.isPresent()) {
                    clubeAtualizado.setClu_monitor(professor.get());  // Associando o clube ao professor
                }
                else {
                    clubeAtualizado.setClu_monitor(null);} 
                
            }
            else {
            	clubeAtualizado.setClu_monitor(null);
            }
            
            
            repository.save(clubeAtualizado);
            
            return ResponseEntity.ok(clubeAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deletarclube(@PathVariable Integer id) {
    	repository.deleteById(id);
    	return ResponseEntity.noContent().build();
    }

    


}
