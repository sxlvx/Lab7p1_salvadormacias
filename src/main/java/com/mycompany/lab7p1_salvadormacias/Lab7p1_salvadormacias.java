package com.mycompany.lab7p1_salvadormacias;

import javax.swing.JOptionPane;

import java.util.Random;

public class Lab7p1_salvadormacias {

    public static void main(String[] args) {
        menu();
    }//fin main

    public static void menu() {
        boolean salida = true;
        do {
            JOptionPane.showMessageDialog(null, "Bienvenido al menu!");
            JOptionPane.showMessageDialog(null, "Estas son las opciones disponibles: ");
            JOptionPane.showMessageDialog(null, "1.Promedios\n2.De landscape a portrait\n3.Higher order contains\n4.Salir");
            String str = JOptionPane.showInputDialog(null, "Ingrese una opcion");
            int opc = Integer.parseInt(str);
            switch (opc) {
                case 1: {
                    String fil = JOptionPane.showInputDialog(null, "Ingrese las filas de la matriz: ");
                    int filas = Integer.parseInt(fil);
                    String col = JOptionPane.showInputDialog(null, "Ingrese las columnas de la matriz: ");
                    int columnas = Integer.parseInt(col);
                    int matriz_gen[][] = new int[filas][columnas];
                    inicializar(matriz_gen);
                    JOptionPane.showMessageDialog(null, "Matriz generada :\n\n" + matriz_str(matriz_gen));
                    String prom = JOptionPane.showInputDialog(null, "Calcular promedio de \n1.Filas\n2.Columas: ");
                    int promedio = Integer.parseInt(prom);
                    double[] pro = null;
                    if (promedio == 1) {
                        pro = prom_fila(matriz_gen);
                        String promediosStr = imp_arr(pro);
                        JOptionPane.showMessageDialog(null, "El promedio de las filas de la matriz\n" + matriz_str(matriz_gen) + "es :\n" + promediosStr);

                    } else if (promedio == 2) {
                        pro = prom_col(matriz_gen);
                        String promediosStr = imp_arr(pro);
                        JOptionPane.showMessageDialog(null, "El promedio de las columnas de la matriz\n" + matriz_str(matriz_gen) + "es :\n" + promediosStr);

                    } else {
                        JOptionPane.showMessageDialog(null, "La opcion ingresada es invalida");
                    }

                }//fin case 1
                break;

                case 2: {
                    String fil1 = JOptionPane.showInputDialog(null, "Ingrese las filas de la matriz: ");
                    int filas1 = Integer.parseInt(fil1);
                    String col1 = JOptionPane.showInputDialog(null, "Ingrese las columnas de la matriz: ");
                    int columnas1 = Integer.parseInt(col1);
                    int matriz_normal[][] = new int[filas1][columnas1];
                    inicializar1(matriz_normal);
                    JOptionPane.showMessageDialog(null, "La rotacion de 90 grados a la derecha de:\n\n" + matriz_str(matriz_normal) + "\n es\n" + matriz_str(rotada(matriz_normal)));

                }//fin case 2
                break;

                case 3: {
                    String fil2 = JOptionPane.showInputDialog(null, "Ingrese las filas de la matriz: ");
                    int filas2 = Integer.parseInt(fil2);
                    String col2 = JOptionPane.showInputDialog(null, "Ingrese las columnas de la matriz: ");
                    int columnas2 = Integer.parseInt(col2);
                    int mat_gen[][] = new int[filas2][columnas2];
                    inicializar2(mat_gen);
                    String tam = JOptionPane.showInputDialog(null, "Ingrese el tamano del arreglo: ");
                    int tamano = Integer.parseInt(tam);
                    int[] array = new int[tamano];
                    boolean contenido = containsHO(mat_gen, array);
                    if (tamano <= columnas2) {
                        JOptionPane.showMessageDialog(null, "Matriz generada :\n\n" + matriz_str2(mat_gen));
                        int i = 0;
                        do {
                            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento " + "[" + (i) + "]" + " del arreglo:"));
                            i++;
                        } while (i < tamano);
                        if (contenido) {
                            JOptionPane.showMessageDialog(null, "El arreglo esta contenido en la matriz\n\n" + matriz_str2(mat_gen));
                        } else {
                            JOptionPane.showMessageDialog(null, "El arreglo no está contenido en la matriz\n\n" + matriz_str2(mat_gen));
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El tamano tiene que ser igual o menor que el numero de columnas");

                    }

                }//fin case 3
                break;
                case 4: {
                    salida = false;
                    JOptionPane.showMessageDialog(null, "Se abandonara el programa");

                }//fin case 4
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion ingresada no es valida");

            }//fin switch

        } while (salida != false);//fin while
    }//fin menu

    static void inicializar(int[][] matriz_gen) {
        Random r = new Random();
        for (int i = 0; i < matriz_gen.length; i++) {
            for (int j = 0; j < matriz_gen[i].length; j++) {
                matriz_gen[i][j] = r.nextInt(99) + 0;
            }
        }
    }//random matriz ejercicio 1

    static void inicializar1(int[][] matriz_normal) {
        Random r = new Random();
        for (int i = 0; i < matriz_normal.length; i++) {
            for (int j = 0; j < matriz_normal[i].length; j++) {
                matriz_normal[i][j] = r.nextInt(9) + 0;
            }
        }
    }//random matriz ejercicio 2

    static void inicializar2(int[][] mat_gen) {
        Random r = new Random();
        for (int i = 0; i < mat_gen.length; i++) {
            for (int j = 0; j < mat_gen[i].length; j++) {
                mat_gen[i][j] = r.nextInt(9) + 0;
            }
        }
    }//random matriz ejercicio 3

    public static double[] prom_fila(int[][] matriz_gen) {
        int m = matriz_gen.length;
        int n = matriz_gen[0].length;
        double[] promedios = new double[m];
        int i = 0;
        do {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                suma += matriz_gen[i][j];
            }
            promedios[i] = suma / n;
            i++;
        } while (i < m);
        return promedios;
    }

