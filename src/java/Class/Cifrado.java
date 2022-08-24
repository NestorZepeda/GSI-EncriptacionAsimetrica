/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Scanner; 
import javax.crypto.Cipher;
import javax.xml.bind
    .DatatypeConverter;
/**
 *
 * @author Nestor
 */
public class Cifrado {
    
        private static final String RSA
        = "RSA";
    private static Scanner sc;
 
    // Generar las llaves privadas y publicas
    // usando el algoritmo RSA
    public static KeyPair generateRSAKkeyPair()
        throws Exception
    {
        SecureRandom secureRandom
            = new SecureRandom();
        KeyPairGenerator keyPairGenerator
            = KeyPairGenerator.getInstance(RSA);
 
        keyPairGenerator.initialize(
            2048, secureRandom);
        return keyPairGenerator
            .generateKeyPair();
    }
 
    // Funcion de encriptacion que convierte
    // el texto a cipherText
    // usando la llave privada.
    public static byte[] do_RSAEncryption(
        String plainText,
        PrivateKey privateKey)
        throws Exception
    {
        Cipher cipher
            = Cipher.getInstance(RSA);
 
        cipher.init(
            Cipher.ENCRYPT_MODE, privateKey);
 
        return cipher.doFinal(
            plainText.getBytes());
    }
 
    // Funcion para desencriptar
    // el cipher text de regreso a
    // texto original.
    public static String do_RSADecryption(
        byte[] cipherText,
        PublicKey publicKey)
        throws Exception
    {
        Cipher cipher
            = Cipher.getInstance(RSA);
 
        cipher.init(Cipher.DECRYPT_MODE,
                    publicKey);
        byte[] result
            = cipher.doFinal(cipherText);
 
        return new String(result);
    }}
 
    // Driver code
//    public static void main(String args[])
//        throws Exception
//    {
//        KeyPair keypair
//            = generateRSAKkeyPair();
// 
//        String plainText = "This is the PlainText "
//                           + "I want to Encrypt using RSA.";
// 
//        byte[] cipherText
//            = do_RSAEncryption(
//                plainText,
//                keypair.getPrivate());
// 
//        System.out.println(
//            "The Public Key is: "
//            + DatatypeConverter.printHexBinary(
//                  keypair.getPublic().getEncoded()));
// 
//        System.out.println(
//            "The Private Key is: "
//            + DatatypeConverter.printHexBinary(
//                  keypair.getPrivate().getEncoded()));
// 
//        System.out.print("The Encrypted Text is: ");
// 
//        System.out.println(
//            DatatypeConverter.printHexBinary(
//                cipherText));
// 
//        String decryptedText
//            = do_RSADecryption(
//                cipherText,
//                keypair.getPublic());
// 
//        System.out.println(
//            "The decrypted text is: "
//            + decryptedText);
//    }
//}
