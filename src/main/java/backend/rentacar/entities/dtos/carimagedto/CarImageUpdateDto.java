package backend.rentacar.entities.dtos.carimagedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageUpdateDto {
    @NotNull
    private String imagePath;
}
