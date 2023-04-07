public class Nodo {

    private Object elem;
    private Nodo enlace;

    /* CONSTRUCTOR */
    public Nodo(Object elem,Nodo enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    /* MODIFICADORES */
    public void setElemento(Object elem){
        this.elem = elem;
    }

    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }

    /* OBSERVADORES */
    public Object getElemento(){
        return elem;
    }
    public Nodo getEnlace(){
        return enlace;
    }

    /*
        ⠀⠀⠀ ___
　　　　　／＞　　フ
　　　　　| 　_　 _|
　 　　　／` ミ＿xノ
　　 　 /　　　 　 |
　　　 /　 ヽ　　 ﾉ
　 　 │　　|　|　|
　／￣|　　 |　|　|
　| (￣ヽ＿_ヽ_)__)
　＼二つ
     */
}