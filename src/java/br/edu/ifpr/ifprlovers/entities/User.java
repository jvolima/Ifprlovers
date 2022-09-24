/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.ifprlovers.entities;

/**
 *
 * @author jvolima
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String sexualOrientation;
    private int age;
    private String imageType;
    private byte[] image;

    public User(String name, String email, String password, String gender, 
            String sexualOrientation, int age, String imageType, byte[] image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.age = age;
        this.imageType = imageType;
        this.image = image;
    }
    
    
    
    
    
    
    
    
    public User(int id, String name, String email, String password, String gender, String sexualOrientation, int age, String image_url) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.age = age;
    }
    
    public User(int id, String name, String email, String gender, String sexualOrientation, int age, String image_url) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.age = age;
    }
    
    public User(String name, String email, String password, String gender, String sexualOrientation, int age, String image_url) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.age = age;
    }
    
    public User(int id, String name, String email, String password, String gender, String sexualOrientation, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.age = age;
    }
    
    public User(int id, String name, String email, String gender, String sexualOrientation, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.age = age;
    }
     
    public User(String name, String email, String password, String gender, String sexualOrientation, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
    
    
}
