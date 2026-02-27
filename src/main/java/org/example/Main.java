package org.example;

public class Main {
    public static void main(String[] args){
        ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>(Integer::compare);
        System.out.println();

        insertar(arbol, 50);
        insertar(arbol, 70);
        insertar(arbol, 20);
        insertar(arbol, 40);
        insertar(arbol, 60);
        insertar(arbol, 80);
        insertar(arbol, 45);
        insertar(arbol, 10);
        insertar(arbol, 30);
        insertar(arbol, 35);
        insertar(arbol, 50);

//        insertar(arbol, 10);
//        insertar(arbol, 20);
//        insertar(arbol, 30);
//        insertar(arbol, 35);
//        insertar(arbol, 40);
//        insertar(arbol, 45);
//        insertar(arbol, 50);
//        insertar(arbol, 60);
//        insertar(arbol, 70);
//        insertar(arbol, 80);

        /*
            ¿Qué pasa si se insertan los datos en forma ascendente?
            Cada valor será mayor que el anterior por lo que siempre se van a insertar en la derecha.
            ¿Qué forma toma el árbol en ese caso?
            Tomaría la forma de una lista enlazada básicamente.
            ¿Qué sería la complejidad resultante?
            O(n) por que se trabajarían los nodos de forma lineal.
         */

        System.out.println();
        System.out.println("InOrden:");
        arbol.inOrden();
        System.out.println("PreOrden:");
        arbol.preOrden();
        System.out.println("PostOrden:");
        arbol.postOrden();
        System.out.println();

        System.out.println("Recorrido por Nivel:");
        arbol.recorridoPorNivel();
        System.out.println();

        System.out.println("\nOperaciones:");
        System.out.println("Cantidad de nodos: " + arbol.contarNodos());
        System.out.println("Cantidad de hojas: " + arbol.contarHojas());
        System.out.println("Altura del árbol: " + arbol.altura());
        System.out.println("Suma de nodos: " + arbol.sumarNodos());
        System.out.println("Mínimo: " + arbol.minimo());
        System.out.println("Máximo: " + arbol.maximo());

        String bal = arbol.estaBalanceado() ? "Sí" : "No";
        System.out.printf("\n¿Está balanceado?: %s", bal);


    }

    private static void insertar(ArbolBinarioBusqueda<Integer> arbol, int valor){
        if(arbol.insertar(valor))
            System.out.println( valor + " insertado!");
        else
            System.out.println( valor + " No se insertó!");
    }

    public static void buscar(ArbolBinarioBusqueda<Integer> arbol, int valor){
        Nodo<Integer> nodo = arbol.buscar(valor);
        if (nodo == null)
            System.out.println(valor + "no encontrado");
        if (nodo.obtenerDato() == valor)
            System.out.println(valor + "encontrado");
    }


}