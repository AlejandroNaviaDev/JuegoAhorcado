package JuegoAhorcado;

import java.util.Random;
import java.util.Scanner;

public class JuegoAhorcado {
    public static void main(String[] args) {
        final int TotalIntentos = 10;
        int Intentos = 0;
        int Aciertos = 0;
        Scanner Entrada = new Scanner(System.in);
        Entrada.useDelimiter("\n");
        char resp;
        Random rnd = new Random();
        String arrayPalabras[] = new String[2];
        arrayPalabras[0] = "software";
        arrayPalabras[1] = "tecnologia";
        do {
            int alea = rnd.nextInt(3);
            char[] Limpiar = Borrar(arrayPalabras[alea]);
            char[] copia = Borrar(arrayPalabras[alea]);
            char[] tusRespuestas = new char[Limpiar.length];
            for(int i = 0; i < tusRespuestas.length; i++){
                tusRespuestas[i] = '_';
            }
            System.out.println("Adivina la palabra!");
            while(Intentos < TotalIntentos && Aciertos != tusRespuestas.length){
                imprimeOculta(tusRespuestas);
                System.out.println("\nIntroduce una letra: ");
                resp = Entrada.next().toLowerCase().charAt(0);
                for(int i = 0; i < Limpiar.length; i++){
                    if(Limpiar[i]==resp){
                        tusRespuestas[i] = Limpiar[i];
                        Limpiar[i] = ' ';
                        Aciertos++;
                    }
                }
                Intentos++;
            }
            if(Aciertos == tusRespuestas.length){
                System.out.print("\n¡Felicidades! Has acertado la palabra: ");
                imprimeOculta(tusRespuestas);
            }
            else{
                System.out.print("\nPerdiste. La palabra era: ");
                for(int i = 0; i < copia.length; i++){
                    System.out.print(copia[i] + " ");
                }
            }
            Intentos = 0;
            Aciertos = 0;
        }while(true);
    }
    private static char[] Borrar(String palAzar){
        char[] letras;
        letras = new char[palAzar.length()];
        for(int i = 0; i < palAzar.length(); i++){
            letras[i] = palAzar.charAt(i);
        }
        return letras;
    }
    private static void imprimeOculta(char[] tusRespuestas){
        for(int i = 0; i < tusRespuestas.length; i++){
            System.out.print(tusRespuestas[i] + " ");
        }
    }
}
