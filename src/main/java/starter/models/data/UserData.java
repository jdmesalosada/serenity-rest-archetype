package starter.models.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserData {
    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    private String name;
    private Integer id;

    /*public String toString(){
        return "id: " + this.id + " name: " + this.name;
    }*/
}
