package school.sptech;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Crud crud = new Crud();
        Cliente cliente = new Cliente( 1,"123456789", "Julia" );
        dadosMaquina dados = new dadosMaquina(looca, looca.getProcessador(),looca.getMemoria() );

        crud.deleteTableCliente();
        crud.createTableCliente();
        crud.insertTableCliente( cliente.getEmail(), cliente.getSenha() );
        crud.selectTableCliente();
    if (crud.getListaClientes().isEmpty()){
        System.out.println("Faça seu cadastro");
    }else{
        System.out.println( dados.getArmazenamentoTotal());

    }


    }
}