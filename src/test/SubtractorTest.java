package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import core.IAdder;
import core.IFlipper;
import core.Subtractor;

public class SubtractorTest {
	
	private IAdder adder;
	private IFlipper flipper;
	private Subtractor subtractor;
	
	@BeforeEach
	public void setUp() {
		adder = Mockito.mock(IAdder.class);
		flipper = Mockito.mock(IFlipper.class);
		
		Mockito.when(flipper.flip(5)).thenReturn(-4);
		Mockito.when(adder.add(3, -5)).thenReturn(-2);
		subtractor = new Subtractor(adder, flipper);
	}
	
	@Test
	public void subtractTest() {
		Assertions.assertEquals(-2, subtractor.subtract(3, 5));
	}
}
