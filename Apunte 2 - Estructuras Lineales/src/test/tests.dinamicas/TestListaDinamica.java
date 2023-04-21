public class TestListaDinamica {
    public static void main(String[] args) {

        ListaDinamica lista = new ListaDinamica();
        
        //Cargamos la lista 
        for (int i = 1; i < 6; i++) {
            //Como la cargamos con numeros es elemento i y posicion i
            lista.insertar(i, i);
        }

        //Mostramos la lista
        System.out.println(lista.toString());

        // ---------------------Basicas---------------------
        //Insertar en puntos criticos
        System.out.println("Insertar en puntos criticos: \n");
        
        System.out.println("Insert en Pos 0: "+lista.insertar("Posicion cero", 1));
        
        System.out.println("Insert en Pos Final: "+lista.insertar("Posicion ultima", 7));

        System.out.println("Insert en Pos Media: "+lista.insertar("Posicion medio", 3));

        System.out.println("Insert en Pos Invalida: "+lista.insertar("Posicion Invalida", 12));

        System.out.println(lista.toString());

    }
}
 