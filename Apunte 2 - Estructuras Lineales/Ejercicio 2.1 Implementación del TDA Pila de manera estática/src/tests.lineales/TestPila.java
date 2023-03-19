public class TestPila {

     public static void main(String[] args){
        Pila newPila1 = new Pila();

        for (int i = 0; i < 5; i++) {
            newPila1.apilar(i);
        }

        Pila newPila2 = newPila1.clone();

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
        
     }
}