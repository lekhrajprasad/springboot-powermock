package com.lpras.springboot.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;
@RunWith(PowerMockRunner.class)
//@PrepareForTest(fullyQualifiedNames = "com.lpras.springboot.powermockito.*")
@PrepareForTest({CollaboratorWithStaticMethods.class})
public class CollaboratorWithStaticMethodsTest {


    @Test(expected = RuntimeException.class)
    public void givenStaticMethods_whenUsingPowerMockito_thenCorrect() {
        mockStatic(CollaboratorWithStaticMethods.class);

        when(CollaboratorWithStaticMethods.firstMethod(anyString())).thenReturn("Hello Baeldung!");
        when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("Nothing special");
        doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
        CollaboratorWithStaticMethods.thirdMethod();

        String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
        String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");

        assertEquals("Hello Baeldung!", firstWelcome);
        assertEquals("Hello Baeldung!", secondWelcome);

        verifyStatic(CollaboratorWithStaticMethods.class, times(2));
        CollaboratorWithStaticMethods.firstMethod(anyString());
        //throw new RuntimeException();
        verifyStatic(CollaboratorWithStaticMethods.class, never());
        CollaboratorWithStaticMethods.secondMethod();

        CollaboratorWithStaticMethods.thirdMethod();
    }
}
