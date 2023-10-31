package aluno;


import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoTela extends Application{
	private TextField txtId = new TextField ();
	private TextField txtRa = new TextField ();
	private TextField txtNome = new TextField ();  
	private TextField txtNasc = new TextField (); 
	private AlunoControl control = new AlunoControl();

	@Override
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
        pane.setHgap(8);
        pane.setVgap(8);
        pane.setPadding(new Insets(6));
       
        Scene scene = new Scene (pane, 400,200);
		 Label id = new Label ("Id:");
		 Label ra = new Label ("Ra:");
		 Label nome = new Label ("Nome:"); 
		 Label nasc = new Label ("Nascimento:");
		 txtId = new TextField ();
	     txtRa = new TextField ();
	     txtNome = new TextField ();  
	     txtNasc = new TextField(); 
	     Button add =new Button("Adicionar");
	     Button pesquisar =new Button("Pesquisar");
	     
	     add.setOnMouseClicked( 
	             e-> { 
	                 control.adicionar( toEntity() );
	                 
	                 clearBoundary();
	             }
	         );

	     pesquisar.setOnMousePressed(
	             e -> { 
	                 Aluno a = control.pesquisar( txtNome.getText() );
	                 fromEntity(a);
	                
	             }
	         );
	        pane.addRow(0, id, txtId);
	        pane.addRow(1, ra, txtRa);
	        pane.addRow(2, nome, txtNome);
	        pane.addRow(3, nasc, txtNasc);
	       
	        pane.addRow(4, add);
	        pane.addRow(4, pesquisar);  

	       stage.setTitle("Gestão de Alunos");
	       stage.setScene(scene);
	       stage.show();
	}

	public void clearBoundary() {
		    txtId.setText("");
		    txtRa.setText("");
	        txtNome.setText("");
	        txtNasc.setText(""); 
	    
	    }

	    public Aluno toEntity() { 
	    	
	        Aluno a = new Aluno();
	        a.setId(txtId.getText());
	        a.setRa(txtRa.getText());
	        a.setNome(txtNome.getText());
	        a.setNasc(txtNasc.getText());
	        return a;
	    }

	    public void fromEntity(Aluno a) { 
	        if (a != null) {
	        	txtId.setText(a.getId());
	        	txtRa.setText(a.getRa());
	            txtNome.setText(a.getNome());
	            txtNasc.setText(a.getNasc() != null ? a.getNasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "");
	        } else { 
	            Alert al = new Alert(
	                AlertType.INFORMATION, 
	                    "Aluno não encontrado", 
	                    new ButtonType("Ok")
	            );
	            al.show();
	        }
	    }
	 public static void main(String[] args) {
    	 Application.launch(args);
    }
}
