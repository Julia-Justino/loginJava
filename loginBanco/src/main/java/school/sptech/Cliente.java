package school.sptech;

public class Cliente {

    private Integer idCliente;
    private String senha;
    private String email;

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