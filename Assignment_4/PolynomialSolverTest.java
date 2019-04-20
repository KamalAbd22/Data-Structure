package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolynomialSolverTest {

	PolynomialSolver x=new PolynomialSolver();
	
	@Before
	public void setUp() throws Exception {
		x.A=new int[3][2];
		x.A[0][0]=3;x.A[0][1]=2;
		x.A[1][0]=-9;x.A[1][1]=1;
		x.A[2][0]=1;x.A[2][1]=0;
		
		x.B=new int [2][2];
		x.B[0][0]=5;x.B[0][1]=1;
		x.B[1][0]=-1;x.B[1][1]=0;
		
		
	}

	@Test
	public void addTest() {
		x.add(x.A, x.B);
		assertEquals(3,x.R[0][0]);assertEquals(2,x.R[0][1]);
		assertEquals(-4,x.R[1][0]);assertEquals(1,x.R[1][1]);
		assertEquals(0,x.R[2][0]);assertEquals(0,x.R[2][1]);
	}

	@Test
	public void subtractTest() {
		x.subtract(x.A, x.B);
		assertEquals(3,x.R[0][0]);assertEquals(2,x.R[0][1]);
		assertEquals(-14,x.R[1][0]);assertEquals(1,x.R[1][1]);
		assertEquals(2,x.R[2][0]);assertEquals(0,x.R[2][1]);
	}
	
	@Test
	public void multiplyTest() {
		x.multiply(x.A, x.B);
		assertEquals(15,x.R[0][0]);assertEquals(3,x.R[0][1]);
		assertEquals(-48,x.R[1][0]);assertEquals(2,x.R[1][1]);
		assertEquals(14,x.R[2][0]);assertEquals(1,x.R[2][1]);
		assertEquals(-1,x.R[3][0]);assertEquals(0,x.R[3][1]);
	}
	
}
