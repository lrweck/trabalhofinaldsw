/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(columnDefinition = "text")
    private String nome;
    @Column(columnDefinition = "text")
    private String descricao;
    @Column(columnDefinition = "text")
    private String caminho_img;
    private float valor;
    @Column(columnDefinition = "text")
    private String dataInc;
    @Column(columnDefinition = "text")
    private String dataAtu;
    private byte funil;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminho_img() {
        return caminho_img;
    }

    public void setCaminho_img(String caminho_img) {
        this.caminho_img = caminho_img;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public byte getFunil() {
        return funil;
    }

    public void setFunil(byte funil) {
        this.funil = funil;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.ID);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.caminho_img);
        hash = 79 * hash + Float.floatToIntBits(this.valor);
        hash = 79 * hash + Objects.hashCode(this.dataInc);
        hash = 79 * hash + Objects.hashCode(this.dataAtu);
        hash = 79 * hash + this.funil;
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
        final Produto other = (Produto) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (this.funil != other.funil) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.caminho_img, other.caminho_img)) {
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
        return "Produto{" + "ID=" + ID + ", nome=" + nome + ", descricao=" + descricao + ", caminho_img=" + caminho_img + ", valor=" + valor + ", dataInc=" + dataInc + ", dataAtu=" + dataAtu + ", funil=" + funil + '}';
    }
}
