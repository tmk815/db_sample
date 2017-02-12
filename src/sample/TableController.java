package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable{

    //fxmlのfx:idと紐付くもの
    public ComboBox<String> startyear;
    public ComboBox<String> startmonth;
    public ComboBox<String> endyear;
    public ComboBox<String> endmonth;
    public TableView<SampleController> table1;
    public Button btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
