package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String printCar(@RequestParam(value = "count", defaultValue = "5") int number, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "Red", 2015));
        cars.add(new Car("Volvo", "Black", 2020));
        cars.add(new Car("Mazda", "White", 1998));
        cars.add(new Car("KIA", "Grey", 2007));
        cars.add(new Car("Audi", "Brown", 2000));
        cars = CarServiceImpl.getCarsByNumber(cars, number);
        model.addAttribute(cars);

        return "cars";
    }
}
