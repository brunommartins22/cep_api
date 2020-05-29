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

        int errorCode = message.contains("400") ? 400 : message.contains("404") ? 404 : message.contains("503") ? 503 : 500;

        message = message.replace(errorCode + "-", "");

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

        hql.append("<h1><b>").append(errorCode == 400 ? "Bad Request" : errorCode == 404 ? "Not Found" : errorCode == 503 ? "Service Unavailable" : "Internal Server Error").append("</b></h1>");

        hql.append("<h2>:( Ops!</h2>");

        hql.append("<p style=\"padding:10px\"><b>Message: </b>").append(message).append("</p>");

        hql.append("<h2> Error - ").append(errorCode).append("</h2>");

        hql.append("</body>");

        hql.append("</html>");

        return hql.toString();
    }

}
