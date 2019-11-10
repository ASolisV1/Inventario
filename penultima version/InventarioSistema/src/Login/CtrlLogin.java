package Login;
// Vamos a implementar ActionListener
import Controlador.*;
import Login.FrmLogin;
import Home.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlLogin implements ActionListener {
    private ClsUsuarios mod;
    private QueryUsuarios modQ;
    private FrmLogin frm;
    // Crear el constructor
    public CtrlLogin(ClsUsuarios mod, QueryUsuarios modQ, FrmLogin frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnIngreso.addActionListener(this);
        this.frm.btnSalir.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Ingreso al Sistema");
        frm.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnIngreso) {
            mod.setUsuarionom(frm.txtUsuario.getText());
            mod.setUsuariopassword(frm.txtPassword.getText());
            if(modQ.validar(mod)){
                // datos correctos abrir Formulario Principal
                new FrmPrincipal().setVisible(true);
                frm.dispose();
                
            } else {
                //datos falsos
                JOptionPane.showMessageDialog(null,"Datos Erroneos de Login");
                limpiar();
            }
        }
    }
    public void limpiar() {
        frm.txtUsuario.setText(null);
        frm.txtPassword.setText(null);
    }
}
