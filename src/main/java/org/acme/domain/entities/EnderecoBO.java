package org.acme.domain.entities;

public class EnderecoBO {
    
    private Long id;

    private PaisBO paisBO;

    private EstadoBO estadoBO;

    private CidadeBO cidadeBO;

    private String rua;

    private String numero;

    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaisBO getPaisBO() {
        return paisBO;
    }

    public void setPaisBO(PaisBO paisBO) {
        this.paisBO = paisBO;
    }

    public EstadoBO getEstadoBO() {
        return estadoBO;
    }

    public void setEstadoBO(EstadoBO estadoBO) {
        this.estadoBO = estadoBO;
    }

    public CidadeBO getCidadeBO() {
        return cidadeBO;
    }

    public void setCidadeBO(CidadeBO cidadeBO) {
        this.cidadeBO = cidadeBO;
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
