package com.lpras.springboot.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


@RunWith(PowerMockRunner.class)
//@PrepareForTest(fullyQualifiedNames = "com.lpras.springboot.powermockito.*")
@PrepareForTest({CollaboratorWithFinalMethods.class})
public class  CollaboratorWithFinalMethodsTest {

    @Test
    public void givenFinalMethods_whenUsingPowerMockito_thenCorrect() throws Exception {
        CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);

        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();

        when(collaborator.helloMethod()).thenReturn("Hello World!");

        String expectedStmt = collaborator.helloMethod();

        verify(collaborator).helloMethod();
        assertEquals("Hello World!", expectedStmt);
    }

}
