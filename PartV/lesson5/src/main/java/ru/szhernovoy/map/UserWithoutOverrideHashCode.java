package ru.szhernovoy.map;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by admin on 18.09.2016.
 */
public class UserWithoutOverrideHashCode extends User {
    public UserWithoutOverrideHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;

    }
}
