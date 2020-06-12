package com.lpras.springboot.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
//@PrepareForTest(fullyQualifiedNames = "com.lpras.springboot.powermockito.*")
@PrepareForTest({CollaboratorForPartialMocking.class})
public class CollaboratorForPartialMockingTest {
    @Test
    public void givenPartialMocking_whenUsingPowerMockito_thenCorrect() throws Exception {
        String returnValue;

        spy(CollaboratorForPartialMocking.class);
        when(CollaboratorForPartialMocking.staticMethod()).thenReturn("I am a static mock method.");
        returnValue = CollaboratorForPartialMocking.staticMethod();
        CollaboratorForPartialMocking.staticMethod();
        assertEquals("I am a static mock method.", returnValue);

        CollaboratorForPartialMocking collaborator = new CollaboratorForPartialMocking();
        CollaboratorForPartialMocking mock = spy(collaborator);

        when(mock.finalMethod()).thenReturn("I am a final mock method.");
        returnValue = mock.finalMethod();
        verify(mock).finalMethod();
        assertEquals("I am a final mock method.", returnValue);

        when(mock, "privateMethod").thenReturn("I am a private mock method.");
        returnValue = mock.privateMethodCaller();
        verifyPrivate(mock).invoke("privateMethod");
        assertEquals("I am a private mock method. Welcome to the Java world.", returnValue);
    }
}
