package excel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cheque {
    private String name;
    private String lname;
    private String nname;
    private Integer age;
    private String caotice;
    private String main_element;
    private String sub_element;
    private String rank;
    private String classe;
    private String sub_class;
    private String organizacao;
    private String entry_date;
    private String campaing;
    private String status;
    private String player;
}
