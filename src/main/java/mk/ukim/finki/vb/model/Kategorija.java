package mk.ukim.finki.vb.model;

import lombok.Data;

@Data
public class Kategorija {
    private String name;
    private String description;
    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Kategorija(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
