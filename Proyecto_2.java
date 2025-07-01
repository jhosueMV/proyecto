/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Proyecto_2 {

   
        
    public static void main(String[] args) {
        //variables 
        String nombres, mensajeaprueba;
        boolean verificacion;
        String r, cantidadnotas, cantestudiantes;
        Scanner scan = new Scanner(System.in);
        int cantestudiantes2, cantnotas2, cE, cN;
        float acu, promedio2;
        //Areglos dinamicos
        ArrayList<String> estudiantes = new ArrayList<>();
       
        ArrayList<Float> promedios = new ArrayList<>();
        ArrayList<ArrayList<Float>> todasLasNotas = new ArrayList<>();
        //do-while para  repetir preguntando al usuario
        do {
            //control de la cantidad de alumnos para solo ingresar numeros y mayores a cero

            do {

                System.out.println("Cuantos estudiantes son:");
                cantestudiantes = scan.nextLine();
                verificacion = cantestudiantes.matches("\\d+");

                if (verificacion) {

                    cE = Integer.parseInt(cantestudiantes);
                    if (cE <= 0) {

                        System.out.println(" debe ser mayor a cero");
                        verificacion = false;
                    }
                } else {
                    System.out.println("SOLO NUMEROS");
                }
            } while (!verificacion);

            //convercion a entero
            cantestudiantes2 = Integer.parseInt(cantestudiantes);

            //Nombres de los estudiantes
            for (int i = 0; i < cantestudiantes2; i++) {
                //control espacion vacios y solo letras
                do {
                    System.out.print("Ingresa el nombre del estudiante " + (i + 1) + ": ");
                    nombres = scan.nextLine();
                    verificacion = nombres.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") && !nombres.trim().isEmpty();
                    if (!verificacion) {
                        System.out.println("No puede estar vacio y solo numeros");
                    }

                } while (!verificacion);

                // ingresan los datos en el areglo
                estudiantes.add(nombres);
            }

            //notas de los alumnos
            do {
                System.out.println("Ingrese la cantidad de notas: ");
                cantidadnotas = scan.nextLine();

                verificacion = cantidadnotas.matches("\\d+");

                if (verificacion) {

                    cN = Integer.parseInt(cantidadnotas);
                    if (cN <= 0) {

                        System.out.println(" debe ser mayor a cero");
                        verificacion = false;
                    }
                } else {
                    System.out.println("SOLO NUMEROS");
                }
            } while (!verificacion);

            //convercion a entero
            cantnotas2 = Integer.parseInt(cantidadnotas);

            for (int i = 0; i < estudiantes.size(); i++) {
                 ArrayList<Float> notasEstudiante = new ArrayList<>();
                acu = 0;
                System.out.println("Notas del estudian: " + estudiantes.get(i));
                for (int j = 0; j < cantnotas2; j++) {
                    System.out.print("Ingresa la nota " + (j + 1) + ":");
                    float guardanotas = scan.nextFloat();
                    // ingresan los datos en el areglo
                    notasEstudiante.add(guardanotas);//damos la notas en el primer arreglo
                    acu = acu + guardanotas;
                    
                }
                 todasLasNotas.add(notasEstudiante);//las del primer arreglo guardamos aqui
                promedio2 = acu / cantnotas2;
                promedios.add(promedio2);
            }
            
            //encabesado de impresion
            System.out.printf("%-15s","Nombre");//para el apartado de nombres
            for (int i = 0; i < cantnotas2; i++) {
                System.out.printf("%-8s","Nota " + (i + 1) + ".");
            }
            System.out.printf("%-10s","Promedios");
            System.out.print("\n");
                 //imprimir notas y nombres
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.printf("%-15s",(i + 1) + "." + estudiantes.get(i));
                 ArrayList<Float> notasEstudiante = todasLasNotas.get(i);
                 // no afecta declarar el mismo arreglo porque era solo para ese
                 //for
                for (int k = 0; k < notasEstudiante.size(); k++) {

                    System.out.printf("%-8s", notasEstudiante.get(k));
                    

                }
                System.out.printf("%-10.2f", promedios.get(i));
                if (promedios.get(i)<=10){
                    if(promedios.get(i)>=7){
                        System.out.print("Aprovado");
                    }
                    if(promedios.get(i)<7){
                        if (promedios.get(i)>=4){
                            System.out.print("Supletorio");
                        }else{
                            System.out.println("Reprobo");
                        }
                    }
                }
                System.out.print("\n");
            }

            //repetir
            System.out.println("Desea Ingresar mas notas");
            r = scan.nextLine();// preguntamos al usuario si desea realizar otro
            
        } while (!r.equals("no"));// evalua la respueta 
        // si dice si, se niega vale no y evalua si r despues de negar es igual
       //a no y si es igual se repite, caso contrario si al negar se hace si 
       //sale por el lado de la falcedad
       
    }
    
}