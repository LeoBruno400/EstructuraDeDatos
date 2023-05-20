package jerarquicas.jerarquicasDinamica;

public class ArbolBinDinamica {

    private NodoArbol raiz;

    public ArbolBinDinamica() {
        this.raiz = null;

    }

    // ---------------------Basicas---------------------

    public boolean insertar(Object elemNuevo, Object elemPadre, char hijo) {
        boolean exito = false;

        if (this.raiz == null) {
            // Si el arbol esta vacio, pone elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
            exito = true;
        } else {
            // Si el arbol no esta vacio, busca al padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if ((hijo == 'i' || hijo == 'I') && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                    exito = true;
                } else if ((hijo == 'd' || hijo == 'D') && nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    exito = true;

                }

            }
        }
        return exito;
    }

    // Metodo privado
    private NodoArbol obtenerNodo(NodoArbol nodo, Object padre) {
        NodoArbol resp = null;
        if (nodo != null) {
            if (nodo.getElem().equals(padre)) {
                resp = nodo;

            } else {
                resp = obtenerNodo(nodo.getIzquierdo(), padre);
                if (resp == null) {
                    resp = obtenerNodo(nodo.getDerecho(), padre);
                }

            }
        }
        return resp;
    }

    public boolean esVacio() {
        boolean esVacio = this.raiz == null;
        return esVacio;
    }

    public Object padre(Object hijo) {
        Object padre;
        padre = padreAux(hijo, this.raiz);
        return padre;
    }

    // Metodo privado
    private Object padreAux(Object hijo, NodoArbol nodo) {
        Object resp = null;
        if (nodo != null) {

            if ((nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(hijo))
                    || (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(hijo))) {
                resp = nodo.getElem();
            } else {
                resp = padreAux(hijo, nodo.getIzquierdo());
                if (resp == null) {
                    resp = padreAux(hijo, nodo.getDerecho());

                }
            }

        }
        return resp;
    }

    public int altura() {
        int altura = -1;
        if (!this.esVacio()) {
            altura = alturaAux(this.raiz);
        }
        return altura;
    }

    private int alturaAux(NodoArbol nodo) {
        int alturaIzq = -1, alturaDer = -1, altura;

        if (nodo.getIzquierdo() != null) {
            alturaIzq = alturaAux(nodo.getIzquierdo());
        }
        if (nodo.getDerecho() != null) {
            alturaDer = alturaAux(nodo.getDerecho());
        }

        if (alturaIzq > alturaDer) {
            altura = alturaIzq;
        } else {
            altura = alturaDer;
        }

        return altura + 1;
    }

    public int nivel(Object elem) {

        return nivelAux(elem, this.raiz);

    }

    private int nivelAux(Object elem, NodoArbol nodo) {
        int nivel = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                nivel = 0;
            } else {
                nivel = nivelAux(elem, nodo.getIzquierdo());

                if (nivel == -1) {
                    nivel = nivelAux(elem, nodo.getDerecho());
                }
                if (nivel != -1) {
                    nivel++;
                }

            }
        }

        return nivel;
    }

    public void vaciar() {
        this.raiz = null;
    }

    @Override
    public ArbolBinDinamica clone() {
        ArbolBinDinamica clon = new ArbolBinDinamica();
        if (!this.esVacio()) {
            clon.raiz = cloneAux(this.raiz);
        }

        return clon;
    }

    private NodoArbol cloneAux(NodoArbol nodo) {
        NodoArbol nuevo = new NodoArbol(nodo.getElem(), null, null);
        if (nodo.getIzquierdo() != null) {
            nuevo.setIzquierdo(cloneAux(nodo.getIzquierdo()));
        }
        if (nodo.getDerecho() != null) {
            nuevo.setDerecho(cloneAux(nodo.getDerecho()));
        }

        return nuevo;
    }

    public ListaDinamica listarPorNiveles() {
        NodoArbol actual;
        ListaDinamica lis = new ListaDinamica();
        if (this.raiz != null) {
            ColaDinamica q = new ColaDinamica();
            q.poner(this.raiz);
            while (!q.esVacia()) {
                actual = (NodoArbol) q.obtenerFrente();
                q.sacar();
                lis.insertar(actual.getElem(), lis.longitud() + 1);
                if (actual.getIzquierdo() != null) {
                    q.poner(actual.getIzquierdo());
                }
                if (actual.getDerecho() != null) {
                    q.poner(actual.getDerecho());

                }
            }
        }
        return lis;
    }

    public ListaDinamica listarPreorden() {
        ListaDinamica lis = new ListaDinamica();
        preordenAux(this.raiz, lis);
        return lis;
    }

    private void preordenAux(NodoArbol nodo, ListaDinamica lis) {
        if (nodo != null) {
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            preordenAux(nodo.getIzquierdo(), lis);
            preordenAux(nodo.getDerecho(), lis);
        }

    }

    public ListaDinamica listarInorden() {
        ListaDinamica lis = new ListaDinamica();
        inordenAux(this.raiz, lis);
        return lis;
    }

    private void inordenAux(NodoArbol nodo, ListaDinamica lis) {
        if (nodo != null) {
            inordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            inordenAux(nodo.getDerecho(), lis);
        }
    }

    public ListaDinamica listarPosorden() {
        ListaDinamica posOrden = new ListaDinamica();
        posordenAux(this.raiz, posOrden);

        return posOrden;
    }

    private void posordenAux(NodoArbol nodo, ListaDinamica lis) {

        if (nodo != null) {
            posordenAux(nodo.getIzquierdo(), lis);
            posordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }

    }

    public String toString() {
        String cadena = "";
        cadena = tustringAux(this.raiz);
        return cadena;
    }

    private String tustringAux(NodoArbol nodo) {
        String resp = "";
        if (nodo != null) {
            resp = nodo.getElem().toString();
            if (nodo.getIzquierdo() != null) {
                resp += " HI: " + nodo.getIzquierdo().getElem().toString();
            } else {
                resp += " HI: -";
            }

            if (nodo.getDerecho() != null) {
                resp += " HD: " + nodo.getDerecho().getElem().toString() + "\n";

            } else {
                resp += " HD: -\n";
            }
            resp += tustringAux(nodo.getIzquierdo());
            resp += tustringAux(nodo.getDerecho());
        }

        return resp;
    }

    public ListaDinamica frontera() {
        ListaDinamica hojas = new ListaDinamica();
        fronteraAux(this.raiz, hojas);

        return hojas;
    }

    private void fronteraAux(NodoArbol nodo, ListaDinamica hojas) {
        if (nodo != null) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                hojas.insertar(nodo.getElem(), hojas.longitud() + 1);
            }
            fronteraAux(nodo.getIzquierdo(), hojas);
            fronteraAux(nodo.getDerecho(), hojas);
        }
    }

    public ListaDinamica obtenerAncestros(Object elem) {
        ListaDinamica ancestros = new ListaDinamica();
        ancestrosAux(this.raiz, ancestros, elem);

        return ancestros;
    }

    private boolean ancestrosAux(NodoArbol nodo, ListaDinamica ancestros, Object elem) {
        boolean encontrado = false;

        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                encontrado = true;
            }

            if (!encontrado) {
                encontrado = ancestrosAux(nodo.getIzquierdo(), ancestros, elem);
                if (!encontrado) {
                    encontrado = ancestrosAux(nodo.getDerecho(), ancestros, elem);
                }
                if (encontrado) {
                    ancestros.insertar(nodo.getElem(), ancestros.longitud() + 1);
                }

            }
        }
        return encontrado;
    }

    // EJERICICO TIPO 3
    // e)
    public boolean verificarPatron(ListaDinamica patron) {

        boolean exito = verificarPatronRecursivo(this.raiz, patron, 0);
        return exito;
    }

    private boolean verificarPatronRecursivo(NodoArbol nodoPadre, ListaDinamica patron, int pos) {
        boolean exito = false;
        Object aux = patron.recuperar(pos);

        if (nodoPadre.getIzquierdo() == null && nodoPadre.getDerecho() == null) {
            if (nodoPadre.getElem().equals(aux) == true) {
                exito = true;
            }
        } else if (nodoPadre.getIzquierdo() != null) {
            if (nodoPadre.getIzquierdo().getElem().equals(aux) == true) {
                exito = verificarPatronRecursivo(nodoPadre.getIzquierdo(), patron, pos + 1);
            }
        } else {
            if (nodoPadre.getDerecho().getElem().equals(aux) == true) {
                exito = verificarPatronRecursivo(nodoPadre.getDerecho(), patron, pos + 1);
            }
        }
        return exito;
    }

    // f) ponele que esta bien xd
    public ListaDinamica fronteraEjercicio() {
        ListaDinamica fronteraLista = new ListaDinamica();
        fronteraLista = fronteraEjercicioRecursivo(this.raiz, fronteraLista);
        return fronteraLista;
    }

    private ListaDinamica fronteraEjercicioRecursivo(NodoArbol nodoPadre, ListaDinamica list) {
        if (nodoPadre.getIzquierdo() == null && nodoPadre.getDerecho() == null) {// hoja
            list.insertar(nodoPadre.getElem(), list.longitud() + 1);
        } else {
            list = fronteraEjercicioRecursivo(nodoPadre.getIzquierdo(), list);
            list = fronteraEjercicioRecursivo(nodoPadre.getDerecho(), list);
        }

        return list;
    }

}
