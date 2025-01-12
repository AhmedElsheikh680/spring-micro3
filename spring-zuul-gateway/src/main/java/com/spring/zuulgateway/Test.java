package com.spring.zuulgateway;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Test {

    public static void main(String[] args) {

//    String message ="B2tEHdMFjrnIolU7egHdIPYCOhaUqk1n23623623623423B2tEHdMFjrnIolU7egHdIPYCOhaUqk1n";
//        System.out.println(getSignature(message));
        // النص الذي أرسلته البروفايدر
//        String inputDateTime = "2024-12-22 05:12:08.0260956"; // الصيغة الواردة
//
//        // تحويل النص إلى كائن LocalDateTime
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS");
//        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTime, inputFormatter);
//
//        // تحويل كائن LocalDateTime إلى النص المطلوب
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ");
//        String formattedDateTime = localDateTime.format(outputFormatter);
//
//        System.out.println("Formatted DateTime: " + formattedDateTime);
        String formattedAmount=String.format("%.2f", 27500.0);
        System.out.println(formattedAmount);
    }

//    public static String getSignature(String input) {
//        try {
//            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//            messageDigest.update(input.getBytes(StandardCharsets.UTF_8));
////            return Base64.getEncoder().encodeToString(messageDigest.digest());
//            byte[] hashBytes = messageDigest.digest();
//            System.out.println("byte[] hashBytes "+ hashBytes);
//            StringBuilder hexString  = new StringBuilder();
//            for (byte b: hashBytes) {
//                String hex = Integer.toHexString(0xff & b);
//                System.out.println("String hex "+ hex);
//                if(hex.length() == 1) hexString.append('0');
//                hexString.append(hex);
//            }
//            return hexString.toString();
//
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
