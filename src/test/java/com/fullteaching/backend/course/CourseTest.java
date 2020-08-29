package com.fullteaching.backend.course;

import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CourseTest {
    String stringDefault = "abc";

    @Test
    void CourseToString_shouldReturnExpectedString() {
        User teacher = mock(User.class);
        when(teacher.getNickName()).thenReturn("Professor");

        Set<User> attenders = mock(Set.class);
        when(attenders.size()).thenReturn(10);
        Set<Session> sessions = mock(Set.class);
        when(sessions.size()).thenReturn(10);


        Course course = new Course("Título", "", teacher);
        course.setAttenders(attenders);
        course.setSessions(sessions);

        String expected = "Course[title: \"Título\", teacher: \"Professor\", #attenders: 10, #sessions: 10]";

        Assert.isTrue(course.toString().equals(expected), "Course.toString() is equal to expected");
    }

    @Test
    public void Course_Equals_GivenTwoEqualCourses_ShouldReturnTrue() {
        User teacher = mock(User.class);
        Course course1 = new Course(stringDefault, stringDefault, teacher);
        Course course2 = new Course(stringDefault, stringDefault, teacher);

        Assert.isTrue(course1.equals(course2) == true, "Courses are equal");
    }

    @Test
    public void Course_Equals_WhenIdIsDifferent_ShouldReturnFalse() {
        long id1= 1;
        long id2= 2;
        User teacher = mock(User.class);

        Course course1 = new Course(stringDefault, stringDefault, teacher);
        course1.setId(id1);

        Course course2 = new Course(stringDefault, stringDefault, teacher);
        course2.setId(id2);

        Assert.isTrue(course1.equals(course2) == false, "Courses are not equal");
    }

    @Test
    public void Course_Equals_WhenOtherUserIsNull_ShouldReturnFalse() {
        User teacher = mock(User.class);

        Course course = new Course(stringDefault, stringDefault, teacher);

        Assert.isTrue(course.equals(null) == false, "Courses are not equal");
    }

    @Test
    public void Course_Equals_WhenOtherUserIsItself_ShouldReturnTrue() {
        User teacher = mock(User.class);

        Course course = new Course(stringDefault, stringDefault, teacher);

        Assert.isTrue(course.equals(course) == true, "Courses are equal");
    }
}