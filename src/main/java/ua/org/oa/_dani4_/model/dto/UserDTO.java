package ua.org.oa._dani4_.model.dto;

import java.util.Date;

/**
 * Created by Admin on 03.04.2016.
 */
public class UserDTO {
    private int id;
    private String name;
    private String login;
    private String password;
    private Date birthday;


    public UserDTO(Date birthday, String login, String name, String password) {
        this.setBirthday(birthday);
        this.setLogin(login);
        this.setName(name);
        this.setPassword(password);
    }

    public UserDTO(String login, String password) {
        this.setBirthday(null);
        this.setLogin(login);
        this.setName(null);
        this.setPassword(password);
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDTO{");
        sb.append("birthday=").append(birthday);
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (getId() != userDTO.getId()) return false;
        if (getName() != null ? !getName().equals(userDTO.getName()) : userDTO.getName() != null) return false;
        if (getLogin() != null ? !getLogin().equals(userDTO.getLogin()) : userDTO.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(userDTO.getPassword()) : userDTO.getPassword() != null)
            return false;
        return getBirthday() != null ? getBirthday().equals(userDTO.getBirthday()) : userDTO.getBirthday() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        return result;
    }
}
