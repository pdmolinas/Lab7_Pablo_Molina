package org.example;

public class Nodo<T> {
    public T dato;
    protected Nodo<T> izquierdo;
    protected Nodo<T> derecho;

    public Nodo(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return String.format("Nodo(dato= %s) (Izq= %s, Der= %s)",
                dato,
                izquierdo != null ? izquierdo.dato : "null",
                derecho != null ? derecho.dato : "null");
    }

    public T obtenerDato() {
        return dato;
    }
}