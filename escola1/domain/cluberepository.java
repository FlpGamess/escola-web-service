package om.faculdade.escola1.domain;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import om.faculdade.escola1.dto.countalunosporclube;
import om.faculdade.escola1.dto.countmonitores;
import om.faculdade.escola1.dto.sumverbat;



public interface cluberepository extends JpaRepository<clube, Integer> {
	
	 @Query(value = "SELECT clube.clu_monitor AS clu_monitor, " +
      		"COALESCE(professor.prof_nome, 'Sem Monitor') AS prof_nome, " +
      		"COUNT(*) AS clubes_adm " +
      		"FROM clube " +
      		"LEFT JOIN professor ON clube.clu_monitor = professor.prof_id " +
      		"GROUP BY clube.clu_monitor, professor.prof_nome;", nativeQuery = true)
	 		List<countmonitores> totais();
	 		
	 		
	 @Query(value = "SELECT SUM(clube.clu_verba) AS vtotal "+
			 "FROM clube;", nativeQuery = true)
	 		List<sumverbat> verbat();
	 		
	 @Query(value = "SELECT clu_nome as nome_clube,COUNT(alu_id) as quantidade_alunos "+
	 		"FROM clube "+
			"LEFT JOIN alunos on clu_id = alu_clu_id "+
	 		"GROUP BY clu_nome;", nativeQuery = true)
	 List<countalunosporclube> ContarAlunos();




}
