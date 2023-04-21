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
        boolean seDesapilo = true;

        if(this.tope == null){ //Si no tiene nodo (o sea, pila vacia, o sea, this.tope ya es null)
            seDesapilo = false;
        }else{
            if (this.tope.getEnlace() != null){ //Si no es el último nodo
                this.tope = this.tope.getEnlace();
            }else if (this.tope.getEnlace() == null){ //Si es el último nodo
                this.tope = null;
            }
        }
        
        return seDesapilo;
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
            this.tope = null;
        }

    }

    @Override
    public PilaDinamica clone(){
        PilaDinamica clon = new PilaDinamica();
        clon.tope = recNodos(this.tope);
        return clon;
    }

    private Nodo recNodos(Nodo nodoOr){
        Nodo nodoClon = new Nodo(null, null);
        if (nodoOr.getEnlace() == null){
            nodoClon.setElemento(nodoOr.getElemento());;
        }else{
            nodoClon.setElemento(nodoOr.getElemento()); 
            nodoClon.setEnlace(recNodos(nodoOr.getEnlace()));
        }
        return nodoClon;
    }
    
    @Override
    public String toString(){
        String mensaje = "";

        if(this.tope == null){
            mensaje = "Pila vacia";
        }else{
            //Se ubica para recorrer la pila
            Nodo aux = this.tope;
            mensaje = "[";

            while(aux != null){
                //Agrega el texto del elem y avanza
                mensaje += aux.getElemento().toString();
                aux = aux.getEnlace();
                if(aux != null){
                    mensaje += ",";
                }
            }
            mensaje += "]";
        }

        return mensaje;
    }

    /* 
            ⠀⠀⠀⠀⠀⢀⣀⣤⣶⣶⣶⣶⣶⢶⢶⡦⢤⣀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⢀⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⢃⣾⣾⣿⣶⣶⣿⣦⡀⠀⠀⠀
        ⠀⠀⣠⢶⣿⣿⣿⣿⣿⠿⣿⡿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀
        ⢠⣞⣷⣾⣿⣿⣿⠟⠁⢰⣿⣷⣿⣿⣿⣽⣟⣿⣿⣿⣿⣿⣿⣿⣦⣄⠀
        ⣿⣿⣿⣿⣿⣿⠋⢀⣀⣀⣻⡿⠿⣿⣿⣿⣟⣿⣿⣿⣿⢷⣤⣿⡿⢿⡆
        ⠹⣿⣿⣿⣿⢃⡔⢉⣤⣤⣄⠉⠀⠀⠀⠉⢡⣤⣤⡌⠙⣇⢻⣿⣷⡾⠀
        ⠀⠹⣻⣿⣿⣄⠀⠸⣿⣿⣿⠇⠀⠀⠀⠀⢸⣿⣿⡿⠀⠀⠈⡿⠿⢅⠀
        ⠀⠀⢇⣿⣿⠀⠐⠢⠤⠥⠔⠂⠀⠀⠀⠀⠢⠤⠥⠤⠒⠀⠀⣶⠗⣸⠀
        ⠀⠀⠈⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣛⡵⠃⠀
        ⠀⠀⠀⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡇⠀⠀⠀
        ⠀⠀⠀⣿⣿⣿⣿⣷⣤⣄⡀⠀⠀⠀⠀⠀⢀⣀⣠⣶⣿⣿⣿⡇⠀⠀⠀
        ⠀⠀⠀⣍⣻⠋⣿⢻⣿⣿⣿⣿⡆⠀⠀⣿⣿⣿⣿⣿⠿⠛⠉⣇⠀⠀⠀
        ⠀⠀⠀⣿⣿⣼⣿⣾⣿⣿⡿⠋⡇⠀⢀⠏⢻⣿⣿⣿⣿⣿⣿⣸⠀⠀⠀
        ⠀⠀⢸⣿⣿⡿⠿⠛⠉⡹⠁⠀⠹⣄⡞⠀⠀⢻⠉⠙⠻⠿⣿⣧⣇⠀⠀
        ⠀⠀⣼⣿⣿⣇⠀⠀⢰⣥⣶⣯⣝⣿⣿⣿⣷⣦⡧⠀⠀⢰⠹⣿⣾⠀⠀
        ⠀⠀⣿⣿⣿⣿⣆⠀⠘⣾⣿⣿⣿⡟⣿⣿⣿⣿⡇⠀⢠⠇⠀⢻⣿⠀
    */
}