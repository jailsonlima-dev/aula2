package gui;



import model.funcionarioModel;
import model.produtoDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.produtoModel;

public class produtoController {

	 @FXML
	    private Button BtnCancelar;

	    @FXML
	    private Button BtnEXcluir;

	    @FXML
	    private Button BtnEditar;

	    @FXML
	    private Button BtnNovo;

	    @FXML
	    private Button BtnSair;

	    @FXML
	    private Button BtnSalvar;

	    @FXML
	    private TableColumn<produtoModel, String> colDescricao;

	    @FXML
	    private TableColumn<produtoModel, String> colID;

	    @FXML
	    private AnchorPane formCadastro;

	    @FXML
	    private TableView<produtoModel> tableDados;

	    @FXML
	    private TextField txtBuscar;
	    
	    @FXML
	    private TextField txtData;

	    @FXML
	    private TextField txtDescricao;

	    @FXML
	    private TextField txtEstoque;

	    @FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtPreco;

	    
	    private ObservableList<produtoModel> FuncionarioList;
	    
	    @FXML
		public void initialize() {
			super.init();

			colID.setCellValueFactory(
					data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getIdProduto()).asObject());

			colDescricao
					.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNome()));

			carregarDados(null);

			tableDados.getSelectionModel().selectedItemProperty().addListener((obs, selecao, novaSelecao) -> {
				if (novaSelecao != null) {
					txtNome.setText(novaSelecao.getNome());
					txtDescricao.setText(novaSelecao.getDescricao());
					txtEstoque.setText(String.valueOf(novaSelecao.getEstoque()));
					txtPreco.setText(novaSelecao.getPreco());
					txtDataCadastro.setText(novaSelecao.get());
					txtUsuario.setText(novaSelecao.getUsuario());
					txtSenha.setText(novaSelecao.getSenha());
					txtDataCadastro.setText(novaSelecao.getDataCadastro().toString());
				}

			});
			
		}
	    
}
