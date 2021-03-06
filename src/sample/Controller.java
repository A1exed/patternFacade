package sample;

import app.Action;
import app.Car;
import app.TrafficLight;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML
    private ImageView auto;

    @FXML
    private Button run;

    @FXML
    private Button red;

    @FXML
    private Button yellow;

    @FXML
    private Button green;

    @FXML
    private void run(ActionEvent event) {
        run.setDisable(true);
        Car car = new Car(auto, 8, red.getLayoutX());
        TrafficLight trafficLight = new TrafficLight(3, red, yellow, green);
        Action action = new Action(car, trafficLight);
        action.start();
    }


}
