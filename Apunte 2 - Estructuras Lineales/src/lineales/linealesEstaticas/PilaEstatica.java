import java.util.Arrays;
public class PilaEstatica {
    private static final int TAMANIO = 5;
    private Object[] arreglo;
    private int tope;

    // Constructor
    public PilaEstatica() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    // ---------------------Basicas---------------------

    public void setTope(int numero){
        this.tope = numero;
    }

    public boolean apilar(Object newElem) {
        // Apila un nuevo elemento.
        boolean sePuedeApilar;

        if (this.tope + 1 >= TAMANIO) {
            // EROR: pila llena.
            sePuedeApilar = false;
        } else {
            // Pone el elemento en el tope de la pila e incrementa el tope.
            this.tope++;
            this.arreglo[this.tope] = newElem;
            sePuedeApilar = true;
        }
        return sePuedeApilar;
    }

    public boolean desapilar() {
        // Desapila un elemento (le aplica la eutanasia).
        boolean borrar = false;

        if (this.tope > -1) {
            // Eutanasia
            this.arreglo[this.tope] = null;
            borrar = true;
            this.tope--;
        }
        return borrar;
    }

    public Object obtenerTope() {
        // Obtiene el elemento del tope de la pila.
        Object elemento = null;

        if (this.tope > -1) {
            elemento = this.arreglo[this.tope];
        }
        return elemento;
    }

    public boolean esVacia() {
        // Verifica si la pila esta vacia.
        boolean vacia = true;

        if (this.tope > -1) {
            vacia = false;
        }
        return vacia;
    }

    // ---------------------NO Basicas---------------------

    public void vaciar() {
        // Vacia la pila sin guardar los elementos.
        int i;

        for (i = this.tope; i > -1; i--) {
            this.arreglo[i] = null;
        }
        this.tope = -1;
    }

    @Override
    public String toString() {
        // Imprime los elementos dentro de la pila.
        String mensaje = "[";
        int i;

        if (this.tope > -1) {
            for (i = 0; i <= this.tope; i++) {
                mensaje += this.arreglo[i].toString();
                if(i != this.tope){
                    mensaje += ",";
                }
            }
            mensaje += "]";
        } else {
            mensaje = "Pila Vacia";
        }
        return mensaje;
    }

    @Override
    public PilaEstatica clone() {
        //Clona la pila en una nueva.
        PilaEstatica nueva = new PilaEstatica();
        nueva.arreglo = this.arreglo.clone();
        nueva.tope = this.tope;
        return nueva;
    }

    public boolean equals(PilaEstatica newPila1){
        //Compara si dos pilas son iguales en elementos;
        boolean aux = Arrays.equals(this.arreglo, newPila1.arreglo);
        
        return aux;
    }

    public boolean esCapicua(){
        PilaEstatica inversa = new PilaEstatica();
        PilaEstatica pilaAux = this.clone();

        while(!pilaAux.esVacia()){
            inversa.apilar(pilaAux.obtenerTope());
            pilaAux.desapilar();
        }
        
        return (this.equals(inversa));
    }

}
