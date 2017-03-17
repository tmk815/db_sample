package sample;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TableController implements Initializable{

    //fxmlのfx:idと紐付くもの
    public TableColumn<SampleController,String> col1;
    public TableColumn<SampleController,String> col2;
    public TableColumn<SampleController,String> col3;
    public TableColumn<SampleController,String> col4;
    public TableColumn<SampleController,String> col5;
    public TableColumn<SampleController,String> col6;
    public ComboBox<String> startyear;
    public ComboBox<String> startmonth;
    public ComboBox<String> endyear;
    public ComboBox<String> endmonth;
    public TableView<SampleController> table1;
    public Button btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //startyear,endyearにデフォルトの文字列をセット
            startyear.setValue("開始年");
            endyear.setValue("終了年");

            //ObservableListはリスナーが発生時の変更を追跡できるリスト
            ObservableList<String> startyearItems = startyear.getItems();
            ObservableList<String> endyearItems = endyear.getItems();

            //startyear,endyearに年を追加
            for (int i = 2000; i < 2015; i++) {
                String year = String.valueOf(i);
                startyearItems.add(year);
                endyearItems.add(year);
            }

            //startmonth,endmonthにデフォルトの文字列をセット
            startmonth.setValue("開始月");
            endmonth.setValue("終了月");

            //ObservableListはリスナーが発生時の変更を追跡できるリスト
            ObservableList<String> startmonthItems = startmonth.getItems();
            ObservableList<String> endmonthItems = endmonth.getItems();

            //startmonth,endmonthに月を追加
            for (int m = 1; m <= 12; m++) {
                String month = String.valueOf(m);
                startmonthItems.add(month);
                endmonthItems.add(month);
            }


            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Buttonが押された時の処理
    public void btn_syukei(ActionEvent Event){
        try {
            String url="jdbc:mysql://localhost/データベース名";
            String user="ユーザー名";
            String pass="パスワード";

            //接続にはConnectionオブジェクトを使用する
            Connection connection=(Connection) DriverManager.getConnection(url,user,pass);
            //SQL文をデータベースに送るためのStatementオブジェクトを生成する
            Statement statement=(Statement)connection.createStatement();

            //ComboBoxから内容取得
            String s_year=startyear.getValue();
            String s_month=startmonth.getValue();
            String e_year=endyear.getValue();
            String e_month=endmonth.getValue();

            String mysql="SQL文";

            //指定されたSQL文を実行する
            ResultSet resultSet=statement.executeQuery(mysql);

            //テーブルのリストを削除
            table1.getItems().clear();

            //各セルの対応プロパティを追加
            col1.setCellValueFactory(new PropertyValueFactory<SampleController, String>("value1"));
            col2.setCellValueFactory(new PropertyValueFactory<SampleController, String>("value2"));
            col3.setCellValueFactory(new PropertyValueFactory<SampleController, String>("value3"));
            col4.setCellValueFactory(new PropertyValueFactory<SampleController, String>("value4"));
            col5.setCellValueFactory(new PropertyValueFactory<SampleController, String>("value5"));
            col6.setCellValueFactory(new PropertyValueFactory<SampleController, String>("value6"));

            //表示するカラム名の設定
            col1.setText("カラム1");
            col2.setText("カラム2");
            col3.setText("カラム3");
            col4.setText("カラム4");
            col5.setText("カラム5");
            col6.setText("カラム6");

            //DBの中身がなくなるまで繰り返す
            while(resultSet.next()){
                String data1=resultSet.getString("DBのカラム名");
                String data2=resultSet.getString("DBのカラム名");
                String data3=resultSet.getString("DBのカラム名");
                String data4=resultSet.getString("DBのカラム名");
                String data5=resultSet.getString("DBのカラム名");
                String data6=resultSet.getString("DBのカラム名");

                ObservableList<SampleController> list=table1.getItems();
                list.add(new SampleController(data1,data2,data3,data4,data5,data6));
            }

            //リソースの解放
            resultSet.close();
            connection.close();
            statement.close();

        }catch (Exception e){
            System.out.println("例外発生："+e);
        }
    }
}
