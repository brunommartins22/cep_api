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
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/numero/{tipo}/{numero}")
    public ResponseEntity<String> updateGuiaByPago(@PathVariable String tipo, @PathVariable BigDecimal numero) {

        try {

            this.service.updateGuiaByPago((tipo.equalsIgnoreCase("NOTA_FISCAL")), numero);

            StringBuilder hql = new StringBuilder();

            hql.append("<html lang=\"pt-br\">");

            hql.append("<head>");

            hql.append("<title>Desenvolve Cidade ©</title>");

            hql.append("<meta charset=\"utf-8\">");

            hql.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");

            hql.append("<style type=\"text/css\">");

            hql.append("      h1 {\n"
                    + "          color: #666;\n"
                    + "          text-align: center;\n"
                    + "          font-size: 4em;\n"
                    + "      }\n"
                    + "      h2, h3 {\n"
                    + "          color: #777;\n"
                    + "          text-align: center;\n"
                    + "          font-size: 3em;\n"
                    + "      }\n"
                    + "      h3 {\n"
                    + "          font-size: 1.5em;\n"
                    + "      }\n"
                    + "      p{\n"
                    + "          color: #777;\n"
                    + "          text-align: center;\n"
                    + "          font-size: 1.3em;\n"
                    + "      }");

            hql.append("</style>");

            hql.append("</head>");

            hql.append("<body>");

            hql.append("<h1><b>").append(":) Successful Operation").append("!</b></h1>");

            hql.append("<p style=\"padding:10px\"><b>Nº GUIA :</b> ").append(numero).append("</p>");

            hql.append("<p style=\"padding:10px\"><b>STATUS :</b> ").append("PAGA").append("</p>");

            hql.append("<h2> Code ").append(" - 202").append("</h2>");

            hql.append("</body>");

            hql.append("</html>");

            return ResponseEntity.ok(hql.toString());

        } catch (SQLException ex) {

            throw new GuiaException("500-Entre em contato com o suporte do serviço!");

        }

    }

    @ExceptionHandler({GuiaException.class})
    public ResponseEntity<Object> handlePessoaInexistenteOrInativaException(GuiaException ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());

    }

}
