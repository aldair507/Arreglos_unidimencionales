package org.example;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ejercisio 1");
        Ejercisio1(new int[10]);
        System.out.println("Ejercisio 2");
        Ejercisio2(new int[50]);
        System.out.println("Ejercisio 3");
        System.out.println("Seleccione tamano de el array:");

        int tamano = scanner.nextInt();

        Ejercisio3(new int[tamano]);
        System.out.println("Ejercisio 4");
        Ejercisio4(new int[10]);
        System.out.println("Seleccione tamano de el array:");
        tamano = scanner.nextInt();
        System.out.println("Ejercisio 5");
        Ejercisio5(new int[tamano]);
        ArrayList<String> nombres = new ArrayList<>();
        Ejercisio6(nombres);
        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        Ejercisio7(numerosEnteros);
        ArrayList<Integer> numeros = new ArrayList<>();
        Ejercisio8(numeros);
        ArrayList<Integer> numerosPares = new ArrayList<>();
        Ejercisio9(numerosPares);

    }

    public static void Ejercisio1(int[] numerosPrimos) {

        int count = 0;
        int numero = 2;
        while (count < numerosPrimos.length) {
            boolean primo = true;
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                numerosPrimos[count] = numero;
                count++;
            }
            numero++;
        }

        for (int i = 0; i < numerosPrimos.length; i++) {
            System.out.println(numerosPrimos[i]);
        }
    }

    public static void Ejercisio2(int[] numerosPares) {

        int contador = 0;
        int numero = 2;
        while (contador < numerosPares.length) {

            numerosPares[contador] = numero;
            numero += 2;
            contador++;
        }

        System.out.print("Números pares en una sola línea: ");
        StringBuilder paresEnUnaLinea = new StringBuilder();
        for (int i = 0; i < numerosPares.length; i++) {
            paresEnUnaLinea.append(numerosPares[i]).append(" ");
        }
        System.out.println(paresEnUnaLinea.toString().trim());

        System.out.println("\nNúmeros pares en 10 líneas:");
        for (int i = 0; i < numerosPares.length; i++) {
            if (i % 10 == 0) {
                System.out.print("Línea " + (i / 10 + 1) + ": ");
            }
            System.out.print(numerosPares[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void Ejercisio3(int[] numerosEnteros) {

        for (int i = 1; i < numerosEnteros.length; i++) {
            numerosEnteros[i] = i + 1;
            System.out.println(numerosEnteros[i]);
        }

        int[] factoriales = new int[numerosEnteros.length];

        for (int i = 0; i < numerosEnteros.length; i++) {
            factoriales[i] = calcularFactorial(numerosEnteros[i]);
        }

        System.out.println("Números ingresados:");
        for (int numero : numerosEnteros) {
            System.out.print(numero + " ");
        }
        System.out.println();

        System.out.println("Factoriales:");
        for (int factorial : factoriales) {
            System.out.print(factorial + " ");
        }
        System.out.println();
    }

    public static int calcularFactorial(int numero) {
        int resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void Ejercisio4(int[] numeros) {

        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 0; i < 10; i++) {
            numeros[i] = i * 3;
            System.out.println(numeros[i]);
        }

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }

        }
        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);
    }

    public static void Ejercisio5(int[] numeros) {
        int[] numerosInvertidos = new int[numeros.length];

        System.out.println("Números originales:");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 5;
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numeros.length; i++) {
            numerosInvertidos[i] = numeroInvertido(numeros[i]);
        }

        System.out.println("Números invertidos:");
        for (int numero : numerosInvertidos) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }

    public static int numeroInvertido(int numero) {
        int invertido = 0;

        while (numero > 0) {
            invertido = invertido * 10 + numero % 10;
            numero /= 10;
        }
        return invertido;
    }

    public static void Ejercisio6(ArrayList<String> nombres) {
        Collections.addAll(nombres, "Aldair", "lucho", "james", "Neymar", "savinho");
        System.out.println(nombres);
        nombres.add(1, "juan jose");
        System.out.println(nombres);
        nombres.remove(0);
        System.out.println(nombres);
        nombres.add(0, "sebastian");
        System.out.println(nombres);
        String posicion1 = nombres.get(1);
        System.out.println(posicion1);
        String ultimaPosicion = nombres.getLast();
        System.out.println(ultimaPosicion);

    }

    public static void Ejercisio7(ArrayList<Integer> numeros) {
        int suma = 0;
        int numero = 0;
        System.out.println("Ingresa numeros enteros");
        numero = scanner.nextInt();
        while (numero != 0) {
            numeros.add(numero);
            suma += numero;
            numero = scanner.nextInt();
        }
        System.out.println("Numeros ingresados: " + numeros);
        System.out.println("Suma: " + suma);

        double media = (double) suma / numeros.size();
        System.out.println("Media: " + media);
    }

    public static void Ejercisio8(ArrayList<Integer> numerosPares) {

        int numero = 0;

        for (int i = 2; i <= 20; i++) {
            if (i % 2 == 0) {
                numero = i;

                numerosPares.add(numero);

            }

        }
        System.out.println("lista actual" + numerosPares);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número para insertar en la lista: ");
        int nuevoNumero = scanner.nextInt();

        int posicion = 0;
        while (posicion < numerosPares.size() && numerosPares.get(posicion) < nuevoNumero) {
            posicion++;
        }
        numerosPares.add(posicion, nuevoNumero);
        System.out.println("Lista después de insertar el número: " + numerosPares);

        System.out.print("Ingrese un número para eliminar de la lista: ");
        int numeroEliminar = scanner.nextInt();

        if (numerosPares.contains(numeroEliminar)) {
            numerosPares.remove(Integer.valueOf(numeroEliminar));
            System.out.println("Lista después de eliminar el número: " + numerosPares);
        } else {
            System.out.println("El número no se encuentra en la lista.");
        }

        scanner.close();

    }

    public static void Ejercisio9(ArrayList<Integer> numeros) {
        Collections.addAll(numeros, 10, 20, 30, 40, 50, 60);
        System.out.println("Lista original: " + numeros);

        numeros.add(1, 1000);
        numeros.add(3, 2000);
        System.out.println("Lista (a) después de inserciones: " + numeros);

        numeros.set(0, 5000);
        numeros.set(2, 10000);
        System.out.println("Lista (a) después de reemplazos: " + numeros);

        int firstIndex = numeros.indexOf(2000);
        System.out.println("Primera ocurrencia de 2000 en índice: " + firstIndex);

        int lastIndex = numeros.lastIndexOf(2000);
        System.out.println("Última ocurrencia de 2000 en índice: " + lastIndex);

        numeros.add(2000);
        System.out.println("Lista numeros después de agregar 2000 al final: " + numeros);

        System.out.println("Primera ocurrencia de 2000 ahora en índice: " + numeros.indexOf(2000));
        System.out.println("Última ocurrencia de 2000 ahora en índice: " + numeros.lastIndexOf(2000));

        int pos40 = numeros.indexOf(40);
        if (pos40 != -1) {
            System.out.println("El valor 40 está en la posición: " + pos40);
        } else {
            System.out.println("El valor 40 no está en la lista.");
        }

        // i) Eliminar el valor en la posición 5
        numeros.remove(5);
        System.out.println("Lista numeros después de eliminar el valor en posición 5: " + numeros);

        System.out.println("¿Lista numeros está vacía?: " + numeros.isEmpty());
        System.out.println("Número de elementos en la lista numeros: " + numeros.size());

        ArrayList<Integer> b = new ArrayList<>();
        Collections.addAll(b, 111, 222, 333);
        System.out.println("Lista (b): " + b);

        ArrayList<Integer> c = new ArrayList<>();
        Collections.addAll(c, 77777, 88888);
        System.out.println("Lista (c): " + c);

        b.addAll(numeros);
        b.addAll(c);
        System.out.println("Lista (b) después de agregar numeros y (c): " + b);

        numeros.add(99999);
        System.out.println("Lista numeros después de agregar 99999: " + numeros);

        b.removeAll(numeros);
        System.out.println("Lista (b) después de eliminar elementos de numeros: " + b);
        System.out.println("Lista numeros después de la operación: " + numeros);

        numeros.clear();
        System.out.println("Lista numeros después de borrar todos los elementos: " + numeros);
        System.out.println("¿Lista numeros está vacía?: " + numeros.isEmpty());
    }
}