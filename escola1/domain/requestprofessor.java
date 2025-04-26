package om.faculdade.escola1.domain;

public record requestprofessor(
    Integer prof_id,

    String prof_nome,
    float prof_salario,
    String prof_formacao, 
    String prof_endereco, 
    String prof_telefone,
    String prof_email,
    Integer prof_clu_id,
    String prof_rg) {



}