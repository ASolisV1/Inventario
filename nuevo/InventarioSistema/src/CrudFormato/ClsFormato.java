/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudFormato;

/**
 *
 * @author Ysrael
 */
public class ClsFormato {
    private String codFormato;
    private String nomFormato;
    
    public ClsFormato (){
        codFormato="";
        nomFormato="";
    }
    
    public ClsFormato (String _codFormato, String _nomFormato){
        codFormato=_codFormato;
        nomFormato=_nomFormato;
    }
    
    public String getCodFor(){
        return codFormato;
    }
    
    public void setCodFor(String _codFormato){
        codFormato=_codFormato;
    }
    
    public String getNomFor(){
        return nomFormato;
    }
    
    public void setNomFor(String _nomFormato){
        nomFormato=_nomFormato;
    }
    
}
