package jerarquicas.jerarquicasEstaticas;
import jerarquicas.jerarquicasEstaticas.CeldaBin;

public class ArbolBinEstatica{

     //Atributos
     private static final int TAM = 20;
     private CeldaBin[] arbol;
     private int raiz;
 
     //Constructor
     public ArbolBin(){
         this.arbol = new CeldaBin[TAM];
         for (int i = 0; i < TAM; i++) {
             this.arbol[i] = new CeldaBin();
         }
         this.raiz = -1;
     }
}
