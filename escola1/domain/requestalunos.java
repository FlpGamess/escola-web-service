package om.faculdade.escola1.domain;

public record requestalunos(
		Integer alu_id,
		String alu_rg,
		String alu_nome,
		Integer alu_idade,
		String alu_turma,
		String alu_endereco, 
		char alu_sexo, 
		String alu_responsavel,
		String alu_telefone,
		String alu_tel_responsavel,
		String alu_email,
		Integer alu_clu_id) {
	
	

}
