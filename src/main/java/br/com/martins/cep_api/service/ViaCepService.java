/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.martins.cep_api.service;

import br.com.martins.cep_api.utils.WebService;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno Martins
 */
@Service
public class ViaCepService extends WebService {

    public String searchViaCep(String cep) throws Exception {

        String baseUrl = "https://viacep.com.br/ws/" + cep + "/json";

        return this.getClientService(baseUrl).request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
    }

}
