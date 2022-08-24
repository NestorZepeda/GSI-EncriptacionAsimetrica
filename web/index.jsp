<%-- 
    Document   : index
    Created on : 08-24-2022, 05:16:45 PM
    Author     : Nestor
--%>

<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="java.security.KeyPair"%>
<%@page import="Class.Cifrado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>GSI-24-08-2022</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Cifrado Asimetrico con JAVA</h1></div>
        <br>
        
        <form method="POST">
             <div >
                <label >Ingrese texto a cifrar</label>
                <input type="text" name="texto" placeholder="texto a cifrar" required="true">
             </div>
            <br>
                 <input type="submit" name="ok" value="Confirmar">
        </form>
        <form method="POST">
            <% 
                if (request.getParameter("ok")!=null) 
                {
                    
                Cifrado c = new Cifrado();

                    KeyPair keypair= c.generateRSAKkeyPair();

                   String plainText = request.getParameter("texto");

                   byte[] cipherText
                       = c.do_RSAEncryption(
                           plainText,
                           keypair.getPrivate());
                   out.print("<br>");
                   out.print("<div>");
                   out.print(
                       "La llave publica es: "
                       + DatatypeConverter.printHexBinary(
                             keypair.getPublic().getEncoded()));
                   out.print("<br>");
                   out.print("<br>");
                   out.print(
                       "La llave privada es: "
                       + DatatypeConverter.printHexBinary(
                             keypair.getPrivate().getEncoded()));
                  out.print("<br>");
                  out.print("<br>");

                   out.print("El texto encriptado es: ");

                   out.println(
                       DatatypeConverter.printHexBinary(
                           cipherText));
                   out.print("<br>");
                   out.print("<br>");

                   String decryptedText
                       = c.do_RSADecryption(
                           cipherText,
                           keypair.getPublic());

                   out.println( "El texto desencriptado es: "
                       + decryptedText+"<br>");
                      out.print("</div>");
                      out.print("<br>");
                      out.print("<input type='submit' name='ok2' value='Limpiar pantalla'>");
                }
            %>
            
        </form>
    </body>
</html>
