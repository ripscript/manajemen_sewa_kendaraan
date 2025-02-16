/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

/**
 *
 * @author ripsc
 */
public class GlobalContext {
    // Variabel global
    private static int userId;

    // Getter dan Setter untuk userId
    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        GlobalContext.userId = userId;
    }
}
