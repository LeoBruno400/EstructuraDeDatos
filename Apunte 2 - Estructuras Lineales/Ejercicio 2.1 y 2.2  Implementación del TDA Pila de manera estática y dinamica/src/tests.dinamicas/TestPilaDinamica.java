public class TestPilaDinamica{

    public static void main(String[] args) {

        PilaDinamica pila1 = new PilaDinamica();

        for (int i = 0; i < 5; i++) {
            pila1.apilar(i);
        }

        PilaDinamica pila2 = pila1.clone();

        System.out.println("Obtener tope Pila 1: " + pila1.obtenerTope());
        System.out.println("Verificar si esta vacia Pila 1: " + pila1.esVacia());
        System.out.println("Desapilar Pila 1: " + pila1.desapilar() + "\n" + pila1.toString());
        
        pila1.vaciar();
        System.out.println("Vaciar Pila 1: " + pila1.toString());
        System.out.println("Pila 2 clonada anteriormente con todos los elementos: " + "\n" + pila2.toString());
    }
    
}