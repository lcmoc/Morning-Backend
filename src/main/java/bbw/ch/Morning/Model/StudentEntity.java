package bbw.ch.Morning.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "STUDENT")
public class StudentEntity implements Serializable {
    public StudentEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Column(name = "id", updatable = false, nullable = false)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentEntity() {
    }
}
