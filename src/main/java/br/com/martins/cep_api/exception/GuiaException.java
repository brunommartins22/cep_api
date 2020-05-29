/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.martins.cep_api.exception;

/**
 *
 * @author Bruno Martins
 */
public class GuiaException extends RuntimeException {

    public GuiaException(String message) {

        super(refactorMessage(message));

    }

    private static String refactorMessage(String message) {

        int errorCode = message.contains("400") ? 400 : message.contains("404") ? 404 : 500;

        message = message.replace(errorCode + "-", "");

        StringBuilder hql = new StringBuilder();

        hql.append("<html>");

        hql.append("<h1><b>").append(errorCode == 400 ? "Bad Request" : errorCode == 404 ? "Not Found" : "Internal Server Error").append("!</b></h1>");

        hql.append("<p style=\"padding:10px\"><b>Message: </b>").append(message).append("</p>");

        hql.append("<h2> Error ").append(errorCode).append("</h2>");

        hql.append("</html>");

        return hql.toString();
    }

}
