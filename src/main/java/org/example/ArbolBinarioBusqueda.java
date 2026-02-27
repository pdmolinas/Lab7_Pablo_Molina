package org.example;

import java.util.Comparator;
import java.util.Stack;

public class ArbolBinarioBusqueda<T> {
    private Nodo<T> raiz;
    private final Comparator<T> comparador;

    public ArbolBinarioBusqueda(Comparator<T> comparador){
        this.comparador = comparador;
        this.raiz = null;
    }

    public boolean insertar(T valor){
        Nodo<T> resultado = insertar(valor,raiz);
        if (resultado == null) return false;
        raiz = resultado;
        return true;
    }

    private Nodo<T> insertar(T valor, Nodo<T> nodo){
        if(nodo == null){
            return new Nodo<>(valor);
        }

        if(comparador.compare(valor, nodo.obtenerDato()) == 0){
            return null;
        }

        if(comparador.compare(valor, nodo.obtenerDato()) < 0){
            Nodo<T> aux = insertar(valor, nodo.izquierdo);
            if (aux == null) return null;
            nodo.izquierdo = aux;
            return nodo;
        } else {
            Nodo<T> aux = insertar(valor, nodo.derecho);
            if(aux == null) return null;
            nodo.derecho = aux;
            return  nodo;
        }
    }

    /*
        Complejidad: en el mejor de los casos O(log n) que es cuando el arbol está balanceado lo cual permite un mejor desempeño.
        En el peor de los casos O(n) donde todos los nodos estén hacia un lado porque debe recorrerlos de forma lineal.
     */

    public void inOrden() {
        Stack<Nodo<T>> stack = new Stack<>();
        Nodo<T> actual = raiz;

        while (actual != null || !stack.isEmpty()) {

            while (actual != null) {
                stack.push(actual);
                actual = actual.izquierdo;
            }

            actual = stack.pop();
            System.out.print(actual.obtenerDato() + " ");

            actual = actual.derecho;
        }

        System.out.println();
    }

    public void preOrden() {
        if (raiz == null) return;

        Stack<Nodo<T>> stack = new Stack<>();
        stack.push(raiz);

        while (!stack.isEmpty()) {
            Nodo<T> actual = stack.pop();
            System.out.print(actual.obtenerDato() + " ");

            if (actual.derecho != null)
                stack.push(actual.derecho);

            if (actual.izquierdo != null)
                stack.push(actual.izquierdo);
        }

        System.out.println();
    }

    public void postOrden() {
        if (raiz == null) return;

        Stack<Nodo<T>> stack1 = new Stack<>();
        Stack<Nodo<T>> stack2 = new Stack<>();

        stack1.push(raiz);

        while (!stack1.isEmpty()) {
            Nodo<T> actual = stack1.pop();
            stack2.push(actual);

            if (actual.izquierdo != null)
                stack1.push(actual.izquierdo);

            if (actual.derecho != null)
                stack1.push(actual.derecho);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().obtenerDato() + " ");
        }

        System.out.println();
    }

    /*
        Recorridos Iterativos, Complejidad temporal O(n)
     */

    public int altura(){
        return altura(raiz);
    }

    private int altura(Nodo<T> nodo){
        if (nodo == null) return 0;

        int izquierda = altura(nodo.izquierdo);
        int derecho = altura(nodo.derecho);

        return 1 + Math.max(izquierda, derecho);
    }

    private void imprimirNivel(Nodo<T> nodo, int nivel) {
        if (nodo == null) return;

        if (nivel == 1) {
            System.out.print(nodo.obtenerDato() + " ");
        } else {
            imprimirNivel(nodo.izquierdo, nivel - 1);
            imprimirNivel(nodo.derecho, nivel - 1);
        }
    }

    public void recorridoPorNivel() {
        int h = altura();

        for (int i = 1; i <= h; i++) {
            System.out.print("Nivel " + i + ": ");
            imprimirNivel(raiz, i);
            System.out.println();
        }
    }

    /*
        Recorrido por nivel: Complejidad temporal en el peor de los casos O(n^2) sin embargo si el arbol estuviese
        balanceado sería O(n log n)
     */

    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null) return 0;

        return 1 + contarNodos(nodo.izquierdo)
                + contarNodos(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null) return 0;

        if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;

        return contarHojas(nodo.izquierdo)
                + contarHojas(nodo.derecho);
    }

    public int sumarNodos() {
        return sumarNodos(raiz);
    }

    private int sumarNodos(Nodo<T> nodo) {
        if (nodo == null) return 0;

        return (Integer) nodo.obtenerDato()
                + sumarNodos(nodo.izquierdo)
                + sumarNodos(nodo.derecho);
    }

    public int minimo() {
        Nodo<T> actual = raiz;

        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }

        return (Integer) actual.obtenerDato();
    }

    public int maximo() {
        Nodo<T> actual = raiz;

        while (actual.derecho != null) {
            actual = actual.derecho;
        }

        return (Integer) actual.obtenerDato();
    }

    public boolean estaBalanceado() {
        return estaBalanceado(raiz);
    }

    private boolean estaBalanceado(Nodo<T> nodo) {

        if (nodo == null) return true;

        int alturaIzq = altura(nodo.izquierdo);
        int alturaDer = altura(nodo.derecho);

        if (Math.abs(alturaIzq - alturaDer) > 1)
            return false;

        return estaBalanceado(nodo.izquierdo)
                && estaBalanceado(nodo.derecho);
    }

    //El arbol binario esta balanceado si la diferencia entre la altura del subarbol izquierdo y el derecho no es mayor que 1

    public Nodo<T> buscar(T valor){
        return buscar(this.raiz, valor);
    }

    public Nodo<T> buscar(Nodo<T> nodo, T valor){
        if (nodo == null){
            nodo = new Nodo<>(valor);
            return nodo;
        }
        if (comparador.compare(valor, nodo.obtenerDato()) == 0)
            return nodo;
        if(comparador.compare(valor, nodo.obtenerDato()) < 0)
            return buscar(nodo.izquierdo, valor);
        return buscar(nodo.derecho, valor);
    }

    public Nodo<T> eliminar(T valor){
        return eliminar(this.raiz, valor);
    }

    private Nodo<T> eliminar(Nodo<T> raiz, T valor){
        if (raiz == null ) return null;

        if (comparador.compare(valor, raiz.obtenerDato()) == 0){
            if(raiz.derecho == null && raiz.izquierdo != null)
                return raiz.izquierdo;
            if(raiz.izquierdo == null && raiz.derecho != null)
                return raiz.derecho;
            if(raiz.izquierdo == null && raiz.derecho == null)
                return null;

            T min = min(raiz.derecho).obtenerDato();

            raiz.dato = min;

            raiz.derecho = eliminar(raiz.derecho, min);

            return raiz;
        }
        if(comparador.compare(valor, raiz.obtenerDato()) < 0){
            raiz.izquierdo = eliminar(raiz.izquierdo, valor);
            return raiz;
        }
        raiz.derecho = eliminar(raiz.derecho, valor);
        return raiz;
    }

    private Nodo<T> min(Nodo<T> raiz){
        if(raiz == null) return null;
        while (raiz.izquierdo != null)
            raiz = raiz.izquierdo;

        return raiz;
    }

}