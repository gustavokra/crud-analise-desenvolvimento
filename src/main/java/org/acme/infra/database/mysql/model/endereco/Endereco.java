package org.acme.infra.database.mysql.model.endereco;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Table;

@Table(name = "endereco")
public class Endereco extends PanacheEntity{
    
    private Cidade cidade;

    private Estado estado;

    private Pais pais;

    private String rua;

    private String numero;

    private boolean ativo;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
