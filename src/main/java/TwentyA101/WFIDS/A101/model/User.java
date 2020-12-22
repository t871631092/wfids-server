package TwentyA101.WFIDS.A101.model;

import lombok.Getter;
import lombok.Setter;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("user")
@Getter
@Setter
public class User {
    private  String id;
    @Name
    private  String username;
    private String password;
    private  String register;
    private int sex;
    private int location;
}
