package com.example.threebody;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Simulator extends Application {
    double gravityConst = Math.pow(10, -11) * 6.674;
    ArrayList<Planet> planets = new ArrayList<>();
    Group root;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("3body");
        stage.setScene(scene);
        stage.show();
        spawner();
        simulator();
    }

    void spawner() {
        Planet pln1 = new Planet(500, 500, 900000000, 1,0,0.01,0);
        Planet pln2 = new Planet(223, 60, 900000000, 0, 0, 0, 0);
        Planet pln3 = new Planet(674, 233, 900000000, 0, 0, 0, 0);
        planets.add(pln1);
        planets.add(pln2);
        planets.add(pln3);
        root.getChildren().addAll(pln1, pln2, pln3);
        System.out.println(pln1.getCenterX());

    }

    void simulator() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), (ActionEvent event) -> {
            for (Planet p1 : planets) {
                for (Planet p2 : planets) {
                    if (p1 != p2) {


                        double p1Mass = p1.getMass();
                        double p2Mass = p2.getMass();

                        double gravityForce_X = gravityForceX(p1Mass, p2Mass, distanceX(p1, p2));
                        double gravityForce_Y = gravityForceY(p1Mass, p2Mass, distanceY(p1, p2));

                        p1.setX_acceleration(-gravityForce_X / p1Mass);
                        p1.setY_acceleration(-gravityForce_Y / p1Mass);
                        p2.setX_acceleration(gravityForce_X / p2Mass);
                        p2.setY_acceleration(gravityForce_Y / p2Mass);


                        System.out.println(gravityForceX(p1Mass, p2Mass, distanceX(p1, p2)) / p2Mass);

                    }
                }

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    double distanceX(Planet p1, Planet p2) {
        return Math.abs(p1.getX() - p2.getX());
    }

    double distanceY(Planet p1, Planet p2) {
        return Math.abs(p1.getY() - p2.getY());
    }

    double gravityForceX(double mass_1, double mass_2, double distance) {
        return gravityConst * ((mass_1 * mass_2) / (distance * distance));
    }

    double gravityForceY(double mass_1, double mass_2, double distance) {
        return gravityConst * ((mass_1 * mass_2) / (distance * distance));
    }

    //√[(x2 − x1)^2 + (y2 − y1)^2].
    //double distance(body_1.get("x"), body_1.get("y"), body_2.get("x"), body_2.get("y"));
    /*double distance(Planet planet_1, Planet planet_2) {
        double x_1 = planet_1.getCenterX();
        double y_1 = planet_1.getCenterY();
        double x_2 = planet_2.getCenterX();
        double y_2 = planet_2.getCenterY();
        diff_x = Math.abs(x_1-x_2);
        diff_y = Math.abs(y_1-y_2);
        distance = Math.sqrt(Math.pow(diff_x, 2) + Math.pow(diff_y, 2));
        return distance;
    }*/

}