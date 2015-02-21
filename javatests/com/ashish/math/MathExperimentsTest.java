package com.ashish.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ashish.math.MathExperiments;

public class MathExperimentsTest {

	public MathExperiments exp;
	
	@Before
	public void setUp() throws Exception {
		exp = new MathExperiments(4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		exp.Sort();
	}
}
