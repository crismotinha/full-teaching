package com.fullteaching.backend.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    String stringDefault = "abc";

    @Test
    public void User_toString_ShouldReturnNickname() {
        String nickname = "z";
        User user = new User("x", "y", nickname, "x", "y");

        Assert.isTrue(user.toString() == nickname, "User.toString() is equal to nickname");
    }

    @Test
    public void User_Equals_GivenTwoEqualUsers_ShouldReturnTrue() {
        User user1 = new User(stringDefault, stringDefault, stringDefault, stringDefault, stringDefault);
        User user2 = new User(stringDefault, stringDefault, stringDefault, stringDefault, stringDefault);

        Assert.isTrue(user1.equals(user2) == true, "Users are equal");
    }

    @Test
    public void User_Equals_WhenNameIsDifferent_ShouldReturnFalse() {
        String name1 = "a";
        String name2 = "b";

        User user1 = new User(name1, stringDefault, stringDefault, stringDefault, stringDefault);
        User user2 = new User(name2, stringDefault, stringDefault, stringDefault, stringDefault);

        Assert.isTrue(user1.equals(user2) == false, "Users are not equal");
    }

    @Test
    public void User_Equals_WhenIdIsDifferent_ShouldReturnFalse() {
        long id1= 1;
        long id2= 2;

        User user1 = new User(stringDefault, stringDefault, stringDefault, stringDefault, stringDefault);
        user1.setId(id1);

        User user2 = new User(stringDefault, stringDefault, stringDefault, stringDefault, stringDefault);
        user2.setId(id2);

        Assert.isTrue(user1.equals(user2) == false, "Users are not equal");
    }

    @Test
    public void User_Equals_WhenOtherUserIsNull_ShouldReturnFalse() {
        User user = new User(stringDefault, stringDefault, stringDefault, stringDefault, stringDefault);

        Assert.isTrue(user.equals(null) == false, "Users are not equal");
    }

    @Test
    public void User_Equals_WhenOtherUserIsItself_ShouldReturnTrue() {
        User user = new User(stringDefault, stringDefault, stringDefault, stringDefault, stringDefault);

        Assert.isTrue(user.equals(user) == true, "Users are equal");
    }

    @Test
    public void User_Hashcode_ShouldReturnNameHashcode() {
        User user = new User(stringDefault, stringDefault, stringDefault, stringDefault, stringDefault);

        Assert.isTrue(user.hashCode() == user.getName().hashCode(), "User hashcode is Name Hashcode");
    }

}