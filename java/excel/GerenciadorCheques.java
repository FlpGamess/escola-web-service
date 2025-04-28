package excel;
import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciadorCheques {

public List<Cheque> criar() throws IOException{
    List<Cheque> cheques = new ArrayList<>();
    //@Cleanup fecha o arquivo aos manipulação, define caminho do arquivo
    @Cleanup FileInputStream file = new FileInputStream("E:/dowloads/Characters_List.xlsx");
    //arquivo excel a ser aberto
    Workbook workbook =  new XSSFWorkbook(file);
    // planilha que vai começar a usar
    Sheet sheet = workbook.getSheetAt(0);

    //setando as linhas
    List<Row> rows = (List<Row>) toList(sheet.iterator());
    //remove os cabeçalhos
    rows.remove(0);
    rows.forEach(row ->{
        //Setando as celulas
        List<Cell> cells =(List<Cell>) toList(row.cellIterator());
        Cheque cheque = Cheque.builder()
                .name(String.valueOf(cells.get(0).getDateCellValue()))
                .lname(String.valueOf(cells.get(1).getDateCellValue()))
                .nname(String.valueOf(cells.get(2).getDateCellValue()))
                .age((int) cells.get(3).getNumericCellValue())
                .caotice(String.valueOf(cells.get(4).getDateCellValue()))
                .main_element(String.valueOf(cells.get(5).getDateCellValue()))
                .sub_element(String.valueOf(cells.get(6).getDateCellValue()))
                .classe(String.valueOf(cells.get(7).getDateCellValue()))
                .sub_class(String.valueOf(cells.get(8).getDateCellValue()))
                .organizacao(String.valueOf(cells.get(9).getDateCellValue()))
                .entry_date(String.valueOf(cells.get(10).getDateCellValue()))
                .campaing(String.valueOf(cells.get(11).getDateCellValue()))
                .status(String.valueOf(cells.get(12).getDateCellValue()))
                .player(String.valueOf(cells.get(13).getDateCellValue()))
                .build();

    });
    return cheques;
}

//retorna uma lista
public List<?> toList(Iterator<?> iterator){
    return IteratorUtils.toList(iterator);
}
    public void imprimir(List<Cheque> cheques){
    cheques.forEach(System.out::println);
    }
}