    public static double[] prom_col(int[][] matriz_gen) {
        int m = matriz_gen.length;
        int n = matriz_gen[0].length;
        double[] promedios = new double[n];
        int j = 0;
        do {
            double suma = 0;
            for (int i = 0; i < m; i++) {
                suma += matriz_gen[i][j];
            }
            promedios[j] = suma / m;
            j++;
        } while (j < n);
        return promedios;
    }

    public static String imp_arr(double[] arreglo) {
        StringBuilder sb = new StringBuilder();
        for (double valor : arreglo) {
            sb.append(valor);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String matriz_str(int[][] matriz_gen) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int x = matriz_gen.length;
        do {
            for (int j = 0; j < matriz_gen[0].length; j++) {
                sb.append("[" + matriz_gen[i][j] + "]");
            }
            sb.append("\n");
            i++;
        } while (i < x);
        return sb.toString();
    }//matriz a string ejercicio 1 

    public static String matriz_str1(int[][] matriz_normal) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int x = matriz_normal.length;
        while (i < x) {
            for (int j = 0; j < matriz_normal[0].length; j++) {
                sb.append("[" + matriz_normal[i][j] + "]");
            }
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }//matriz a string ejercicio 2

    public static String matriz_str2(int[][] mat_gen) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int x = mat_gen.length;
        while (i < x) {
            for (int j = 0; j < mat_gen[0].length; j++) {
                sb.append("[" + mat_gen[i][j] + "]");
            }
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }//matriz a string ejercicio 2

    public static int[][] rotada(int[][] matriz_normal) {
        int filas = matriz_normal.length;
        int columnas = matriz_normal[0].length;
        int[][] rotarMatrix = new int[columnas][filas];
        int i = 0;
        do {
            for (int j = 0; j < columnas; j++) {
                rotarMatrix[j][filas - i - 1] = matriz_normal[i][j];

            }
            i++;
        } while (i < filas);
        return rotarMatrix;
    }

    public static boolean containsHO(int[][] mat_gen, int[] array) {
        boolean encontrado = false;
        int i = 0;
        int j = 0;
        int z = mat_gen.length;
        int y = array.length;
        do {
            do {

                for (int k = 0; k < array.length; k++) {
                    if (mat_gen[i][j + k] == array[k]) {
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    return false;
                }
                j++;
            } while (j < z);
            i++;
        } while (i < z);
        return true;
    }

}//fin clase
