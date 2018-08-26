package cl.companyvfarias.loginfirebase.listeners;

import cl.companyvfarias.loginfirebase.models.Car;

public interface CarListener {

    void clicked(Car car);
    void dataChanged();
}
