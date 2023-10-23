package school.sptech;

import com.github.britooo.looca.api.core.Looca;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Crud crud = new Crud();
        Cliente cliente = new Cliente( 1,"123456789", "Julia" );
        dadosMaquina dados = new dadosMaquina(looca);
        Scanner leitor = new Scanner( System.in );
        //crud.createTableCliente();
        System.out.println( """
                Olá, seja bem - vindo:
                    1) Login;
                    2) Cadrastrar;
                    3) Sair;
                """);
        int escolha = leitor.nextInt();
        switch (escolha){
            case 1:
               crud.login( cliente.getEmail(), cliente.getSenha() );
               if(crud.getListaClientes().isEmpty()){
                   System.out.println("Faça sua inscrição");
                   break;
               }else {
                   System.out.println( "Seja bem - vindo" );
                   System.out.println( "Armazenamento total: "+dados.getArmazenamentoTotal()*1000 + "Mb");
                   System.out.println("CPU: " + dados.getCpu());
                   System.out.println("RAM: "+dados.getRam());
                   System.out.println("Interfaces: "+dados.getInterfaces());
                   System.out.println("Poncentagem de uso (CPU): " + dados.getPorcentagemUsoCpu());
                   System.out.println("Poncentagem de uso (RAM): "+dados.getPorcentagemUsoRam());
                   System.out.println("Processos " + dados.getProcessos() );

               }
                break;
            case 2:
                crud.insertTableCliente( cliente.getEmail(), cliente.getSenha() );
                break;
                case 3:
                    System.out.println("ADEUS");

            default:
                System.out.println("Opção inválida");
                break;
        }

    }
}