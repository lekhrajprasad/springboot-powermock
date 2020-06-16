package com.lpras.sb.pmock.simple;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CalcService2Test {

    @Mock
    AddService addService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalc() {

        System.out.println("**--- Test testCalc executed ---**");

        CalcService calcService;

        calcService = new CalcService(addService);

        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        when(addService.add(num1, num2)).thenReturn(expected);

        int actual = calcService.calc(num1, num2);

        assertEquals(expected, actual);

    }
}
