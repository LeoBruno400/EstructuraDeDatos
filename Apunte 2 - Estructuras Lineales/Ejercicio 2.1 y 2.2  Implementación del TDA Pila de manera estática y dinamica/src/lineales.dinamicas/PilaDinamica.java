public class PilaDinamica {
    
    private Nodo tope;

    public PilaDinamica(){
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem){

        //Crea un nuevo nodo delante de la antigua cabecera
        Nodo nuevo = new Nodo(nuevoElem, this.tope);

        //Actualiza el tope para que apunte al nodo nuevo
        this.tope = nuevo;

        //Nunca hay error en pila llena, entonces devuelve true
        return true; 
    }

    public boolean desapilar(){
        boolean sePuedeDesapilar = true;

        if(this.tope == null){
            sePuedeDesapilar = false;
        }else{
            this.tope = this.tope.getEnlace();
        }

        return sePuedeDesapilar;
    }

    public Object obtenerTope(){
        Object elTope = null;
        if(this.tope != null){
            elTope = this.tope.getElemento();
        }
        return elTope;
    }

    public boolean esVacia(){
        boolean estaVacia = true;

        if(this.tope != null){
            estaVacia = false;
        }

        return estaVacia;
    }

    public void vaciar(){

        if(this.tope != null){
            //this.tope = this.tope.getEnlace().vaciar();
        }

    }

    @Override
    public String toString(){
        String s = "";

        if(this.tope == null){
            s = "Pila vacia";
        }else{
            //Se ubica para recorrer la pila
            Nodo aux = this.tope;
            s = "[";

            while(aux != null){
                //Agrega el texto del elem y avanza
                s += aux.getElemento().toString();
                aux = aux.getEnlace();
                if(aux != null){
                    s += ",";
                }
            }
            s += "]";
        }

        return s;
    }

}
