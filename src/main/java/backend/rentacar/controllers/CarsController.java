package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Car;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public DataResult<List<Car>> getAll(){
        return this.carService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Car car){
        return this.carService.add(car);
    }
    @GetMapping("/findbycarid")
    DataResult<Car> findByCarId(@RequestParam int carId){
        return this.carService.findByCarId(carId);
    }
    @GetMapping("/findbycarname")
    DataResult<Car> findByCarName(@RequestParam String carName){
        return this.carService.findByCarName(carName);
    }
    @GetMapping("/findbydailyprice")
    DataResult<List<Car>> findByDailyPrice(@RequestParam double dailyPrice){
        return this.carService.findByDailyPrice(dailyPrice);
    }
    @GetMapping("/findbymodelyear")
    DataResult<List<Car>> findByModelYear(@RequestParam int modelYear){
        return this.carService.findByModelYear(modelYear);
    }
    @GetMapping("/findbydailypricelessthan")
    DataResult<List<Car>> findByDailyPriceLessThan(@RequestParam double dailyPrice){
        return this.carService.findByDailyPriceLessThan(dailyPrice);
    }
    @GetMapping("/findbydailypricegreaterthan")
    DataResult<List<Car>> findByDailyPriceGreaterThan(@RequestParam double dailyPrice){
        return this.carService.findByDailyPriceGreaterThan(dailyPrice);
    }
    @GetMapping("/findbydailypricebetween")
    DataResult<List<Car>> findByDailyPriceBetween(@RequestParam double startDailyPrice,@RequestParam double endDailyPrice){
        return this.carService.findByDailyPriceBetween(startDailyPrice, endDailyPrice);
    }
    @GetMapping("/findbymodelyearlessthan")
    DataResult<List<Car>> findByModelYearLessThan(@RequestParam int modelYear){
        return this.carService.findByModelYearLessThan(modelYear);
    }
    @GetMapping("/findbymodelyeargreaterthan")
    DataResult<List<Car>> findByModelYearGreaterThan(@RequestParam int modelYear){
        return this.carService.findByModelYearGreaterThan(modelYear);
    }
    @GetMapping("/findbymodelyearbetween")
    DataResult<List<Car>> findByModelYearBetween(@RequestParam int startModelYear,@RequestParam int endModelYear){
        return this.carService.findByModelYearBetween(startModelYear, endModelYear);
    }
    @GetMapping("/findbydescriptioncontaining")
    DataResult<List<Car>> findByDescriptionContaining(@RequestParam String infix){
        return this.carService.findByDescriptionContaining(infix);
    }
}
