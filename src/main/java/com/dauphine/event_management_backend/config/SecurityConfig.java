package com.dauphine.event_management_backend.config;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityConfig {
    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword){
        return BCrypt.checkpw(password,hashedPassword);
    }
}
