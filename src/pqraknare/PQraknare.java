/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pqraknare;

import java.util.Scanner;

/**
 *
 * @author turha
 */
public class PQraknare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double katsayi,kuvvet;
        byte secenek;
        System.out.print("Değişkenin Katsayısını Giriniz: ");
        katsayi = scan.nextDouble();
        System.out.print("Değişkenin Kuvvetini Giriniz: ");
        kuvvet = scan.nextDouble();
         
        System.out.println("Türev için 1'e\nintegral için 2'ye basınız");
        secenek=scan.nextByte();
        if(secenek==1)
        {
            turev(katsayi,kuvvet);
        }
        else
        {
            integral(katsayi,kuvvet);
        }    
    }
     
    public static void turev(double katsayi, double kuvvet)
    {
        Scanner scan = new Scanner(System.in);
        double x0,fx0,x1,fx1,sonuc,h=0.00001;
        System.out.print("x=");
        x0 = scan.nextDouble();
         
        fx0=Math.pow(x0, kuvvet);
        fx0=fx0*katsayi;
        System.out.println("fx0 "+fx0);
        x1=x0+h;
        fx1=Math.pow(x1, kuvvet);
        fx1=fx1*katsayi;
        sonuc=(fx1-fx0)/(x1-x0);
        System.out.println("x="+x0+" noktasında, fonksiyonun yaklaşık olarak türevi: "+sonuc);
    }
    public static void integral(double katsayi, double kuvvet)
    {
        Scanner scan = new Scanner(System.in);
        double a,b,h,sonuc=0,x,F,F_ilk,F_son;
        System.out.print("integrali alınacak fonksiyonun ilk x noktasını belirleyiniz: ");
        a = scan.nextDouble();
        System.out.print("integrali alınacak fonksiyonun son x noktasını belirleyiniz: ");
        b = scan.nextDouble();
        //h=(b-a)/n;
         
        h=0.0001;
        for(x=a+h;x<=b;x+=h)
        {
            F=Math.pow(x, kuvvet);
            F=F*katsayi;
            sonuc=sonuc+F*h;
        }
        F_ilk=Math.pow(a, kuvvet);
        F_ilk=F_ilk*katsayi;
        F_son=Math.pow(b, kuvvet);
        F_son=F_son*katsayi;
        sonuc=sonuc+h/2*(F_ilk+F_son);
         
        System.out.println("x= "+a+" ve "+b+" aralığında, fonksiyonun yaklaşık olarak integrali: "+(int)sonuc);
    }
}
