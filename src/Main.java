
import javax.swing.SwingUtilities;
import vista.FrmPrincipal;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            FrmPrincipal frm = new FrmPrincipal();
            frm.setVisible(true);
        });
    }
}
