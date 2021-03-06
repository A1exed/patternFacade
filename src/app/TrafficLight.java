package app;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class TrafficLight {

    private int period;

    private Light realLight;

    private Button redLight;

    private Button yellowLight;

    private Button greenLight;

    public TrafficLight(int period, Button redLight, Button yellowLight, Button greenLight) {
        this.period = period;
        this.redLight = redLight;
        this.yellowLight = yellowLight;
        this.greenLight = greenLight;
        realLight = Light.RED;
        redLight.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        yellowLight.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        greenLight.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void switchLight() {
        switch (realLight) {
            case RED:
                redLight.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                yellowLight.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                realLight = Light.YELLOW_RED;
                break;
            case YELLOW_RED:
                yellowLight.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                greenLight.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                realLight = Light.GREEN;
                break;
            case YELLOW_GREEN:
                yellowLight.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                redLight.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                realLight = Light.RED;
                break;
            case GREEN:
                greenLight.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                yellowLight.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                realLight = Light.YELLOW_GREEN;
                break;
        }
    }

    public int getPeriod() {
        return period;
    }

    public Light getRealLight() {
        return realLight;
    }

    public void setRealLight(Light realLight) {
        this.realLight = realLight;
    }

    public Button getRedLight() {
        return redLight;
    }

    public Button getYellowLight() {
        return yellowLight;
    }

    public Button getGreenLight() {
        return greenLight;
    }
}
