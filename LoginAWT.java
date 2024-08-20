import java.awt.*;
import java.awt.event.*;

public class LoginAWT extends Frame implements ActionListener {
    private Label user, password;  //legenda
    private TextField usuario, senha;   //caixa de texto
    private Button login, cancelar;     //botões

    public LoginAWT() {
        setTitle("Tela de Login");
        setSize(400, 300);
        setLayout(new GridLayout(3, 2));

        //inicialização dos componentes
        user = new Label("Usuário:");
        password = new Label("Senha:");
        usuario = new TextField();
        senha = new TextField();
        senha.setEchoChar('*');        //ocultar os caracteres digitados da senha
        login = new Button("Login");
        cancelar = new Button("Cancelar");

        Font font = new Font("Arial", Font.PLAIN, 14);   //aumentar a fonte
        user.setFont(font);
        password.setFont(font);
        login.setFont(font);
        cancelar.setFont(font);

        add(user);
        add(usuario);
        add(password);
        add(senha);
        add(login);
        add(cancelar);

        //regularizar os botões
        login.addActionListener(this);
        cancelar.addActionListener(this);

        //método para fechar a janela
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
        setVisible(true);
    }

    //método dos botões
    public void actionPerformed(ActionEvent ae) {
        String comando = ae.getActionCommand();

        if (comando.equals("Login")) {
            String nome = usuario.getText();
            String privado = senha.getText();
            if (nome.isEmpty() || privado.isEmpty()) {
                //mensagem de erro com os campos vazios
                showMessage("Usuário ou Senha estam vazios.", "Erro");
            } else {
                //login feito
                showMessage("Login concluído!", "Concluído");
            }
        } else if (comando.equals("Cancelar")) {
            dispose();  //fecha a janela
        }
    }

    //método para exibir a mensagem
    private void showMessage(String message, String title) {
        Dialog dialog = new Dialog(this, title, true);
        dialog.setLayout(new BorderLayout());
        dialog.add(new Label(message), BorderLayout.CENTER);
        Button btnOk = new Button("OK");
        btnOk.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnOk, BorderLayout.SOUTH);
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    //método para executar o programa
    public static void main(String[] args) {
        new LoginAWT();
    }
}
