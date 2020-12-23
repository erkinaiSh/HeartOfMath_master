package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class DrawingLine extends Application {
    int[] fib = new int[1000];

    @Override
    public void start(Stage stage) {
        double radiusy = 300;
        double radiusx = 250;
        double width = 1366, height = 768;

        Circle circle = new Circle();
        circle.setCenterX(width / 2);
        circle.setCenterY(height / 2);
        circle.setRadius(radiusx);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        Line linex = new Line(width / 2 - radiusx, height / 2, width / 2 + radiusx, height / 2);
        Line liney = new Line(width / 2, height / 2 - radiusx, width / 2, height / 2 + radiusx);

        Group root = new Group();

        double n = 200;
        int h = 134;
        double k = 360 / n;
        f();
        for (int i = 0; i < n; i++) {
            double x = width / 2 + radiusx * Math.sin(Math.toRadians(i * k));
            double y = height / 2 + radiusy * Math.cos(Math.toRadians(i * k));
            double x1 = width / 2 + radiusx * Math.sin(Math.toRadians(((i * h) % n) * k));
            double y1 = height / 2 + radiusy * Math.cos(Math.toRadians(((i * h) % n) * k));
            Line line = new Line(x, y, x1, y1);
            line.setStroke(Color.GREEN);
            Circle cir = new Circle(x, y, 2);
            cir.setFill(Color.RED);
            root.getChildren().addAll(line, cir);
        }

        Scene scene = new Scene(root, width, height);
        //Setting title to the scene
        stage.setTitle("Sample application");
        stage.setFullScreen(false);
        //Adding the scene to the stage
        stage.setScene(scene);

        //Displaying the contents of a scene
        stage.show();
    }

    public void f() {
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 998; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public static void main(String args[]) {
        launch(args);
    }

}