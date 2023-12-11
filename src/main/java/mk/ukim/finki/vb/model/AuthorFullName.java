package mk.ukim.finki.vb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorFullName implements Serializable {
    private String name;
    private String surname;
}
