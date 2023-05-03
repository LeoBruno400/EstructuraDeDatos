package jerarquicas.jerarquicasDinamica;

public class ArbolBinDinamica {

    //Atributos
    private NodoArbol raiz;
    
    //Constructor
    public ArbolBinDinamica(){
        this.raiz = null;
    }

    //Propias del tipo
    // ---------------------Basicas---------------------

    //Metodo Privado Auxiliar
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        /*Busca un elemento y devuelve el nodo que lo contiene.
         *Si no se encuentra buscado devuelve null*/
        NodoArbol resultado = null;
        if(n != null){
            if(n.getElem().equals(buscado)){
                //Si el buscado es n, lo devuelve
                resultado = n;
            }else{
                //NO es el buscado: Busca primero el HIJO IZQUIERDO
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //Si no lo encontro en el HI: Busca en el HIJO DERECHO
                if(resultado == null){
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char posicion){

        boolean exito = true;

        if(this.raiz == null){
            //Si el arbol esta vacio, pone elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        }else{
            //Si arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            //Si padre existe y lugar no esta ocupado lo pone, sino da erro
            if(nPadre != null){
                if (posicion == 'I' && nPadre.getIzquierdo() == null){
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                }else if (posicion == 'D' && nPadre.getDerecho() == null){
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                }else{
                    exito = false;
                }
            }else{
                exito  = false;
            }
        }
        return exito;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public boolean existe(Object elemBuscado) {
        boolean existe = false;
        existe = buscarPreorden(this.raiz, elemBuscado);
        return existe;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private boolean buscarPreorden(NodoArbol nodo, Object elemBuscado) { // HAY QUE PROBAR QUE ANDE EN EL TEST
        boolean existe = false;
        if (nodo != null) {
            // Visita el elemento en el nodo
            existe = (nodo.getElem().equals(elemBuscado));
            // Recorre a sus hijos en Preorden
            if (!existe) {
                existe = buscarPreorden(nodo.getIzquierdo(), elemBuscado); // (2)
                if (!existe) {
                    existe = buscarPreorden(nodo.getDerecho(), elemBuscado); // (3)
                }
            }

        }

        return existe;
    }

    public Object padre(Object elemHijo) {
        Object elemPadre = null;
        elemPadre = buscarPadrePreorden(this.raiz, elemHijo);
        return elemPadre;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private Object buscarPadrePreorden(NodoArbol nodo, Object elemHijo) { // HAY QUE PROBAR QUE ANDE EN EL TEST
        Object elemPadre = null;
        boolean existe = false;
        if (nodo != null) {
            // Pregunta si el HI es el elemBuscado
            existe = (nodo.getIzquierdo().equals(elemHijo));
            if (!existe) {
                // Pregunta si el HD es el elemBuscado
                existe = (nodo.getDerecho().equals(elemHijo));
            }
            // Recorre a sus hijos en Preorden
            if (!existe) {
                existe = buscarPreorden(nodo.getIzquierdo(), elemHijo); // (2)
                if (!existe) {
                    existe = buscarPreorden(nodo.getDerecho(), elemHijo); // (3)
                }
            } else {
                elemPadre = nodo.getElem();
            }

        }

        return elemPadre;
    }

    public Object hijoIzquierdo(Object elemPadre) {
        Object elemHI = null;
        elemHI = buscarHijoPreorden(this.raiz,elemPadre);
        if(elemHI != null) elemHI = ((NodoArbol) elemHI).getIzquierdo();
        return elemHI;
    }

    public Object hijoDerecho(Object elemPadre) {
        Object elemHD = null;
        elemHD = buscarHijoPreorden(this.raiz, elemPadre);
        if(elemHD != null) elemHD = ((NodoArbol) elemHD).getDerecho();
        return elemHD;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private Object buscarHijoPreorden(NodoArbol nodo, Object elemPadre) { // HAY QUE PROBAR QUE ANDE EN EL TEST
        Object padre = null; 
        boolean existe = false;

        if (nodo != null) {
            // Pregunta si el NODO en el que estas tiene el elemBuscado, o sea, si es el padre
            existe = (nodo.getElem().equals(elemPadre));

            // Recorre a sus hijos en Preorden
            if (!existe) {
                existe = buscarPreorden(nodo.getIzquierdo(), elemPadre); // (2)
                if (!existe) {
                    existe = buscarPreorden(nodo.getDerecho(), elemPadre); // (3)
                }
            } else {
                padre = nodo.getElem();
            }

        }

        return padre;
    }

    public int altura() {
        int altura = 0;

        return altura;
    }

    public int nivel(Object elemBuscado) {
        int nivel = 0;

        return nivel;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public ArbolBinDinamica clone() {
        ArbolBinDinamica arbolClon = new ArbolBinDinamica();
        if(this.raiz != null){
            cloneRecursivo(this.raiz, arbolClon);
        }
        return arbolClon;
    }

    private ArbolBinDinamica cloneRecursivo(NodoArbol nodo, ArbolBinDinamica arbolClon){
        if(nodo != null){
            arbolClon.insertar(nodo.getElem(),,);
            cloneRecursivo(nodo.getIzquierdo(), arbolClon);
            cloneRecursivo(nodo.getDerecho(), arbolClon);
        }
    }

    public String toString() {
        String texto = "Arbol VACIO";
        texto = listarPreorden().toString();
        return texto;
    }

    /* LISTADOS */

    /* Hojas */

    public Lista listarHojas() {
        Lista lis = new Lista();

        return lis;
    }

    /* Ancestros */

    public Lista listarAncestros(Object elem) {
        Lista lis = new Lista();

        return lis;
    }

    /* Camino más largo */

    public Lista listarCaminoMasLargo() {
        Lista lis = new Lista();

        return lis;
    }

    /* Preorden */

    public Lista listarPreorden() {
        // Retorna una lista con los elementos del árbon en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            // Visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); // (1)
            // Recorre a sus hijos en Preorden
            listarPreordenAux(nodo.getIzquierdo(), lis); // (2)
            listarPreordenAux(nodo.getDerecho(), lis); // (3)
        }
    }

    /* Posorden */

    public Lista listarPosorden() {
        // Retorna una lista con los elementos del árbon en POSORDEN
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private void listarPosordenAux(NodoArbol nodo, Lista lis) {// HAY QUE VERIFICAR QUE ANDE EN EL TEST
        if (nodo != null) {
            // Visito siempre el izquierdo primero
            listarPreordenAux(nodo.getIzquierdo(), lis); // (1)
            // Cuando llego al mas izquierdo, lo listo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); // (2)
            // Despues visito el derecho
            listarPreordenAux(nodo.getDerecho(), lis); // (3)
        }
    }


}
