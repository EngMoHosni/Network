package com.company;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HTML_file {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter a Url:");
        String url = scanner.nextLine();
        accessWebsite(url);
    }
    private static void accessWebsite (String url ){
        BufferedReader br = null ;
        try {
            URL myURL =new URL(url);
            URLConnection urlConnection = myURL.openConnection();
            InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
            br= new BufferedReader(isr);
            String line;
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("Url.html"));
            while((line =br.readLine()) !=null ){
                outputStream.writeUTF(line);
                System.out.println(line);
            }



        } catch (IOException e) {
            System.out.println("Cannot access URL");
            System.exit(1);
        } finally{
            System.out.println("Closing connection");
            try {
                br.close();
                System.exit(1);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
