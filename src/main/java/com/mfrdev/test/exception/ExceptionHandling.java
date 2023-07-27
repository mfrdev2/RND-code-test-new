package com.mfrdev.test.exception;

import java.net.http.HttpConnectTimeoutException;

public class ExceptionHandling {


   static void  ex() {
       try {
           throw new  HttpConnectTimeoutException("connection failed");
       } catch (HttpConnectTimeoutException e) {
           throw new RuntimeException(e);
       }
   }
}
