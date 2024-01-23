package com.example.threebody;

import javafx.scene.shape.Circle;

public class Planet extends Circle {

    private double mass;
    private double x_acceleration;
    private double y_acceleration;
    private double x_velocity;
    private double y_velocity;
    private double x;
    private double y;

    public Planet(double x, double y, double mass, double x_acceleration, double y_acceleration, double x_velocity, double y_velocity) {
        this.x = x;
        this.y = y;
        this.mass = mass;
        this.x_acceleration = x_acceleration;
        this.y_acceleration = y_acceleration;
        this.x_velocity = x_velocity;
        this.y_velocity = y_velocity;

        setCenterX(this.x);
        setCenterY(this.y);
        setRadius(15);
    }

    public double getMass() {
        return this.mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getX_acceleration() {
        return x_acceleration;
    }

    public void setX_acceleration(double x_acceleration) {
        this.x_acceleration = x_acceleration;
        this.x_velocity = this.x_velocity + x_acceleration;
        setCenterX(getCenterX() + x_velocity);
    }

    public double getY_acceleration() {
        return y_acceleration;
    }

    public void setY_acceleration(double y_acceleration) {
        this.y_acceleration = y_acceleration;
        this.y_velocity = this.y_velocity + y_acceleration;
        setCenterY(getCenterY() + y_velocity);
    }

    public double getX_velocity() {
        return x_velocity;
    }

    public void setX_velocity(double x_velocity) {
        this.x_velocity = x_velocity;
    }

    public double getY_velocity() {
        return y_velocity;
    }

    public void setY_velocity(double y_velocity) {
        this.y_velocity = y_velocity;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
