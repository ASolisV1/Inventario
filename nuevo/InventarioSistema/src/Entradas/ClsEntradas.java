package Entradas;

import MantProductos.*;
import Modelo.*;

public class ClsEntradas {
    private int clienteid;
    private int personaid;
    private String clientetel;
    private String clientecorr;
    private String clientedir;
    private int  clientecod;

    public ClsEntradas() {
    }

    public ClsEntradas(int clienteid, int personaid, String clientetel, String clientecorr, String clientedir, int clientecod) {
        this.clienteid = clienteid;
        this.personaid = personaid;
        this.clientetel = clientetel;
        this.clientecorr = clientecorr;
        this.clientedir = clientedir;
        this.clientecod = clientecod;
    }
    public int getClienteid() {
        return clienteid;
    }
    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }
    public int getPersonaid() {
        return personaid;
    }
    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }
    public String getClientetel() {
        return clientetel;
    }
    public void setClientetel(String clientetel) {
        this.clientetel = clientetel;
    }
    public String getClientecorr() {
        return clientecorr;
    }
    public void setClientecorr(String clientecorr) {
        this.clientecorr = clientecorr;
    }
    public String getClientedir() {
        return clientedir;
    }
    public void setClientedir(String clientedir) {
        this.clientedir = clientedir;
    }
    public int getClientecod() {
        return clientecod;
    }
    public void setClientecod(int clientecod) {
        this.clientecod = clientecod;
    }
}
