package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FormularioController {
	@FXML
	protected Button BtnCancelar;

	@FXML
	protected Button BtnEXcluir;

	@FXML
	protected Button BtnEditar;

	@FXML
	protected Button BtnNovo;

	@FXML
	protected Button BtnSair;

	@FXML
	protected Button BtnSalvar;

	@FXML
	protected TableColumn<?, ?> colDescricao;

	@FXML
	protected TableColumn<?, ?> colID;

	@FXML
	protected AnchorPane formCadastro;

	@FXML
	protected TableView<?> tableDados;

	@FXML
	protected TextField txtBuscar;

	protected int statusForm;

	@FXML
	protected void Sair() {
		try {
			// pega a cena da jenela atual
			Stage stage = (Stage) BtnSair.getScene().getWindow();

			// localizar o form
			AnchorPane form = (AnchorPane) stage.getScene().lookup("#form");

			// carrega inicio sistema
			Parent fxml = FXMLLoader.load(getClass().getResource("planoFundo.fxml"));
			form.getChildren().setAll(fxml);

			form.setTopAnchor(fxml, 0.0);
			form.setBottomAnchor(fxml, 0.0);
			form.setLeftAnchor(fxml, 0.0);
			form.setRightAnchor(fxml, 0.0);

			stage.setTitle("Sistema| Página Inicial");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void init() {// Metodo initialize
		carregarDados(null);
		
		txtBuscar.setOnAction(e -> {carregarDados(txtBuscar.getText());});
		
		BtnSair.setOnAction(e-> {Sair();});
		
		BtnNovo.setOnAction(e -> {
			statusForm=1;
			emEdicao(true);
			habilitaCampos(true);
			limparCampos();
			});
		
		BtnEditar.setOnAction(e-> {
			statusForm=2;
			emEdicao(true);
			habilitaCampos(true);
		});
		
		BtnSalvar.setOnAction(e-> {Salvar();});
		
		BtnCancelar.setOnAction(e-> {carregarDados(null);});
		
		BtnEXcluir.setOnAction(e-> {Excluir();});
		
		formCadastro.sceneProperty().addListener((obs, oldscene, newScene) -> {
			if (newScene != null) {
				newScene.setOnKeyPressed(e -> {
					KeyCode Key = e.getCode();

					switch (Key) {
					case ESCAPE:
						Sair();
						break;
					default:
						break;
					}

				});

			}

		});
	}

	protected void habilitaCampos(boolean status) {
		for (javafx.scene.Node node : formCadastro.getChildren()) {
			if (node instanceof TextField) {
				((TextField) node).setDisable(!status);

			}
		}
	}

	protected void limparCampos() {
		for (javafx.scene.Node node : formCadastro.getChildren()) {
			if (node instanceof TextField) {
				((TextField) node).clear();
			}
		}
	}

	protected void emEdicao(boolean status) {

		if (!status) {
			statusForm = 0;

		}

		BtnNovo.setDisable(status);
		BtnEditar.setDisable(status);
		BtnEXcluir.setDisable(status);
		BtnCancelar.setDisable(!status);
		BtnSalvar.setDisable(!status);

	}
	
	protected void carregarDados(String id) {
		
	}
	
	protected void Salvar() {
		
	}
	
	protected void Excluir() {
		
	}


}
