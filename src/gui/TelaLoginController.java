package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController {

	@FXML
	private Button BtnEntar;

	@FXML
	private Button BtnFechar;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private TextField txtUsuario;

	public void close() {
		System.exit(0);
	}

	public void login() {
		String usuario = txtUsuario.getText();
		String senha = txtSenha.getText();

		Alert mensagem;

		if (usuario.equals("admin") && senha.equals("123")) {
			mensagem = new Alert(Alert.AlertType.CONFIRMATION);
			mensagem.setTitle("Confimarção");
			mensagem.setHeaderText(null);
			mensagem.setContentText("Bem vindo ao Sistema " + usuario);
			mensagem.showAndWait();
			
			BtnEntar.getScene().getWindow().hide();
			try {
				
				Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				
				stage.setScene(scene);
				stage.setTitle("Sistema by Jailson");
				stage.centerOnScreen();
				stage.setMaximized(true);
				stage.show();
				
			}catch(Exception e ){
				e.printStackTrace();
			}
			
			
		} else {
			mensagem = new Alert(Alert.AlertType.ERROR);
			mensagem.setTitle("Erro");
			mensagem.setHeaderText(null);
			mensagem.setContentText("Usuario ou Senha incorretos ");
			mensagem.showAndWait();

		}
	}

	@FXML
	private void initialize() {
		BtnFechar.setOnAction(event -> {
			close();
		});

		BtnEntar.setOnAction(event -> {
			login();
		});
		
		//acionar o enter no text fild usuario e acessar o passaword fild de senha
		txtUsuario.setOnAction(event -> {
			txtSenha.requestFocus();
		});
      //acionar o enter no passoword field de senha 
		txtSenha.setOnAction(event -> {
			login();
		});
	}
}
