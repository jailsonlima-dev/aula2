package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class principalContrtoller {

	@FXML
	private AnchorPane form;

	@FXML
	private void initialize() {

	}

	private void carregarTelas(String fxmlFile, String tituloFuncionalidade) {
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource(fxmlFile));
			form.getChildren().clear();
			form.getChildren().add(fxml);

			form.setTopAnchor(fxml, 0.0);
			form.setBottomAnchor(fxml, 0.0);
			form.setLeftAnchor(fxml, 0.0);
			form.setRightAnchor(fxml, 0.0);

			Scene cena = form.getScene();
			if (cena != null) {
				Stage stage = (Stage) cena.getWindow();
				stage.setTitle(tituloFuncionalidade);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@FXML
	private void close() {
		System.exit(0);
	}
	
	@FXML
	public void loggout() {
		Stage stageAtual = (Stage) form.getScene().getWindow();
		stageAtual.close();
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
			Stage stageLogin = new Stage (); 
			stageLogin.setScene(new Scene(root));
			stageLogin.centerOnScreen();
			stageLogin.show();
					
			
		}catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	public void abrirCadastro() {
		carregarTelas("formulario.fxml", "Cadastro");
	}
	
	public void abrirPaginaInicial() {
		carregarTelas("planoFundo.fxml", "Sistema | Página Inicial");
	}
	
	public void abrirFuncionario() {
		carregarTelas("funcionario.fxml", "Sistema | Cadastro de Funcionarios");
	}
}
