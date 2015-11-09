/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author cleverton
 */
public class Util {
    
    public static String md5(String input) throws NoSuchAlgorithmException{
        String result = input;
        
        if(input != null){
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            result = hash.toString(16);
            while(result.length() < 32)
                result = "0" + result;
        }
    
        return result;
    }
}
