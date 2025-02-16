/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;
import com.example.GlobalContext;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.utils.CustomResult;
import com.example.utils.Hash;

/**
 *
 * @author ripsc
 */
public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        
        if (user != null) {
            if (Hash.verifyPassword(password, user.getPassword())) {
                return user;
            }
        }
            
        return null;
    }
    
    public User loginPelanggan(String username, String password) {
        User user = userRepository.findByUsername(username);
        
        if (user != null) {
            if (Hash.verifyPassword(password, user.getPassword())) {
                return user;
            }
        }
            
        return null;
    }
    
    public CustomResult createUser(User user) {
        User getUser = userRepository.getByNIK(user.getNik());
        if (getUser != null) {
            return new CustomResult(false, "NIK Sudah Terdaftar", null);
        }
        
        User createUser = userRepository.createUser(user);
        GlobalContext.setUserId(createUser.getId());
        
        if (createUser != null) {
            return new CustomResult(true, "Registrasi Berhasil", null);
        } else {
            return new CustomResult(false, "Registrasi Gagal", null);
        }
    }
}
