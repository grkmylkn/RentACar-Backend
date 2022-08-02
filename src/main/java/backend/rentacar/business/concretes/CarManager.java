package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.dtos.cardto.CarCreateDto;
import backend.rentacar.entities.dtos.cardto.CarViewDto;
import backend.rentacar.repositories.abstracts.CarRepository;
import backend.rentacar.entities.concretes.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public CarManager(CarRepository carRepository, ModelMapperService modelMapperService) {
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<CarViewDto>> getAll() {
        List<Car> cars = this.carRepository.findAll();
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        List<Car> cars = this.carRepository.findAll(pageable).getContent();
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> getAllSortedByCarNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"carName");
        List<Car> cars = this.carRepository.findAll(sort);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> getAllSortedByCarNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"carName");
        List<Car> cars = this.carRepository.findAll(sort);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> getAllSortedByDailyPriceAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"dailyPrice");
        List<Car> cars = this.carRepository.findAll(sort);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> getAllSortedByDailyPriceDesc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"dailyPrice");
        List<Car> cars = this.carRepository.findAll(sort);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> getAllSortedByModelYearAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"modelYear");
        List<Car> cars = this.carRepository.findAll(sort);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> getAllSortedByModelYearDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"modelYear");
        List<Car> cars = this.carRepository.findAll(sort);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<CarViewDto> add(CarCreateDto carCreateDto) {
        Car car = this.carRepository.save(new Car(carCreateDto.getCarName(),carCreateDto.getDailyPrice(),carCreateDto.getModelYear(),carCreateDto.getDescription(),carCreateDto.getBrand(),carCreateDto.getColor()));
        return new SuccessDataResult<>(CarViewDto.of(car));
    }

    @Override
    public DataResult<CarViewDto> findByCarId(int carId) {
        Car car = this.carRepository.findByCarId(carId);
        CarViewDto result = this.modelMapperService.forDto().map(car, CarViewDto.class);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<CarViewDto> findByCarName(String carName) {
        Car car = this.carRepository.findByCarName(carName);
        CarViewDto result = this.modelMapperService.forDto().map(car, CarViewDto.class);
        return new SuccessDataResult<>(result);    }

    @Override
    public DataResult<List<CarViewDto>> findByDailyPrice(double dailyPrice) {
        List<Car> cars = this.carRepository.findByDailyPrice(dailyPrice);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> findByModelYear(int modelYear) {
        List<Car> cars = this.carRepository.findByModelYear(modelYear);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<CarViewDto>> findByDailyPriceLessThan(double dailyPrice) {
        List<Car> cars = this.carRepository.findByDailyPriceLessThan(dailyPrice);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
           }

    @Override
    public DataResult<List<CarViewDto>> findByDailyPriceGreaterThan(double dailyPrice) {
        List<Car> cars = this.carRepository.findByDailyPriceGreaterThan(dailyPrice);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);    }

    @Override
    public DataResult<List<CarViewDto>> findByDailyPriceBetween(double startDailyPrice, double endDailyPrice) {
        List<Car> cars = this.carRepository.findByDailyPriceBetween(startDailyPrice, endDailyPrice);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);  }

    @Override
    public DataResult<List<CarViewDto>> findByModelYearLessThan(int modelYear) {
        List<Car> cars = this.carRepository.findByModelYearLessThan(modelYear);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);   }

    @Override
    public DataResult<List<CarViewDto>> findByModelYearGreaterThan(int modelYear) {
        List<Car> cars = this.carRepository.findByModelYearGreaterThan(modelYear);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);   }

    @Override
    public DataResult<List<CarViewDto>> findByModelYearBetween(int startModelYear, int endModelYear) {
        List<Car> cars = this.carRepository.findByModelYearBetween(startModelYear, endModelYear);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result); }

    @Override
    public DataResult<List<CarViewDto>> findByDescriptionContaining(String infix) {
        List<Car> cars = this.carRepository.findByDescriptionContaining(infix);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);   }

    @Override
    public DataResult<List<CarViewDto>> findByBrand(int brandId) {
        List<Car> cars = this.carRepository.findByBrand_BrandId(brandId);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);   }

    @Override
    public DataResult<List<CarViewDto>> findByColor(int colorId) {
        List<Car> cars = this.carRepository.findByColor_ColorId(colorId);
        List<CarViewDto> result = cars.stream().map(car -> this.modelMapperService.forDto().map(car,CarViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);  }
}
