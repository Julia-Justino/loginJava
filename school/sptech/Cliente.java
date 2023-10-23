package school.sptech;

import java.util.Objects;

public class Cliente {

    private Integer idCliente;
    private String senha;
    private String email;
    private Crud c;

    public Cliente(Integer idCliente, String senha, String email) {
        this.idCliente = idCliente;
        this.senha = senha;
        this.email = email;
    }

    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Crud getC() {
        return c;
    }

    public void setC(Crud c) {
        this.c = c;
    }

    public void cadastrarCliente(String email, String senha){
        if (Objects.nonNull( email )&&Objects.nonNull( senha )) {
            getC().insertTableCliente( email, senha );
        }
    }
    public void loginCliente(String email, String senha){
       if (!c.getListaClientes().isEmpty()){
           if (Objects.nonNull( email )&&Objects.nonNull( senha )){
               getC().login( email, senha );
           }
       }else{
           System.out.println("Faça seu cadastro");
           cadastrarCliente( email, senha );
       }
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "idCliente=" + idCliente +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}