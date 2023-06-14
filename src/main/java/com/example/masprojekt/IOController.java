package com.example.masprojekt;


import java.io.*;

public class IOController {
    public static Object loadObjectFromFile(String file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return obj;
        } catch (FileNotFoundException | EOFException e) {
            System.out.println("File not found or empty.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void saveDataToFile(Object object, String file){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
