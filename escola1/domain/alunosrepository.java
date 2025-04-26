package om.faculdade.escola1.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import om.faculdade.escola1.dto.countalunosemclube;
import om.faculdade.escola1.dto.countidades;


public interface alunosrepository extends JpaRepository<alunos, Integer> {

	 @Query(value = "SELECT alunos.alu_idade, COUNT(*) AS total_idades "+
			 "FROM alunos "+
			 "GROUP BY alunos.alu_idade;", nativeQuery = true)
	 		List<countidades> contaridades();

	 @Query(value = "SELECT CASE WHEN alunos.alu_clu_id IS NOT NULL THEN 'Em Clube' ELSE 'Não em Clube' END AS status, COUNT(*) AS n_alunos "+
	 		"FROM alunos "+
	 		"GROUP BY status;", nativeQuery = true)
	 		List<countalunosemclube> contaraluemclub();
}
