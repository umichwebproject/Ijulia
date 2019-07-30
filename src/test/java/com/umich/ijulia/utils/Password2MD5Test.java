package com.umich.ijulia.utils;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class Password2MD5Test {

    Password2MD5 password2MD5 = new Password2MD5();
    @Test
    public void md5() throws NoSuchAlgorithmException {
        System.out.println(password2MD5.md5("sdjifosajdfo").length());
    }
}