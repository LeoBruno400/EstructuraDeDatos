package jerarquicas.jerarquicasEstaticas;
public class CeldaBin {

    private Object elem;
    private int izquierdo;
    private int derecho;
    private boolean enUso;

    //Constructor
    public CeldaBin(Object elem, int izquierdo, int derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    //Observadoras
    public Object getElem(){
        return this.elem;
    }

    public int getIzquierdo(){
        return this.izquierdo;
    }

    public int getDerecho(){
        return this.derecho;
    }

    public boolean getEnUso(){
        return this.enUso;
    }

    //Modificadores
    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setIzquierdo(int izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(int derecho){
        this.derecho = derecho;
    }
    
}
