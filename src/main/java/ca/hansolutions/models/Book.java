package ca.hansolutions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Book {

    String id;
    String name;
    Double price;
}
