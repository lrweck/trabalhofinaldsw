package br.udesc.ceavi.dsw.projetorestjpa.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author luisr
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(columnDefinition = "text")
    private String nome;
    @Column(columnDefinition = "text")
    private String login;
    @Column(columnDefinition = "text")
    private String senha;
    @Column(columnDefinition = "text")
    private String email;
    @Column(columnDefinition = "text")
    private String telefone;
    @Column(columnDefinition = "text")
    private String dataInc;
    @Column(columnDefinition = "text")
    private String dataAtu;
    private byte funil;

    public Usuario() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataInc() {
        return dataInc;
    }

    public void setDataInc(String dataInc) {
        this.dataInc = dataInc;
    }

    public String getDataAtu() {
        return dataAtu;
    }

    public void setDataAtu(String dataAtu) {
        this.dataAtu = dataAtu;
    }

    public byte getFunil() {
        return funil;
    }

    public void setFunil(byte funil) {
        this.funil = funil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ID);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.login);
        hash = 23 * hash + Objects.hashCode(this.senha);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.telefone);
        hash = 23 * hash + Objects.hashCode(this.dataInc);
        hash = 23 * hash + Objects.hashCode(this.dataAtu);
        hash = 23 * hash + this.funil;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.funil != other.funil) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.dataInc, other.dataInc)) {
            return false;
        }
        if (!Objects.equals(this.dataAtu, other.dataAtu)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", email=" + email + ", telefone=" + telefone + ", dataInc=" + dataInc + ", dataAtu=" + dataAtu + ", funil=" + funil + '}';
    }
}