package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.control.Validate;
import ru.szhernovoy.control.ValidateAge;
import ru.szhernovoy.control.ValidateId;
import ru.szhernovoy.control.ValidateName;
import ru.szhernovoy.model.User;
import ru.szhernovoy.model.UserStorage;

import static org.hamcrest.core.Is.is;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class UserStorageTest {

    @Test
    public void whenAddUserToStorageThatTheyAdd(){
        User vasja = new User("Vasja",25);
        User kolja = new User("Kolja",26);
        Validate[] valid = new Validate[2];
        valid[0] = new ValidateAge();
        valid[1] = new ValidateName();
        UserStorage storage = new UserStorage(2);
        boolean result  = storage.addUser(valid,vasja);
        storage.addUser(valid,kolja);
        boolean control = true;
        Assert.assertThat(control,is(result));
    }

    @Test
    public void whenAddUserDuplicateWithAgeThatTheyDontAdd(){
        User vasja = new User("Vasja",25);
        User kolja = new User("Kolja",25);
        Validate[] valid = new Validate[2];
        valid[0] = new ValidateAge();
        valid[1] = new ValidateName();
        UserStorage storage = new UserStorage(2);
        storage.addUser(valid,vasja);
        boolean result  =storage.addUser(valid,kolja);
        boolean control = false;
        Assert.assertThat(control,is(result));
    }


    @Test
    public void whenAddUserDuplicateWithNameThatTheyDontAdd(){
        User vasja = new User("Vasja",25);
        User kolja = new User("Vasja",27);
        Validate[] valid = new Validate[2];
        valid[0] = new ValidateAge();
        valid[1] = new ValidateName();
        UserStorage storage = new UserStorage(2);
        storage.addUser(valid,vasja);
        boolean result  =storage.addUser(valid,kolja);
        boolean control = false;
        Assert.assertThat(control,is(result));
    }

    @Test
    public void whenDeleteUserFromStorageThatTheyDelete(){
        User vasja = new User("Vasja",25);
        User kolja = new User("Kolja",26);
        Validate[] valid = new Validate[2];
        valid[0] = new ValidateAge();
        valid[1] = new ValidateName();
        UserStorage storage = new UserStorage(2);
        storage.addUser(valid,vasja);
        storage.addUser(valid,kolja);

        Validate[] validId = new Validate[1];
        validId[0] = new ValidateId();

        boolean result = storage.deleteUser(validId,vasja);
        System.out.println("res" +   "" + result);
        boolean control = true;

        Assert.assertThat(control,is(result));
    }

    @Test
    public void whenDeleteUserFromStorageFromUncorrectIDThatTheyDontDelete(){
        User vasja = new User("Vasja",25);
        User kolja = new User("Kolja",26);
        Validate[] valid = new Validate[2];
        valid[0] = new ValidateAge();
        valid[1] = new ValidateName();
        UserStorage storage = new UserStorage(2);
        storage.addUser(valid,vasja);
        storage.addUser(valid,kolja);

        Validate[] validId = new Validate[1];
        validId[0] = new ValidateId();
        vasja.setId("1212121212");
        boolean result = storage.deleteUser(validId,vasja);
        boolean control = false;
        Assert.assertThat(control,is(result));
    }

    @Test
    public void whenUpdateUserToStorageThatTheyUpdate(){
        User vasja = new User("Vasja",25);
        User kolja = new User("Kolja",26);
        User anton = new User("Anton",35);
        Validate[] valid = new Validate[2];
        valid[0] = new ValidateAge();
        valid[1] = new ValidateName();
        UserStorage storage = new UserStorage(2);
        storage.addUser(valid,vasja);
        storage.addUser(valid,kolja);

        Validate[] validId = new Validate[1];
        validId[0] = new ValidateId();

        anton.setId(vasja.getId());
        boolean result = storage.updateUser(validId,anton);
        boolean control = true;
        Assert.assertThat(control,is(result));
    }



    @Test
    public void whenUpdateUserWithUncorrectIDThatTheyDontUpdate(){
        User vasja = new User("Vasja",25);
        User kolja = new User("Kolja",25);
        User anton = new User("Anton",35);
        Validate[] valid = new Validate[2];
        valid[0] = new ValidateAge();
        valid[1] = new ValidateName();
        UserStorage storage = new UserStorage(2);
        storage.addUser(valid,vasja);
        storage.addUser(valid,kolja);

        Validate[] validId = new Validate[1];
        validId[0] = new ValidateId();
        anton.setId("1111111111");
        boolean result = storage.updateUser(validId,anton);
        boolean control = false;
        Assert.assertThat(control,is(result));
    }


}
