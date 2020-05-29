/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.martins.cep_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno Martins
 */
@RestController
@RequestMapping(path = "api/datas")
public class DataController {

    @GetMapping("/namoro/{data}")
    public String validationData(@PathVariable String data) {

        StringBuilder hql = new StringBuilder();

        hql.append("<!DOCTYPE html>");

        hql.append("<html>");

        hql.append("<head>");

        hql.append("<title>Leticia <3</title>");

        hql.append("<meta charset=\"utf-8\">");

        hql.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");

        hql.append("<link rel=\"stylesheet\" href=\"path/to/font-awesome/css/font-awesome.min.css\">");

        hql.append("</head>");

        hql.append("<body>");

        hql.append("<center>");

        if (data.equals("12072019")) {

            hql.append("<h1 style=\"color:gray\"><b>").append("Você lembrou! <3 </i>").append("</b></h1>");

            hql.append("<h2 style=\"color:gray\"> Não sabe o quanto está data é extremamente importante para mim. </h2>");

            hql.append("<p style=\"text-align:justify !important\"> <b>Bom vamos lá deixa eu te explicar o motivo:</> </br></br>");

            hql.append("Neste dia, tive a certeza mais profunda da minha vida que iria pedir a pessoa que mostrou em mim um lado mais humano e maduro em namoro. "
                    + "Ah e não é so isso, essa hitoria já é muio antiga. Mas graças a Deus que nos encontramos mais maduros e com pensamentos identicos, onde conseguimos "
                    + "nos fortalecer a cada dia em busca de um só objetivo. Mas, deixa quieto pq que paredes tem ouvidos, Ops! Codigos de computadores tem ouvidos hahahaha... </p>");

            hql.append("<h2> * Só nao esquece de uma coisa *</h2>");

//            hql.append("<img src=\"./Capturar.PNG\" alt=\"Minha Figura\">	");
            hql.append("<marquee direction=\"down\" width=\"100%\" height=\"200\" behavior=\"alternate\" style=\"border:solid\">\n"
                    + "  <marquee behavior=\"alternate\">\n"
                    + "    <i style=\"color:RED \">EU TE AMO LETÍCIA</i>!\n"
                    + "  </marquee>\n"
                    + "</marquee>");

        } else {

            hql.append("<h1 style=\"color:gray\"><b>").append("* QUE DECEPÇÃO EM * </3 </i>").append("</b></h1>");

            hql.append("<marquee direction=\"down\" width=\"100%\" height=\"200\" behavior=\"alternate\" style=\"border:solid\">\n"
                    + "  <marquee behavior=\"alternate\">\n"
                    + "    <i style=\"color:RED \">MESMO ASSIM EU AINDA TE AMO LETÍCIA, TENTA DE NOVO!</i>\n"
                    + "  </marquee>\n"
                    + "</marquee>");

        }

        hql.append("<h1>Que a força esteja com a gente © !</h1>");

        hql.append("</center>");

        hql.append("</body>");

        hql.append("</html>");

        return hql.toString();

    }

}
