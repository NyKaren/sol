package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "conta")
public class Conta {
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valorTotal")
    private BigDecimal valorTotal;

    @Column(name = "quitada")
    private Boolean quitada;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "parcelas")
    private List<Parcela> parcelas;

    @Column(name = "totalDeParcelas")
    private int totalDeParcelas;

    @Column(name = "receber")
    private Boolean receber; //true = aReceber && false = aPagar

    @Column(name = "saldo")
    private BigDecimal saldo;

    public Conta() {}

    public Conta(Long id) {
        super();
        this.id = id;
    }

    public Conta(String descricao, BigDecimal valorTotal, int totalDeParcelas, Boolean receber, Date dataCobranca) {
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.totalDeParcelas = totalDeParcelas;
        this.receber = receber;
        this.saldo = valorTotal;
        this.quitada = false;
        this.ativo = true;
        parcelas = new List<>();
        BigDecimal valor1 = BigDecimal.valueOf(valorTotal)/totalDeParcelas;

        BigDecimal valorParcela = BigDecimal.valueOf(valorTotal)/totalDeParcelas;
        for (int i = 0; i < totalDeParcelas; i++) {
            //parcelas.add(setParcelas(dataCobranca, valorParcela));
            parcelas.set(i, (dataCobranca, valorParcela));
        }
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public Boolean getQuitada() { return this.quitada; }

    public void setQuitada(Boolean quitada) { this.quitada = quitada; }

    public Boolean getAtivo() { return this.ativo; }

    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public int getTotalDeParcelas() { return this.totalDeParcelas; }

    public void setTotalDeParcelas(int totalDeParcelas) { this.totalDeParcelas = totalDeParcelas; }

    public Boolean getReceber() { return this.receber; }

    public void setReceber(Boolean receber) { this.receber = receber;}

    public BigDecimal getSaldo() { return this.saldo; }

    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public List<Parcela> getParcelas() { return this.parcelas; }

    public void setParcelas(List<Parcela> parcelas) { this.parcelas = parcelas; }
}
