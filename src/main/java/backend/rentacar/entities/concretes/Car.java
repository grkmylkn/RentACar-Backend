package backend.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name="cars")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","carImages"})
public class Car {
    public Car(String carName, double dailyPrice, int modelYear, String description, Brand brand, Color color) {
        this.carName = carName;
        this.dailyPrice = dailyPrice;
        this.modelYear = modelYear;
        this.description = description;
        this.brand = brand;
        this.color = color;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    private int carId;

    @Column(name="car_name")
    private String carName;

    @Column(name="daily_price")
    private double dailyPrice;

    @Column(name="model_year")
    private int modelYear;

    @Column(name="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name="brand_id")
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name="color_id")
    private Color color;

    @OneToMany(mappedBy = "car")
    private List<CarImage> carImages;
}
