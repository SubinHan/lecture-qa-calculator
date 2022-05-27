package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import core.IAdder;
import core.IFlipper;
import core.Subtractor;

public class SubtractorTest {
	
	private IAdder adder;
	private IFlipper flipper;
	private Subtractor subtractor;
	
	@Before
	public void setUp() {
		adder = Mockito.mock(IAdder.class);
		flipper = Mockito.mock(IFlipper.class);
		
		Mockito.when(flipper.flip(5)).thenReturn(-5);
		Mockito.when(adder.add(3, -5)).thenReturn(-2);
		subtractor = new Subtractor(adder, flipper);
	}
	
	@Test
	public void subtractTest() {
		assertEquals(-2, subtractor.subtract(3, 5));
	}
}
