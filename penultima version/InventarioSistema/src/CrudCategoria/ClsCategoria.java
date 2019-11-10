
package CrudCategoria;

public class ClsCategoria {
    private int catcod;
    private String catnom;
    
    public ClsCategoria (){
      
    }
    
    public ClsCategoria (int _catcod, String _catnom){
        catcod=_catcod;
        catnom=_catnom;
    }
    
    public int getCodCateg(){
        return catcod;
    }
    
    public void setCodCateg(int _catcod){
        catcod=_catcod;
    }
    
    public String getNomCateg(){
        return catnom;
    }
    
    public void setNomCateg(String _catnom){
       catnom=_catnom;
    }
    
}
