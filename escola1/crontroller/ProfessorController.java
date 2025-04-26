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
import om.faculdade.escola1.domain.professor;
import om.faculdade.escola1.domain.professor;
import om.faculdade.escola1.domain.professorrepository;
import om.faculdade.escola1.domain.requestprofessor;
import om.faculdade.escola1.domain.requestprofessor;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	@Autowired
	private professorrepository repository;

	    @GetMapping
	    public ResponseEntity<List> getAllprofessor(){
	        var allprofessor = repository.findAll();
	        //return ResponseEntity.ok("oiiiii");
	       return ResponseEntity.ok(allprofessor);
	       
	    }
	    
	    @PostMapping
	    public ResponseEntity registrarprofessor(@RequestBody @Valid requestprofessor data) {
	    	professor newprofessor = new professor(data);
	    	System.out.println(data);
	    	repository.save(newprofessor);
	    	return ResponseEntity.ok().build();
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> atualizarprofessor(@PathVariable Integer id, @RequestBody @Valid requestprofessor data) {
	        Optional<professor> professorExistente = repository.findById(id);
	        
	        if (professorExistente.isPresent()) {
	            professor professorAtualizado = professorExistente.get();
	            professorAtualizado.setprof_nome(data.prof_nome());
	            professorAtualizado.setprof_salario(data.prof_salario());
	            professorAtualizado.setprof_formacao(data.prof_formacao());
	            professorAtualizado.setprof_endereco(data.prof_endereco());
	            professorAtualizado.setprof_telefone(data.prof_telefone());
	            professorAtualizado.setprof_email(data.prof_email());
	            professorAtualizado.setprof_rg(data.prof_rg());
	     
	            repository.save(professorAtualizado);
	            
	            return ResponseEntity.ok(professorAtualizado);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity deletarprofessor(@PathVariable Integer id) {
	    	repository.deleteById(id);
	    	return ResponseEntity.noContent().build();
	    }
	
}
