public class ListaDinamica {

    private Nodo cabecera;

    // Constructor
    public ListaDinamica() {
        cabecera = null;
    }

    // ---------------------Basicas---------------------

    public boolean insertar(Object elemento, int pos) {
        boolean exito = false;

        if (pos > 0 && pos < this.longitud() + 1) { // Si esta en el rango, lo va a guardar
            if (pos == 1) { // Si quiere insertar en la primer posicion, se ata a la cabecera
                this.cabecera = new Nodo(elemento, this.cabecera);
            } else { // Avanza hasta el elemento en pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < (pos - 1)) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            exito = true;
        }

        return exito;

    }

    public boolean eliminar(int pos) {
        boolean exito = false;

        if (pos > 0 && pos < this.longitud() + 1) { // Si esta en el rango, lo va a eliminar
            if (pos == 1) { // Si quiere eliminar en la primer posicion, se cambia la cabecera
                this.cabecera = this.cabecera.getEnlace();
            } else { // Avanza hasta el elemento en pos-1
                Nodo auxPosDada = this.cabecera;
                Nodo auxPosDadaMenosUno = auxPosDada; // Inicializado y creado para dejar feliz al IDE
                int i = 1;
                while (i < pos) {
                    auxPosDadaMenosUno = auxPosDada;
                    auxPosDada = auxPosDada.getEnlace(); // obtener el enlace del siguiente.
                    i++;
                }
                auxPosDadaMenosUno.setEnlace(auxPosDada.getEnlace()); // O lo haces re sas:
                                                                      // aux.setEnlace(aux.getEnlace().getEnlace()),
                                                                      // recorriendo hasta pos-1
            }
            exito = true;
        }

        return exito;
    }

    public Object recuperar(int pos) {
        Object elemRecuperado = null; // Si la posicion no es valida, devolvera un elemento null

        if (pos > 0 && pos < this.longitud() + 1) { // Verifica que sea una posicion valida
            Nodo nodoAux = this.cabecera;
            int i = 1;
            while (i < pos) {
                nodoAux = nodoAux.getEnlace();
                i++;
            }
            elemRecuperado = nodoAux.getElemento();
        }

        return elemRecuperado;
    }

    public int localizar(Object elemBuscado) {
        int pos = -1; // Posición inicialmente establecida en -1 (no encontrado)
        int i = 1; // Índice del elemento actual
        boolean elemEncontrado = false; // Variable para indicar si el elemento fue encontrado
        Nodo nodoAux = this.cabecera; // Nodo auxiliar para recorrer la lista

        while (i < this.longitud() + 1 && !elemEncontrado) { // Recorrer la lista mientras no se llegue al final y no se haya encontrado el elemento
            if (elemBuscado == nodoAux.getElemento()) { // Si el elemento buscado es igual al elemento del nodo actual
                pos = i; // Se actualiza la posición con el índice actual
                elemEncontrado = true; // Se marca el elemento como encontrado
            }
            nodoAux = nodoAux.getEnlace(); // Avanzar al siguiente nodo
            i++; // Incrementar el índice
        }

        return pos; // Devolver la posición del elemento (puede ser -1 si no se encontró)
    }

    public boolean esVacia() {
        boolean vacia = true;
        if (this.cabecera != null) {
            vacia = false;
        }
        return vacia;
    }

    // ---------------------NO Basicas---------------------

    public void vaciar() {
        this.cabecera = null;
    }

    public int longitud() {
        int contador = 0;

        if (this.cabecera != null) {
            contador++; // +1 por la cabecera y +1 por cada nodo recorrido por while.
            while (this.cabecera.getEnlace() != null) {
                contador++;
            }
        }

        return contador;
    }

    @Override
    public ListaDinamica clone() {

        ListaDinamica listaClon = new ListaDinamica();

        if (this.cabecera != null) {
            int i = 1;
            // Creamos el primer nodo de la Lista clonada
            Nodo nodoClonado = new Nodo(this.cabecera.getElemento(), null);
            listaClon.cabecera = nodoClonado;
            // Iteramos sobre los nodos restantes de la Lista original
            Nodo nodoActual = this.cabecera.getEnlace();
            while (i < this.longitud() + 1) {
                // Creamos un nuevo nodo en la Lista clonada
                Nodo nuevoNodo = new Nodo(nodoActual.getElemento(), null);
                // Enlazamos el nuevo nodo con el último nodo de la Lista clonada
                nodoClonado.setEnlace(nuevoNodo);
                // Actualizamos el último nodo de la Lista clonada
                nodoClonado = nuevoNodo;
                nodoActual = nodoActual.getEnlace();
            }
        }

        return listaClon;
    }

    @Override
    public String toString() {
        String texto = "[";

        if (this.cabecera != null) { // Si la Lista NO esta vacia
            Nodo aux = this.cabecera;
            int i = 1;

            while (i < this.longitud() + 1) {
                texto += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    texto += ",";
                }
            }
            texto += "]";

        } else { // Si la Lista esta VACIA
            texto = "La Lista esta VACIA";
        }

        return texto;
    }

    // EJERCICIO TIPO 1
    // A)
    public ListaDinamica obtenerMultiplos(int num) {
        ListaDinamica listaNew = new ListaDinamica();
        Nodo nodoAux = this.cabecera;
        int i = 1, j = 0;

        if (this.cabecera != null) {
            while (i < this.longitud() + 1) {
                if (i % num == 0) {
                    listaNew.insertar(nodoAux.getElemento(), j);
                    j++;
                }
                nodoAux = nodoAux.getEnlace();
                i++;
            }
        }
        return listaNew;
    }

    // B)
    public boolean eliminarApariciones(Object x) {
        boolean exito = true;
        Nodo nodoAux1 = this.cabecera;
        Nodo nodoAux2 = this.cabecera;
        int i = 1;

        if (this.cabecera != null) {
            while (i < this.longitud() + 1) {
                if (nodoAux1.getElemento().equals(x)) {
                    if (nodoAux1.equals(nodoAux2)) {
                        this.cabecera = this.cabecera.getEnlace();
                        nodoAux1 = nodoAux1.getEnlace();
                        nodoAux2 = nodoAux2.getEnlace();
                    } else {
                        nodoAux2.setEnlace(nodoAux1.getEnlace());
                        nodoAux1 = nodoAux2.getEnlace();
                    }
                } else {
                    if (nodoAux1.equals(nodoAux2)) {
                        nodoAux1 = nodoAux1.getEnlace();
                    } else {
                        nodoAux2 = nodoAux1;
                        nodoAux1 = nodoAux1.getEnlace();
                    }
                }
            }

        }
        return exito;
    }

}
