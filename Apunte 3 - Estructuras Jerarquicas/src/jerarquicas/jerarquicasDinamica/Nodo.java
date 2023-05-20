package jerarquicas.jerarquicasDinamica;

class Nodo {

    // Atributos
    private Object elem;
    private Nodo enlace;

    // Constructor
    public Nodo(Object elem, Nodo enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    // Modificadoras
    public void setElemento(Object elem) {
        this.elem = elem;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    // Observadoras
    public Object getElemento() {
        return elem;
    }

    public Nodo getEnlace() {
        return enlace;
    }

}