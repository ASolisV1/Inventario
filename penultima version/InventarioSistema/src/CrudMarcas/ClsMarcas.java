
package CrudMarcas;


public class ClsMarcas {
    private int marcod;
    private String marnom;
    
    public ClsMarcas (){  
       
    }
    
    public ClsMarcas (int _codMarca, String _nomMarca){
        marcod=_codMarca;
        marnom=_nomMarca;
    }
    
    public int getCodMarca(){
        return marcod;
    }
    
    public void setCodMarca(Integer _codMarca){
        marcod=_codMarca;
    }
    
    public String getNomMarca(){
        return marnom;
    }
    
    public void setNomMarca(String _nomMarca){
        marnom=_nomMarca;
    }
    
    @Override
    public String toString(){
        return "Codigo: "+this.marcod+"\t\tNombre: "+this.marnom;
    }
}
