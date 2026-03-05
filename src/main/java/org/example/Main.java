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
        insertar(arbol, 22);
        insertar(arbol, 44);
        insertar(arbol, 77);
        insertar(arbol, 63);
        insertar(arbol, 21);
        insertar(arbol, 18);
        insertar(arbol, 15);
        insertar(arbol, 96);
        insertar(arbol, 41);
        insertar(arbol, 38);

        System.out.println();
        System.out.println("Recorridos del Árbol original:");
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

        eliminar(arbol,22);
        eliminar(arbol,44);
        eliminar(arbol,77);
        eliminar(arbol,63);
        eliminar(arbol,21);
        eliminar(arbol,18);
        eliminar(arbol,15);
        eliminar(arbol,96);
        eliminar(arbol,41);
        eliminar(arbol,38);

        System.out.println();
        System.out.println("Recorridos del Arbol despues de eliminar la mitad de los valores:");
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

    }

    private static void insertar(ArbolBinarioBusqueda<Integer> arbol, int valor){
        if(arbol.insertar(valor))
            System.out.println( valor + " insertado!");
        else
            System.out.println( valor + " No se insertó!");
    }

    private static void eliminar(ArbolBinarioBusqueda<Integer> arbol, int valor){
        arbol.eliminar(valor);
        System.out.println( valor + " eliminado!");
    }

    public static void buscar(ArbolBinarioBusqueda<Integer> arbol, int valor){
        Nodo<Integer> nodo = arbol.buscar(valor);
        if (nodo == null)
            System.out.println(valor + "no encontrado");
        if (nodo.obtenerDato() == valor)
            System.out.println(valor + "encontrado");
    }

}
/*
    1.
    Complejidad de buscar: O(log n)
    Complejidad de eliminar: O(log n)

    2.¿Qué sucede en la búsqueda si los datos se insertan en orden ascendente? ¿Haría alguna mejora?
    Sí se hace de forma ascendente la complejidad cambia a O(n) entonces empeora

    3.
    Cambiar la condición de rechazo.

    El código actual eliminaría solo la primera ocurrencia.
    Para eliminar todas, se continuaría la recursión después de eliminar
 */