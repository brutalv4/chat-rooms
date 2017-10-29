package ua.skillsup.chat.domain.model;

public class UserDto extends AbstractHasId {
    private String name;
    private String password;
    private boolean anonymous;

    public UserDto() {
    }

    public UserDto(String name, String password, boolean anonymous) {
        this.name = name;
        this.password = password;
        this.anonymous = anonymous;
    }

    public String getName() {
        return this.name;
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

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                '}' +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        return name.equals(userDto.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
