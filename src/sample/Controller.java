package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private ColorPicker bgcolor, lcolor, pcolor;
    @FXML
    private RadioButton lradio, iradio;
    @FXML
    private TextField npTF, NTF;
    @FXML
    private AnchorPane pane;
    @FXML
    private Slider slider;

    private double n;
    private double radius;
    private double N;
    private double k;
    private double m;
    private double m1;
    private Color lColor;
    private Color pColor;
    private void general(){
        pane.getChildren().clear();
        Color selectedColor = bgcolor.getValue();
        pane.setBackground(new Background(new
                BackgroundFill(Paint.valueOf(selectedColor.toString()),
                CornerRadii.EMPTY, Insets.EMPTY)));
        lColor = lcolor.getValue();
        pColor = pcolor.getValue();
        n  = Double.parseDouble(npTF.getText());
        radius  = slider.getValue();
        N  = Double.parseDouble(NTF.getText());
        k = 360/n;
        m = 765/radius;
        m1 = 765/n;
    }

    private void fun(){
        double width = 600, height = 600;
        for (int i = 0; i<n; i++){
            System.out.println("Point " + i + " is connected with point "+ (int) ((i*N)%n)+".");
            double x = width/2 + radius*Math.sin(Math.toRadians(i*k));
            double y = height/2 + radius*Math.cos(Math.toRadians(i*k));
            double x1 = width/2 + radius*Math.sin(Math.toRadians(((i*N)%n)*k));
            double y1 = height/2 + radius*Math.cos(Math.toRadians(((i*N)%n)*k));
            Line line = new Line(x, y, x1, y1);
            line.setStroke(lColor);
            Circle cir = new Circle(x, y, 1.5);
            cir.setFill(pColor);
            pane.getChildren().addAll(line, cir);
        }
    }
    private void funl(){
        double width = 600, height = 600;
        for (int i = 0; i<n; i++){
            System.out.println("Point " + i + " is connected with point "+ (int) ((i*N)%n)+".");
            double x = width/2 + radius*Math.sin(Math.toRadians(i*k));
            double y = height/2 + radius*Math.cos(Math.toRadians(i*k));
            double x1 = width/2 + radius*Math.sin(Math.toRadians(((i*N)%n)*k));
            double y1 = height/2 + radius*Math.cos(Math.toRadians(((i*N)%n)*k));
            Line line = new Line(x, y, x1, y1);
            double d = Math.sqrt(Math.pow((x-x1), 2) + Math.pow((y-y1), 2))*m;
            int c = (int) (d-0.9999999999999);
            int s = c%255; Color c1;
            if (0<=c & c<=255){
                c1 = Color.rgb(255, s, 0);
            }else if (255<c & c<=510){
                c1 = Color.rgb(255-s,255,0);
            }else if (510<c & c<=765) {
                c1 = Color.rgb(0,255,s);
            }else if (765<c & c<=1020) {
                c1 = Color.rgb(0, 255-s, 255);
            }else if (1020<c & c<=1275) {
                c1 = Color.rgb(s, 0, 255);
            }else{
                c1 = Color.rgb(255, 0, 255-s);
            }
            line.setStroke(c1);
            pane.getChildren().addAll(line);
        }
    }

    private void funi(){
        double width = 600, height = 600;
        for (int i = 0; i<n; i++){
            System.out.println("Point " + i + " is connected with point "+ (int) ((i*N)%n)+".");
            double x = width/2 + radius*Math.sin(Math.toRadians(i*k));
            double y = height/2 + radius*Math.cos(Math.toRadians(i*k));
            double x1 = width/2 + radius*Math.sin(Math.toRadians(((i*N)%n)*k));
            double y1 = height/2 + radius*Math.cos(Math.toRadians(((i*N)%n)*k));
            Line line = new Line(x, y, x1, y1);
            double d = m1*i;
            int c = (int) (d);
            int s = c%255; Color c1;
            if (0<=c & c<=255){
                c1 = Color.rgb(255, s, 0);
            }else if (255<c & c<=510){
                c1 = Color.rgb(255-s,255,0);
            }else if (510<c & c<=765) {
                c1 = Color.rgb(0,255,s);
            }else if (765<c & c<=1020) {
                c1 = Color.rgb(0, 255-s, 255);
            }else if (1020<c & c<=1275) {
                c1 = Color.rgb(s, 0, 255);
            }else{
                c1 = Color.rgb(255, 0, 255-s);
            }
            line.setStroke(c1);
            pane.getChildren().addAll(line);
        }
    }


    @FXML
    void ChangeBGColor(ActionEvent event) {
        general();
        if (lradio.isSelected()) {
            funl();
        }else if (iradio.isSelected()){
            funi();
        }else{
            fun();
        }
    }

    @FXML
    void ChangeLColor(ActionEvent event) {
        general();
        if (lradio.isSelected()) {
            funl();
        }else if (iradio.isSelected()){
            funi();
        }else{
            fun();
        }
    }


    @FXML
    void ChangePColor(ActionEvent event) {
        general();
        if (lradio.isSelected()) {
            funl();
        }else if (iradio.isSelected()){
            funi();
        }else{
            fun();
        }
    }

    @FXML
    public void runButtonPressed(ActionEvent event) throws IOException {
        general();
        if (lradio.isSelected()) {
            funl();
        }else if (iradio.isSelected()){
            funi();
        }else{
            fun();
        }
    }

    private FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("C:\\"));
    }

    public void saveButtonPressed(ActionEvent event) throws IOException {
        WritableImage image = pane.snapshot(new SnapshotParameters(), null);

        fileChooser.setTitle("Save Image File");
        fileChooser.setInitialFileName("myCircle");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG Files", "*.png"),
                new FileChooser.ExtensionFilter("GIF Files", "*.gif"),
                new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg"),
                new FileChooser.ExtensionFilter("BMP Files", "*.bmp"));

        File file = fileChooser.showSaveDialog(null);
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
    }

    public void changeRadius(MouseEvent mouseEvent) {
        general();
        if (lradio.isSelected()) {
            funl();
        }else if (iradio.isSelected()){
            funi();
        }else{
            fun();
        }
    }

    public void Iradio(ActionEvent event) {
        general();
        funi();
    }

    public void Lradio(ActionEvent event) {
        general();
        funl();
    }

    public void Cradio(ActionEvent event) {
        general();
        fun();
    }
}