package school.sptech;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class Conexao {
    private JdbcTemplate conexaoBanco;
    public Conexao(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:./banco_login");
        dataSource.setUsername("sa");
        dataSource.setPassword("");


        conexaoBanco = new JdbcTemplate(dataSource);
    }


    public JdbcTemplate getConexaoBanco() {
        return conexaoBanco;
    }
}