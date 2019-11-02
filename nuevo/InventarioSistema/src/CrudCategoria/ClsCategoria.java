
package CrudCategoria;

public class ClsCategoria {
    private String codCategoria;
    private String nomCategoria;
    
    public ClsCategoria (){
        codCategoria="";
        nomCategoria="";
    }
    
    public ClsCategoria (String _codCategoria, String _nomCategoria){
        codCategoria=_codCategoria;
        nomCategoria=_nomCategoria;
    }
    
    public String getCodCateg(){
        return codCategoria;
    }
    
    public void setCodCateg(String _codCategoria){
        codCategoria=_codCategoria;
    }
    
    public String getNomCateg(){
        return nomCategoria;
    }
    
    public void setNomCateg(String _nomCategoria){
        nomCategoria=_nomCategoria;
    }
    
}
