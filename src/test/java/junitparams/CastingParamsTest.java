package junitparams;

import static junitparams.JUnitParamsRunner.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;

import junitparams.usage.person_example.*;

@RunWith(JUnitParamsRunner.class)
public class CastingParamsTest {

    @Test
    @Parameters
    public void wrapWithTypeBySingleArgConstructor(PersonTest.Person person) {
        assertTrue(person.getAge() > 0);
    }
    List<Integer> parametersForWrapWithTypeBySingleArgConstructor() {
        return Arrays.asList(1, 2);
    }

    @Test
    @Parameters
    public void wrapWithTypeByMultiArgConstructor(PersonTest.Person person) {
        assertTrue(person.getAge() > 0);
    }
    Object parametersForWrapWithTypeByMultiArgConstructor() {
        return $($("first", 1), $("second", 2));
    }

    @Test
    @Parameters
    public void cartoonCharacters(PersonTest.Person character) { }
    private List<?> parametersForCartoonCharacters() {
        return Arrays.asList(
            $("Tarzan", 0),
            $("Jane", 20)
            );
    }

    @Parameters(method = "strings")
    @Test
    public void stringArrayFromMethod(String... values) {}
    private Object strings() { return $($("1","2"), $("2","1")); }


    @Parameters({"a,b", "b,a"})
    @Test
    public void stringArrayFromAnnotation(String... values) { }

}
