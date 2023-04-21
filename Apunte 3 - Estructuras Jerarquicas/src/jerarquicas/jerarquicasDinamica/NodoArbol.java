package jerarquicas.jerarquicasDinamica;

public class NodoArbol {

    private Object tipoElemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    //Constructor
    public NodoArbol(Object tipoELemento, NodoArbol izquierdo, NodoArbol derecho){
        this.tipoElemento = tipoELemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    //Modificadoras
    public void setElemento(Object tipoElemento){
        this.tipoElemento = tipoElemento;
    }

    public void setIzquierdo(NodoArbol izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol derecho){
        this.derecho = derecho;
    }

    //Observadoras
    public Object getElemento(){
        return this.tipoElemento;
    }

    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }

    public NodoArbol getDerecho(){
        return this.derecho;
    }
}
