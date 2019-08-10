package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "parcela")
public class Parcela {
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "valorParcela")
    private BigDecimal valorParcela;

    @Column(name = "dataCobranca")
    private Date dataCobranca;

    @Column(name = "dataPagamento")
    private Date dataPagamento;

    @Column(name = "quitada")
    private Boolean quitada;

    @Column(name = "ativo")
    private Boolean ativo;

    public Parcela() {}

    public Parcela(Long id) {
        super();
        this.id = id;
    }

    public Parcela(Date dataCobranca, BigDecimal valorParcela) {
        super();
        this.dataCobranca = dataCobranca;
        this.valorParcela = valorParcela;
        this.dataPagamento = null;
        this.quitada = false;
        this.ativo = true;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public Date getDataCobranca() { return this.dataCobranca; }

    public void setDataCobranca(Date dataCobranca) { this.dataCobranca = dataCobranca; }

    public Date getDataPagamento() { return this.dataPagamento; }

    public void setDataPagamento(Date dataPagamento) { this.dataPagamento = dataPagamento; }

    public Boolean getQuitada() { return this.quitada; }

    public void setQuitada(Boolean quitada) { this.quitada = quitada; }

    public Boolean getAtivo() { return this.ativo; }

    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public BigDecimal getValorParcela() { return this.valorParcela; }

    public void setValorParcela(BigDecimal valorParcela) { this.valorParcela = valorParcela; }
}
