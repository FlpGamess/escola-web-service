package om.faculdade.escola1.domain;

import java.time.LocalTime;

public record requestclube(Integer clu_id,
String clu_nome,
LocalTime clu_horario,
Integer clu_infracao,
String clu_infra_desc,
char clu_estado,
float clu_verba,
String clu_sala,
Integer clu_id_presidente,
Integer clu_monitor) {

}
