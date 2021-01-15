package com.company;

import java.io.*;

public class Main  {

    public static void main(String[] args) {
        Foo foo = new Foo("Hai");
	    Test test = new Test(1,foo);
	    Test test1 = new Test(2,foo);
	    try (ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("myFile.dat"))){
	        file.writeObject(test);
	        file.writeObject(test1);
        } catch (IOException e){
	        e.printStackTrace();
        }

	    boolean eof = false;
	    try (ObjectInputStream file = new ObjectInputStream(new FileInputStream("myFile.dat"))){
            while (!eof){
                try {
                    Test test2 = (Test) file.readObject();
                    System.out.println(test2.getFoo());
                } catch (EOFException e){
                    eof = true;
                } catch (ClassNotFoundException ce){
                    System.out.println(ce.getMessage());
                }
            }
	    } catch (IOException e){
	        e.printStackTrace();
        }
    }
}
