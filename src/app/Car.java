package app;

import javafx.scene.image.ImageView;

public class Car {

    private ImageView imageView;

    private int speed;

    private double checkPosition;

    public Car(ImageView imageView, int speed, double checkPosition) {
        this.imageView = imageView;
        this.speed = speed;
        this.checkPosition = checkPosition;
    }

    public void drive() {
        imageView.setX(imageView.getX() + speed);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getSpeed() {
        return speed;
    }

    public double getCheckPosition() {
        return checkPosition;
    }
}
