public class ColaDinamica {

    private Nodo frente;
    private Nodo fin;

    //Constructor
    public ColaDinamica(){
        this.frente = null;
        this.fin = null;
    }

    // ---------------------Basicas---------------------

    public boolean poner(Object elem){
        Nodo nuevoNodo = new Nodo(elem, null);

        if(this.frente == null){ //Caso especial donde pila esta vacia
            //Si el frente esta vacio entonces el final esta vacio
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;

        }else{//Caso normal
            this.fin.setEnlace(nuevoNodo);
            this.fin = nuevoNodo;
        }
        return true; //Al ser dinamica siempre se va a agregar el nuevo elemento
    }

    public boolean sacar(){
        boolean exito = true;

        if(this.frente == null){
            //ERROR: La esta vacia
            exito = false;
        }else{
            //Hay almenos un elemento
            //Quita el primer elemento y actualiza frente (y fin se queda vacia)
            this.frente = this.frente.getEnlace();
            if(this.frente == null){ //Si frente no tiene nada, la Cola esta vacía
                this.fin = null;
            }
        }
        return exito;
    }


    public Object obtenerFrente(){
        return this.frente.getElemento();
    }

    public boolean esVacia(){
        return this.frente == null;
    }

    public boolean vaciar(){
        boolean sePudoVaciar = true;
        if(this.frente != null){ //Si la cola no está vacia
            //La vacio
            this.frente = null;
            this.fin = null;
        }else{ //Si esta vacia
            //Devuelvo boolean que indica que no se vacio
            sePudoVaciar = false;
        }
        return sePudoVaciar;
    }

    @Override
    public ColaDinamica clone(){
        ColaDinamica colaClon = new ColaDinamica();
        

        if(this.frente != null){
            Nodo recorrer, copia;
            recorrer = this.frente;
            copia = new Nodo(null, null);

            do{
                copia.setElemento(recorrer.getElemento());
                copia.setEnlace(null);
                colaClon.poner(copia);
                recorrer = recorrer.getEnlace();
            }while(recorrer != null);
        }

        return colaClon;
    }

    @Override
    public String toString(){
        String texto = "[";

        if(this.frente != null){ //Si la Cola NO esta vacia
            Nodo aux = this.frente;

            while(aux != null){
                texto += aux.getElemento().toString();
                aux = aux.getEnlace();
                if(aux != null){
                    texto += ",";
                }
            }
            texto += "]";

        }else{ //Si la Cola esta VACIA
            texto = "La cola esta VACIA";
        }
        return texto;
    }

}