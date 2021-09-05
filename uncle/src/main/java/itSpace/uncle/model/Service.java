package itSpace.uncle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Service {


    private int id;
    private String title;
    private String description;
    private String date;
    private String visitorName;
    private User user;
}
