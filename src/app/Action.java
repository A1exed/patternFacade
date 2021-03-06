package app;

import java.util.Timer;

public class Action {

    private Car car;

    private TrafficLight trafficLight;

    private boolean action;

    public Action(Car car, TrafficLight trafficLight) {
        this.car = car;
        this.trafficLight = trafficLight;
    }

    public void start() {
        action = true;
        startTrafficLight();
        startCar();
    }

    private void startCar() {
        Thread run = new Thread(() -> {
            boolean after = false;
            while (action) {
                try {
                    if (after) {
                        if (car.getImageView().getX() + car.getSpeed() <= 1112) {
                            car.drive();
                            Thread.sleep(100);
                        } else {
                            action = false;
                        }
                    } else {
                        if (car.getCheckPosition() >= car.getImageView().getX() + car.getSpeed() + car.getImageView().getFitWidth()) {
                            car.drive();
                            Thread.sleep(100);
                        } else {
                            switch (trafficLight.getRealLight()) {
                                case GREEN:
                                case YELLOW_GREEN:
                                    car.drive();
                                    after = true;
                                    Thread.sleep(100);
                                    break;
                                default:
                                    Thread.sleep(100);
                                    break;
                            }
                        }
                    }
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
        run.start();
    }

    private void startTrafficLight() {
        Thread run = new Thread(() -> {
            while (action) {
                try {
                    trafficLight.switchLight();
                    Thread.sleep(1000L * trafficLight.getPeriod());
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
        run.start();
    }
}
