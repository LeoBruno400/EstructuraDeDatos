import java.util.Arrays;
public class PilaEstatica {
    //Ejercicio 1
    private static final int TAMANIO = 5;
    private Object[] arreglo;
    private int tope;

    // Constructor de la pila.
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

    public String toString() {
        // Imprime los elementos dentro de la pila.
        String mensaje = "";
        int i;

        if (this.tope > -1) {
            for (i = 0; i <= this.tope; i++) {
                mensaje += "POSICION " + i + ": " + this.arreglo[i].toString() + "\n";
            }
        } else {
            mensaje = "Pila Vacia";
        }
        return mensaje;
    }

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

    public PilaEstatica invertirPila(){
        PilaEstatica auxPila = new PilaEstatica();
        auxPila.arreglo = Arrays.copyOf(this.arreglo, this.tope+1);
        auxPila.setTope(this.tope);
        PilaEstatica inversa= new PilaEstatica();
        inversa.setTope(this.tope);

        for (int index = 0; index <= this.tope ; index++) {
            inversa.apilar(auxPila.obtenerTope());
            auxPila.desapilar();
        }

        return inversa;
    }

    public String esCapicua(){
        PilaEstatica inversa = new PilaEstatica();
        PilaEstatica pilaAux = new PilaEstatica();
        PilaEstatica original = new PilaEstatica();
        original.arreglo = this.arreglo.clone();
        pilaAux.arreglo = this.arreglo.clone();

        Object elemento = null;
        String mensaje = "";

        for (int i = 0; i < this.tope; i++) {
            elemento = pilaAux.obtenerTope();
            pilaAux.desapilar();
            inversa.apilar(elemento);
        }

        if(original.equals(inversa) == true){
            mensaje = "Es capicua";
        }else{
            mensaje = "No son capicua";
        }
        
        return mensaje;
    }
   
}
