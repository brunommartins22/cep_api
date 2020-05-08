/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.martins.cep_api.controller;

import br.com.martins.cep_api.service.ViaCepService;
import br.com.martins.cep_api.utils.IsServiceDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno Martins
 */
@RestController
@RequestMapping(path = "api/ceps")
public class ViaCepController {

    //********************** inject service in controller **********************
    @IsServiceDefault
    @Autowired
    private ViaCepService service;

    @GetMapping(path = "/{cep:.+}")
    public String loadViaCep(@PathVariable String cep) {
        try {

            return this.service.searchViaCep(cep);

        } catch (Exception e) {

            return "{ \"erro\": true }";
        }
    }

}
