package com.example.demo.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "contaRecorrente")
public class ContaRecorrente extends Conta {
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "valorRecorrente")
    private BigDecimal valorRecorrente;

    @Column(name = "dataInicialCobrancaRecorrente")
    private Date dataInicialCobrancaRecorrente;

    @Column(name = "dataFinalCobrancaRecorrente")
    private Date dataFinalCobrancaRecorrente;

    @Column(name = "ativo")
    private Boolean ativo;

    public ContaRecorrente() {}

    public ContaRecorrente(Long id) {
        super();
        this.id = id;
    }

    public ContaRecorrente(BigDecimal valorRecorrente, Date dataInicialCobrancaRecorrente) {
        this.valorRecorrente = valorRecorrente;
        this.dataInicialCobrancaRecorrente = dataInicialCobrancaRecorrente;
        this.dataFinalCobrancaRecorrente = null;
        this.ativo = true;
    }

    public ContaRecorrente(Long id, BigDecimal valorRecorrente, Date dataInicialCobrancaRecorrente, Date dataFinalCobrancaRecorrente, Boolean ativo) {
        super(id);
        this.valorRecorrente = valorRecorrente;
        this.dataInicialCobrancaRecorrente = dataInicialCobrancaRecorrente;
        this.dataFinalCobrancaRecorrente = dataFinalCobrancaRecorrente;
        this.ativo = ativo;
    }

    public ContaRecorrente(String descricao, BigDecimal valor, Parcela[] parcelas, int totalDeParcelas, Boolean receber, BigDecimal valorRecorrente, Date dataInicialCobrancaRecorrente, Date dataFinalCobrancaRecorrente, Boolean ativo) {
        super(descricao, valor, parcelas, totalDeParcelas, receber);
        this.valorRecorrente = valorRecorrente;
        this.dataInicialCobrancaRecorrente = dataInicialCobrancaRecorrente;
        this.dataFinalCobrancaRecorrente = dataFinalCobrancaRecorrente;
        this.ativo = ativo;
    }

    @Override
    public Long getId() { return this.id; }

    @Override
    public void setId(Long id) { this.id = id; }

    public BigDecimal getValorRecorrente() { return this.valorRecorrente; }

    public void setValorRecorrente(BigDecimal valorRecorrente) { this.valorRecorrente = valorRecorrente; }

    public Date getDataInicialCobrancaRecorrente() { return this.dataInicialCobrancaRecorrente; }

    public void setDataInicialCobrancaRecorrente(Date dataInicialCobrancaRecorrente) { this.dataInicialCobrancaRecorrente = dataInicialCobrancaRecorrente; }

    public Date getDataFinalCobrancaRecorrente() { return this.dataFinalCobrancaRecorrente; }

    public void setDataFinalCobrancaRecorrente(Date dataFinalCobrancaRecorrente) { this.dataFinalCobrancaRecorrente = dataFinalCobrancaRecorrente; }

    @Override
    public Boolean getAtivo() { return this.ativo; }

    @Override
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
