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
            if(n.getElemento().equals(buscado)){
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


}
