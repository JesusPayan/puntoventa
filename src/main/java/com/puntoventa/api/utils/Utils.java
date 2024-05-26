package com.puntoventa.api.utils;

import java.util.Base64;
import java.util.Random;

public class Utils {

    public String generatePassword(String pass){
        String encodePassword;
        encodePassword = Base64.getEncoder().encodeToString(pass.getBytes());
        System.out.println("Contraseña original: " +  pass);
        System.out.println("Contraseña cifrada: " + encodePassword);
        return encodePassword;
    }
    public String decodePasswor(byte []encodePassword){
        byte[] decodedBytes = Base64.getDecoder().decode(encodePassword);
        return new String(decodedBytes);
    }
    public String generateUUID(String name,String lastname){
        Random random = new Random();
        return name.substring(0,3)+lastname.substring(0,3)+random.nextInt(3);
    }
}
