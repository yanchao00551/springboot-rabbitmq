package cn.smbms.event;
import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
import java.io.Serializable;

@Data
@ToString
public class LoginEvent extends ApplicationEvent implements Serializable {
    private String userName;
    private String loginTime;
    private String ip;

    public LoginEvent(Object source) {
        super(source);
    }
    public LoginEvent(Object source,String userName,String loginTime,String ip){
        super(source);
        this.loginTime = loginTime;
        this.userName = userName;
        this.ip = ip;
    }
}
