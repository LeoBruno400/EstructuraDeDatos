public class TestCadenas{
    public static void main(String[] args){
        ColaDinamica colaTest = new ColaDinamica();
        String text1 = "AB";
        String text2 = "CD";
        String text3 = "F";
        colaTest.poner(text1);
        colaTest.poner(text2);
        colaTest.poner(text3);
        System.out.println(generarCola(colaTest).toString());
    }

    // EJERCICIO TIPO 2
    //C)
    public static ColaDinamica generarCola(ColaDinamica c1){
        ColaDinamica newCola = new ColaDinamica();
        int n = c1.longitud();
        String textoAux;

        if(c1.obtenerFrente() != null){
            for (int i = 0; i < n; i++) {
                textoAux = (String) c1.obtenerElemento(i);
                textoAux = textoAux + invertirPalabra(textoAux) + textoAux;
                newCola.poner(textoAux);
            }
        }
        return newCola;
    }

    public static String invertirPalabra(String palabra){
        int n = palabra.length();
        char ultimaLetra;
        String palabraInvertida = "";

        if(n == 0){
            return "";
        }else{
            ultimaLetra = palabra.charAt(n-1);
            palabraInvertida = palabra.substring(0, n-1);
            return ultimaLetra + invertirPalabra(palabraInvertida);
        }
    }
}