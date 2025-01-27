package models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class BaseModel {
    private  long id;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

}
