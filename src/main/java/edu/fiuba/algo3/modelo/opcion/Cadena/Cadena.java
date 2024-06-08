package edu.fiuba.algo3.modelo.opcion.Cadena;




public abstract class Cadena {
    protected String descripcion;
    protected Cadena siguiente;

    public Cadena(String descripcion, Cadena siguiente ){
        this.descripcion=descripcion;
        this.siguiente=siguiente;
    }
    public Cadena(String descripcion){
        this.descripcion=descripcion;
        this.siguiente=new Nula(descripcion);
    }
    protected Cadena(){}
    
    public void asignarSiguiente(Cadena siguiente){
        this.siguiente=siguiente;
    }


    public boolean equals(Cadena cadena) {
        return (descripcion.equals(cadena.descripcion)
                &&
                siguiente.equals(cadena.siguiente));
    }


}