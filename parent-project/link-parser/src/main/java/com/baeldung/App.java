package com.baeldung;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ссылку: ");
        String URL = sc.nextLine();
        BLParser linkParser = new BLParser(URL);
        System.out.println(linkParser.getData());
    }
}
