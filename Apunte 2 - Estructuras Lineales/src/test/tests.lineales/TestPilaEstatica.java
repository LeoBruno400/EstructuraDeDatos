public class TestPilaEstatica {

     public static void main(String[] args){
        //---------------------------------------------------------------
        
        //Ejercicio 2
        PilaEstatica newPila1 = new PilaEstatica();

        for (int i = 0; i < 5; i++) {
            newPila1.apilar(i*2);
        }

        PilaEstatica newPila2 = newPila1.clone();

        // ---------------------Basicas---------------------
        //.apliar se utilizo en la repetitiva PARA

        System.out.println("Obtener tope: " + newPila1.obtenerTope());
        System.out.println("Verificar si esta vacia: " + newPila1.esVacia());
        System.out.println("Desapilar " + newPila1.desapilar() + "\n" + newPila1.toString());
        
        // ---------------------NO Basicas---------------------
        //.clone se utilizo antes y toString en todas las demas. 
        newPila1.vaciar();
        System.out.println("Vaciar Pila: " + newPila1.toString());
        System.out.println("Clonar Pila " + "\n" + newPila2.toString());
        
        //---------------------------------------------------------------

        //Ejercicio 3

        for (int i = 0; i < 5; i++) {
            newPila1.apilar((int)(Math.random()*0));
        }

        System.out.println("La random es: " + "\n" + newPila1.toString());

        System.out.println(newPila1.esCapicua() ? "Es Capicua" : "No son Capicua");

        /*Extienda la clase TestPila para comprobar que
        la misma clase Pila también funciona con elementos de tipo String.
        */
        
    }
}