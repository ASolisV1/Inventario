
package CrudMarcas;


public class ClsMarcas {
    private String codMarca;
    private String nomMarca;
    
    public ClsMarcas (){  
        codMarca="";
        nomMarca="";
    }
    
    public ClsMarcas (String _codMarca, String _nomMarca){
        codMarca=_codMarca;
        nomMarca=_nomMarca;
    }
    
    public String getCodMarca(){
        return codMarca;
    }
    
    public void setCodMarca(String _codMarca){
        codMarca=_codMarca;
    }
    
    public String getNomMarca(){
        return nomMarca;
    }
    
    public void setNomMarca(String _nomMarca){
        nomMarca=_nomMarca;
    }
    
    @Override
    public String toString(){
        return "Codigo: "+this.codMarca+"\t\tNombre: "+this.nomMarca;
    }
}
