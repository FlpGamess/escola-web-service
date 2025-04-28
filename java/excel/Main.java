package excel;

import java.io.IOException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
       //instancia do gerenciador
        GerenciadorCheques gerenciadorCheques = new GerenciadorCheques();
       List<Cheque> cheques = gerenciadorCheques.criar();
        gerenciadorCheques.imprimir(cheques);
    }


}
