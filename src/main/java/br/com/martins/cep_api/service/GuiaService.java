/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.martins.cep_api.service;

import br.com.martins.cep_api.exception.GuiaException;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 *
 * @author Bruno Martins
 */
@Service
public class GuiaService {

    @PersistenceContext(name = "default")
    private EntityManager em;

    @Transactional
    public boolean updateGuiaByPago(BigDecimal numero) {

        if (StringUtils.isEmpty(numero)) {

            throw new GuiaException("400-Informe um numero para realização a transação!");

        }

        if (numero.toString().length() > 17 || numero.toString().length() < 17) {

            throw new GuiaException("400-Informe um numero válido com um total de 17 dígitos!");

        }

        //********************* VALIDATION **********************
        StringBuilder hql = new StringBuilder("SELECT 1 as exist FROM nfsd.fc_guia");

        hql.append(" WHERE nu_guia = :numero");

        Query query = this.em.createNativeQuery(hql.toString());

        query.setParameter("numero", numero);

        int resp = 0;
        
        if (!query.getResultList().isEmpty()) {

            //********************* UPDATE **************************
            hql = new StringBuilder("UPDATE nfsd.fc_guia");

            hql.append(" SET dt_pagamento = now(), en_situacao = 'PAGA'");

            hql.append(" WHERE nu_guia = :numero ;");

            query = this.em.createNativeQuery(hql.toString());

            query.setParameter("numero", numero);

            resp = query.executeUpdate();

        }else{
            
            throw new GuiaException("404-Número da guia não registrado na base de dados!");
            
        }

        return resp == 1;

    }

}
