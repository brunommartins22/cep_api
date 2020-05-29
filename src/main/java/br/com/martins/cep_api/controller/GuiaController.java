/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.martins.cep_api.controller;

import br.com.martins.cep_api.exception.GuiaException;
import br.com.martins.cep_api.service.GuiaService;
import br.com.martins.cep_api.utils.IsServiceDefault;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno Martins
 */
@RestController
@RequestMapping(path = "api/guias")
public class GuiaController {

    //********************** inject service in controller **********************
    @Autowired
    @IsServiceDefault
    private GuiaService service;

    //*************************** endpoint *************************************
    @GetMapping("/numero/{numero}")
    public ResponseEntity<String> updateGuiaByPago(@PathVariable BigDecimal numero) {

        boolean resp = this.service.updateGuiaByPago(numero);

        if (!resp) {

            throw new GuiaException("500-Entre em contato com o suporte do serviço!");

        }

        StringBuilder hql = new StringBuilder();

        hql.append("<html>");

        hql.append("<h1><b>").append("Operação realizada com sucesso").append("!</b></h1>");

        hql.append("<p> { </p>");

        hql.append("<p style=\"padding:10px\"><b>'Nº GUIA' :</b> ").append(numero).append("</p>");

        hql.append("<p style=\"padding:10px\"><b>'STATUS' :</b> ").append("'PAGA'").append("</p>");

        hql.append("<p> } </p>");
        
         hql.append("<h2> Code ").append("200").append(" - success</h2>");

        hql.append("</html>");

//                result = "Guia de Nº "+numero+", foi paga! \r\nOperação realizada com sucesso!";
        return ResponseEntity.ok(hql.toString());

    }

    @ExceptionHandler({GuiaException.class})
    public ResponseEntity<Object> handlePessoaInexistenteOrInativaException(GuiaException ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());

    }

}
