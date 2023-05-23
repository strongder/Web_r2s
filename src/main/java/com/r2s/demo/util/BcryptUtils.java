//package com.r2s.demo.util;
//
//import org.mindrot.jbcrypt.BCrypt;
//
//public class BcryptUtils {
//    public static String encode(String password) {
//        return BCrypt.hashpw(password, BCrypt.gensalt());
//    }
//
//    public static boolean check(String rawPassword, String encodedPassword) {
//        return BCrypt.checkpw(rawPassword, encodedPassword);
//    }
//}
