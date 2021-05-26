import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class NewStageTest extends Stage {
    public static Stage NewStage;

    public NewStageTest( Stage oya ){
        super();
        NewStage = oya;
        Pane pane = new Pane();
        Button b1 = new Button("子ステージ");
        try{
            pane = (Pane)FXMLLoader.load(NewStageTest.class.getResource("Ark.fxml"));
        } catch (Exception e){
            System.err.println(e);
        }

        Scene scene = new Scene(pane);
        this.setX( oya.getX() + 30);
        this.setY( oya.getY() + 30);
        this.setScene(scene);
        this.show();
    }
    //読み込むfxmlを変えるためのもの
    public static void changeSceneByFXML(String name) throws IOException {
        changeScene(new Scene(getFXMLLoader(name).load()));
    }

    //読み込んだら変えるやつ
    public static void changeScene(Scene s) {
        NewStage.setScene(s);
        NewStage.show();
    }

    public static Scene getCurrentScene() {
        return NewStage.getScene();
    }

    public static FXMLLoader getFXMLLoader(String name) {
        return new FXMLLoader(NewStageTest.class.getResource(name));
    }

}
