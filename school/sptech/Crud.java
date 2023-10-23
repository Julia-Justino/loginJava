package school.sptech;

import Livraria_SPTECH.Conexao;
import Livraria_SPTECH.Livro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Crud {
    private List<Cliente>listaClientes = new ArrayList<>();
    Livraria_SPTECH.Conexao conexao = new Conexao();

    JdbcTemplate con = conexao.getConexaoBanco();
    public void deleteTableCliente (){
        con.execute("""
                DROP TABLE IF EXISTS tbCliente;
            """ );
        System.out.println("Deletado com sucesso");
    }
    public void createTableCliente(){
        con.execute( """
                CREATE TABLE tbCliente(
                    idCliente INT PRIMARY KEY AUTO_INCREMENT,
                    email VARCHAR(85),
                    senha VARCHAR(85)
                );
                """ );
        System.out.println("Tabela criada com sucesso");
    }

    public  void  insertTableCliente(String email, String senha){
        con.update( """
                INSERT INTO tbCliente (email, senha) VALUES(?,?);
                """ , email, senha);
        System.out.println("Inserido com sucesso");
    }
    public void selectTableCliente (){
        List<Cliente> ClienteBanco = con.query( """
           SELECT * FROM tbCliente
           """ , new BeanPropertyRowMapper<>(Cliente.class) );
        System.out.println(ClienteBanco);


    }
    private   String nomeBusca;
    public void login(String email, String senha){
        //nomeBusca = String.format( "%%%s%%", busca  );
        List<Cliente> buscaLogin = con.query( "SELECT * FROM tbCliente WHERE email = ? and senha = ?",
                new BeanPropertyRowMapper<>(Cliente.class), email, senha);
        System.out.println(buscaLogin);
        listaClientes = buscaLogin;
    }


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
