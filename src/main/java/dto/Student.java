package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Student {
    String firstName;
    String lastName;
    String email;
    String gender;
    String mobile;
    String dateOfBirth;
    String[] subjects;
    String[] hobbies;
    String picture;
    String currentAddress;
    String state;
    String city;
}
