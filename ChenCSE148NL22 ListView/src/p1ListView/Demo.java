package p1ListView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label response = new Label("Select a college or University: ");
		ListView<String> lvColleges;
		Text title = new Text("NY Colleges and Universities");
		title.setFill(Paint.valueOf("#2A5058"));
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		FlowPane root = new FlowPane(10, 10);
		root.setAlignment(Pos.CENTER);
		
		// observableList will invoke an event when something is called from it, unlike arraylist.
		ObservableList<String> colleges = FXCollections.observableArrayList("Stony Brook", "NYU",
							"Nassau CCC",  "Columbia", "Binghamton", "Buffalo", "SCCC"); 
		// put the list into the listView.
		lvColleges = new ListView<String>(colleges);
		lvColleges.setPrefSize(300, 150);
		
		// next two lines allows for multiple or only one selection at a time.
		MultipleSelectionModel<String> lvSelModel = lvColleges.getSelectionModel();
		lvSelModel.setSelectionMode(SelectionMode.MULTIPLE);
		lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				response.setText("You selected " + newValue);
				System.out.println(newValue  + " is selected");
			}
			
		});
		
		// order indicates order of how things are shown, at least in flowpane
		root.getChildren().add(title);
		root.getChildren().add(lvColleges);
		root.getChildren().add(response);
		
		// put flowpane in scene
		Scene scene = new Scene(root, 350, 300);
		
		// make stage and put scene on it, then show stage.
		primaryStage.setTitle("List View");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}