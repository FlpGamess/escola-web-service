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
import om.faculdade.escola1.domain.requestalunos;
import om.faculdade.escola1.dto.countalunosemclube;
import om.faculdade.escola1.dto.countidades;
import om.faculdade.escola1.dto.sumverbat;

@RestController
@RequestMapping("/alunos")

public class AlunosController {
	@Autowired
	private alunosrepository repository;
	
	@Autowired
	 private cluberepository cluberepository;
	
    @GetMapping
    public ResponseEntity getAllalunos(){
        var allalunos = repository.findAll();
        	
       return ResponseEntity.ok(allalunos);
       
    }
    
    
    @GetMapping("/idades")
    public List<countidades> contaridades() {
    	List<countidades> lista = repository.contaridades();
    	return lista;
    }
    
    @GetMapping("/statusclubes")
    public List<countalunosemclube> contaraluemclub() {
    	List<countalunosemclube> lista = repository.contaraluemclub();
    	return lista;
    }
    
    @PostMapping
    public ResponseEntity registraralunos(@RequestBody @Valid requestalunos data) {
        alunos newalunos = new alunos(data);
        
        // Verificar se o ID do clube foi fornecido
        if (data.alu_clu_id() != null) {
            clube clubeAssociado = cluberepository.findById(data.alu_clu_id()).orElse(null);
            if (clubeAssociado != null) {
                // Associar o clube ao aluno
                newalunos.setClube(clubeAssociado);
            }
        }
        
        // Salvar o aluno, independentemente de estar ou não associado a um clube
        repository.save(newalunos);
        return ResponseEntity.ok().build();
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAluno(@PathVariable Integer id, @RequestBody @Valid requestalunos data) {
        Optional<alunos> alunoExistente = repository.findById(id);
        
        if (alunoExistente.isPresent()) {
            alunos alunoAtualizado = alunoExistente.get();

            // Atualizando os dados do aluno
            alunoAtualizado.setAlu_rg(data.alu_rg());
            alunoAtualizado.setAlu_nome(data.alu_nome());
            alunoAtualizado.setAlu_idade(data.alu_idade());
            alunoAtualizado.setAlu_turma(data.alu_turma());
            alunoAtualizado.setAlu_endereco(data.alu_endereco());
            alunoAtualizado.setAlu_sexo(data.alu_sexo());
            alunoAtualizado.setAlu_responsavel(data.alu_responsavel());
            alunoAtualizado.setAlu_telefone(data.alu_telefone());
            alunoAtualizado.setAlu_tel_responsavel(data.alu_tel_responsavel());
            alunoAtualizado.setAlu_email(data.alu_email());
            
            // Buscando o presidente pelo ID
           
            if (data.alu_clu_id() != null) {
                Optional<clube> clube = cluberepository.findById(data.alu_clu_id());
                if (clube.isPresent()) {
                    alunoAtualizado.setClube(clube.get());
                } else {
                    alunoAtualizado.setClube(null);  // Remover a associação caso o clube não exista mais
                }
            } else {
                alunoAtualizado.setClube(null);  // Definindo como null se não há clube associado
            }

            // Salvando o aluno atualizado
            repository.save(alunoAtualizado);
            
            return ResponseEntity.ok(alunoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAluno(@PathVariable Integer id) {
    	repository.deleteById(id);
    	return ResponseEntity.noContent().build();
    }

    



}
