package com.mfrdev.test.a2i;

import java.math.BigInteger;
import java.util.UUID;

public class Ref {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);


        System.out.println(getUUIDNumber());

        double amount  = 0.0d ;
        double adjustedAmount = 0;
        double creditAmount = Math.abs(amount - adjustedAmount);
        System.out.println("CR:: "+creditAmount);
        System.out.println(amount==adjustedAmount);

    }

    private static Long getUUIDNumber() {
        final String lUUID = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
        final String substring = lUUID.substring(0, 8);
        return Long.valueOf(substring);
    }
}
