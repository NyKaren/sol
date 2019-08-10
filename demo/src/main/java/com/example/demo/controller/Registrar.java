package com.example.demo.controller;

import com.example.demo.model.Conta;
import com.example.demo.model.Parcela;
import com.example.demo.service.RegistrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registrar")
public class Registrar {

    private RegistrarService registrarService;

    public Registrar(@Autowired RegistrarService service) {
        this.registrarService = service;
    }


    @RequestMapping(path = "/conta", method = RequestMethod.GET)
    //vai fazer a requisição para retornar dados
    //se void, pede, mas não retorna nada pq é void.
    //se fosse POST, retornava 200
    public Conta conta() {
        // String descricao, BigDecimal valor, int totalDeParcelas, Boolean receber
        return new Conta("João", new BigDecimal(10000), 4, true);
    }

    //Síncrono é ao mesmo tempo
    //Assíncrono aguarda e depois starta. Abre mais um processo thread. Envio de e-mail. Técnicas front
    @GetMapping(path = "/contas")
    public List<Conta> contas() {
        List<Conta> contas = new ArrayList<>();
        List<Parcela> parcelas = new ArrayList<>();
        contas.add(new Conta("João", new BigDecimal(10000),
                parcelas.add(10/04/1991, 13/04/1991),
                1, true));
        contas.add(new Conta("Karen", new BigDecimal(15000)));

        return contas;
    }

    @GetMapping(path = "/conta/{aa}")
    public List<Conta> getContaById(@PathVariable("aa") String descricao) {
        List<Conta> contas = new ArrayList<Conta>();

        contas.add(new Conta("João", new BigDecimal(10000)));
        contas.add(new Conta("Karen", new BigDecimal(15000)));
        contas.add(new Conta("Unifacs", new BigDecimal(10000)));

        return contas.stream().filter(c -> c.getDescricao().equals(descricao)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/conta/request", method = RequestMethod.POST)
    public Conta inserirConta1(@RequestBody Conta conta) {
        return conta;
    }

    @PostMapping(path = "/conta")
    public Conta inserirConta(@RequestBody Conta conta) {
        return conta;
    }

    //Postman gera padrão http
    /*
    {
    {
        "descricao" = "Unifacs",
        "valor" = 10000
    }
    }
    * */

    @PutMapping(path = "/conta")
    public Conta atualizarConta(@RequestBody Conta conta) {
        return conta;
    }

    @DeleteMapping(path = "/conta/{descricao}")
    public List<Conta> atualizarConta(@PathVariable("descricao") String descricao) {
        List<Conta> contas = new ArrayList<Conta>();

        contas.add(new Conta("João", new BigDecimal(10000)));
        contas.add(new Conta("Karen", new BigDecimal(15000)));
        contas.add(new Conta("Unifacs", new BigDecimal(10000)));

        List<Conta> retorno = contas.parallelStream().filter(c -> !c.getDescricao().equals(descricao)).collect(Collectors.toList());
        return retorno;
    }

    @DeleteMapping(path = "/conta/{remover}")
    public ResponseEntity<String> removeConta(@PathVariable("id") long id) {
        System.out.println("Conta número "+ id + "deletada.");

        registrarService.deleteById(id);

        return new ResponseEntity<>("Conta foi removida!", HttpStatus.OK);
    }

    // http://localhost:8080/api/receber/conta/Karen
    /*
    * create table aReceber {
    * id int auto_increment,
    * descricao varchar(100),
    * valor decimal(17,2)}
    * */
}
