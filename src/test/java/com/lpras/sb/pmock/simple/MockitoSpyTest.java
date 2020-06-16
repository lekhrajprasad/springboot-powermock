package com.lpras.sb.pmock.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class MockitoSpyTest {

    @Test
    public void testMethod(){
        List<String> list = new ArrayList<>();
        List<String> listSpy = spy(list);

        listSpy.add("first-element");
        System.out.println(listSpy.get(0));
         assertEquals("first-element", listSpy.get(0));

         when(listSpy.get(0)).thenReturn("second-element");
         System.out.println(listSpy.get(0));
         assertEquals("second-element", listSpy.get(0));

    }
}
