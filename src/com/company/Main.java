package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 7, 1, 4, 2, 6};
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7};

        int[][] randomMatrix1 = newMatrix(5,5);
        int[][] randomMatrix2 = newMatrix(5,5);

        int [][] addMatrices = addTwoMatrices(randomMatrix1, randomMatrix2);

        printMatrix(randomMatrix1);
        System.out.println();
        printMatrix(randomMatrix2);
        System.out.println();
        printMatrix(addMatrices);

        addTwoArr(arr, arr1);

        for (int i = 0; i < addTwoArr(arr, arr1).length; i++) {
            System.out.print(addTwoArr(arr, arr1)[i] + " ");
        }

        //№1

        System.out.println("среднее арифметическое: " + arrMean(arr));

        for (int i = 0; i < cloneArr(arr).length; i++){
            System.out.print(cloneArr(arr)[i] + " ");
        }

        //№3

        System.out.println();
        System.out.println("Введите номер элемента для его удаления");

        Scanner scanDeleteElement = new Scanner(System.in);
        int indexDeleteElement = scanDeleteElement.nextInt() - 1;

        for (int i = 0; i < deleteElement(arr, indexDeleteElement).length; i++){
            System.out.print(deleteElement(arr, indexDeleteElement)[i] + " ");
        }

        //№4
        System.out.println();

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("Введите элемент который добавить: ");

        Scanner scanAddElement = new Scanner(System.in);
        int addElement = scanDeleteElement.nextInt();

        System.out.println("Введите какой он будет по счёту: ");

        Scanner scanIndexAddElement = new Scanner(System.in);
        int indexAddElement = scanIndexAddElement.nextInt() - 1;

        for (int i = 0; i < addNewElement(arr, indexAddElement, addElement).length; i++){
            System.out.print(addNewElement(arr, indexAddElement, addElement)[i] + " ");
        }
    }

    public static void printMatrix(int [][] c){
        for(int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] newMatrix(int height, int width){

        int[][] matrix = new int[height][width];

        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static int[][] addTwoMatrices(int[][] a, int[][] b){

        int[][] newAddMatrices = new int[a.length][a[0].length];

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j <a[i].length; j++){
                newAddMatrices[i][j] = a[i][j] + b[i][j];
            }
        }
        return newAddMatrices;
    }

    public static int[] addTwoArr(int[] arr, int[] arr1) {

        int max;
        int min;

        if (arr.length >= arr1.length) {
            max = arr.length;
            min = arr1.length;
        } else {
            max = arr1.length;
            min = arr.length;
        }
        int[] newArr = new int[max];
        for (int i = 0; i < max; i++) {

            if (i < min) {
                newArr[i] = arr[i] * arr[i] + arr1[i] * arr1[i];
            } else {
                if (arr.length > arr1.length) {
                    newArr[i] = arr[i] * arr[i];
                } else {
                    newArr[i] = arr1[i] * arr1[i];
                }
            }
        }
        return newArr;
    }

    public static float arrMean(int[] arr) {
        float sumElements = 0f;

        for (int i = 0; i < arr.length; i++) {
            sumElements += arr[i];
        }

        return sumElements / arr.length;
    }

    //№2

    public static int[] deleteElement (int[] arr, int indexDeleteElement){


        int[] arrWithDeletdElement = new int[arr.length - 1];

        for(int i = 0; i < arr.length; i++){
            if(i < indexDeleteElement){
                arrWithDeletdElement[i] = arr[i];
            }
            else if(i > indexDeleteElement){
                arrWithDeletdElement[i - 1] = arr[i];
            }
        }
        return arrWithDeletdElement;
    }

    //№3

    public static int[] cloneArr (int[] arr) {

        int[] arrClone = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            arrClone[i] = arr[i];
        }
        return arrClone;
    }

    //№4

    public static int[] addNewElement (int[] arr, int indexAddElement, int addElement) {


        int[] arrWithAddElement = new int[arr.length + 1];
        arrWithAddElement[indexAddElement] = addElement;

        for (int i = 0; i < arr.length; i++) {

            if(i < indexAddElement){
                arrWithAddElement[i] = arr[i];
            }else if(i >= indexAddElement){
                arrWithAddElement[i + 1] = arr[i];
            }
        }
        return arrWithAddElement;
    }
}




