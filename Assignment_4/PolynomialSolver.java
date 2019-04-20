package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.Scanner;
import java.util.regex.*;
import eg.edu.alexu.csd.datastructure.linkedList.SLinkedList.Node;
import eg.edu.alexu.csd.datastructure.linkedList.DLinkedList.DNode;

public class PolynomialSolver implements IPolynomialSolver{
	static Scanner reader=new Scanner(System.in);
	int[][] A=null;int [][] B=null;int [][] C=null;int[][] R=null;
	public double result;
	public static void main(String[] args) {
		PolynomialSolver p=new PolynomialSolver();
		while(true) {
		System.out.println("Please choose an action");
		System.out.println("----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable ");
		System.out.println("3- Add two polynomials ");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point ");
		System.out.println("7- Clear a polynomial variable ");
		System.out.println("==============================================================");
		int input=reader.nextInt();
		char poly=' ';int[][] terms= {};char poly1=' ';char poly2=' ';float value = 0;
		switch (input) {
		case 1:
			p.setPolynomial(poly,terms);
			break;
		
        case 2:
        	p.print(poly);
			break;
		
        case 3:
        	p.add(poly1, poly2);
			break;
		
        case 4:
        	p.subtract(poly1,poly2);
			break;
        
        case 5:
        	p.multiply(poly1, poly2);
			break;
        
        case 6:
        	p.evaluatePolynomial(poly1, value);
			break;
        
        case 7:
        	p.clearPolynomial(poly2);
			break;
        
        default:
        	System.out.println("!Error not exist");
        	System.out.println("==============================================================");
			break;
		}
		}

	}
	
	@Override
	public void setPolynomial(char poly, int[][] terms) {
		String scan;
		while(true) {
		System.out.println("Insert the variable name: A, B or C");
		poly=reader.next().charAt(0);
		if(poly=='A' || poly=='B' || poly=='C') {break;}
		else {System.out.println("Not valid! tray again");}
		}
		System.out.println("Insert the polynomial terms in the form:\n"
				+ " (coeff1, exponent1), (coeff2, exponent2), ..");
		scan=reader.next();
		terms=Regex("[-+]\\d{1,}|\\d{1,}",scan);
		switch (poly) {
		case 'A':
			A=terms;
			break;

		case 'B':
			B=terms;
			break;
		
		case 'C':
			C=terms;
			break;
		
		default:
			break;
		}
		System.out.println("polinomial "+ poly+" is set");
		System.out.println("==============================================================");
	}
	
	public int[][] Regex(String regex,String check) {
		DLinkedList l=new DLinkedList();
		Pattern checkregex=Pattern.compile(regex);
		Matcher regexMatcher=checkregex.matcher(check);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length() !=0) {
				l.add(regexMatcher.group());
			}
		}
		int [][] terms=new int[l.size/2][2];
		DNode current=l.head.next;
		for(int i=0;i<l.size;i++) {
			if(i%2==0) {terms[i/2][0]=Integer.parseInt((String) current.value);}
			else {terms[i/2][1]=Integer.parseInt((String) current.value);}
			current=current.next;
		}
		return terms;
	}

	@Override
	public String print(char poly) {
		while(true) {
		boolean b=true;
		System.out.println("Insert the variable name: A, B, C or R");
		poly=reader.next().charAt(0);
		switch (poly) {
		case 'A':
			print(A,poly);
			break;

		case 'B':
			print(B,poly);
			break;
		
		case 'C':
			print(C,poly);
			break;
		
		case 'R':
			print(R,poly);
			break;
		
		default:{
			System.out.println("Not exist! Try again");b=false;
			break;}
		}
		if(b!=false) {break;}
		}
		return null;
	}
	
	public void print(int[][] poli,char poly) {
		System.out.print("value in "+poly+" : ");
		boolean b=true;
		for (int i = 0; i < poli.length; i++) {
			if(poli[i][0]==0) {b=false;continue;}
			else if(poli[i][0]==1 && poli[i][1]==0) {System.out.print("+1");}
			else if(poli[i][0]==1) {}
			else if(poli[i][0]>0 && i!= 0){System.out.print("+"+poli[i][0]);}
			else if(poli[i][0]==-1 && poli[i][1]==0) {System.out.print("-1");}
			else if(poli[i][0]==-1) {System.out.print("-");}
			else {System.out.print(poli[i][0]);}
			if(poli[i][1]==0) {}
			else if(poli[i][1]==1) {System.out.print("x");}
			else {System.out.print("x^"+poli[i][1]);}
			b=true;
		}
		if(b=false) {System.out.print(0);}
		System.out.println("\n==============================================================");

	}

	@Override
	public void clearPolynomial(char poly) {
		while(true) {
			System.out.println("Insert variable name: A, B or C");
			poly=reader.next().charAt(0);
			if(check(poly)==0) {System.out.println("Variable not set");}
			else if(check(poly)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		if(poly=='A') {A=null;}
		else if(poly=='B') {B=null;}
		else {C=null;}	
		System.out.println("variable "+poly+" is cleared");
		System.out.println("==============================================================");
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		while(true) {
			System.out.println("Insert variable name: A, B or C");
			poly=reader.next().charAt(0);
			if(check(poly)==0) {System.out.println("Variable not set");}
			else if(check(poly)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		System.out.println("enter the value:");
		value=reader.nextFloat();
		double r = 0;
		if(poly=='A') {r=evaluate(A,value);}
		else if(poly=='B') {r=evaluate(B,value);}
		else{r=evaluate(C,value);}
		System.out.println("the result is :"+r);
		System.out.println("==============================================================");
		return 0;
	}
		
	public double evaluate(int[][] p,float v) {
		double r=0;
		for (int i = 0; i < p.length; i++) {
			r+=p[i][0]*Math.pow(v, p[i][1]);
		}
		result=r;
		return r;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		while(true) {
			System.out.println("Insert first operand variable name: A, B or C");
			poly1=reader.next().charAt(0);
			if(check(poly1)==0) {System.out.println("Variable not set");}
			else if(check(poly1)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		while(true) {
			System.out.println("Insert second operand variable name: A, B or C");
			poly2=reader.next().charAt(0);
			if(check(poly2)==0) {System.out.println("Variable not set");}
			else if(check(poly2)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		if((poly1=='A' && poly2=='B') || (poly1=='B' && poly2=='A')) {add(A,B);}
		else if((poly1=='A' && poly2=='C') || (poly1=='C' && poly2=='A')) {add(A,C);}
		else if(poly1=='A' && poly2=='A') {add(A,A);}
		else if(poly1=='B' && poly2=='B') {add(B,B);}
		else if(poly1=='C' && poly2=='C') {add(C,C);}
		else {add(B,C);}
		return null;
	}

	public void add(int[][] p1,int[][] p2) {
		int i=0;int j=0;DLinkedList s=new DLinkedList();
		while(i!=p1.length || j!=p2.length) {
			if(p2[j][1]>p1[i][1]) {
				s.add(p2[j][0]);s.add(p2[j][1]);
				j++;
			}
			else if(p1[i][1]>p2[j][1]) {
				s.add(p1[i][0]);s.add(p1[i][1]);
				i++;
			}
			else {
				s.add(p1[i][0]+p2[j][0]);s.add(p1[i][1]);
				i++;j++;
			}
		}
		R=new int[s.size/2][2];
		DNode current=s.head.next;
		for(i=0;i<s.size;i++) {
			if(i%2==0) {R[i/2][0]=(int) current.value;}
			else {R[i/2][1]=(int) current.value;}
			current=current.next;
		}
		System.out.print("result set in R:");
		for (int k = 0; k < R.length; k++) {
			System.out.print("("+R[k][0]+" ,"+R[k][1]+"),");
		}
		System.out.println("\n==============================================================");

	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		while(true) {
			System.out.println("Insert first operand variable name: A, B or C");
			poly1=reader.next().charAt(0);
			if(check(poly1)==0) {System.out.println("Variable not set");}
			else if(check(poly1)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		while(true) {
			System.out.println("Insert second operand variable name: A, B or C");
			poly2=reader.next().charAt(0);
			if(check(poly2)==0) {System.out.println("Variable not set");}
			else if(check(poly2)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		
		if(poly1=='A' && poly2=='A') {subtract(A, A);}
		else if(poly1=='B' && poly2=='B') {subtract(B, B);}
		else if(poly1=='C' && poly2=='C') {subtract(C, C);}
		else if(poly1=='A' && poly2=='B') {subtract(A, B);}
		else if(poly1=='B' && poly2=='A') {subtract(B, A);}
		else if(poly1=='A' && poly2=='C') {subtract(A, C);}
		else if(poly1=='C' && poly2=='A') {subtract(C, A);}
		else if(poly1=='B' && poly2=='C') {subtract(B, C);}
		else {subtract(C, B);}
		return null;
	}
	
	public void subtract(int[][] p1,int[][] p2) {
		int i=0;int j=0;SLinkedList list=new SLinkedList();
		while(i!=p1.length || j!=p2.length) {
			if(p2[j][1]>p1[i][1]) {
				list.add(-1*p2[j][0]);list.add(p2[j][1]);
				j++;
			}
			else if(p1[i][1]>p2[j][1]) {
				list.add(p1[i][0]);list.add(p1[i][1]);
				i++;
			}
			else {
				list.add(p1[i][0]-p2[j][0]);list.add(p1[i][1]);
				i++;j++;
			}
		}
		R=new int[list.size/2][2];
		Node current=list.head;
		for(i=0;i<list.size;i++) {
			if(i%2==0) {R[i/2][0]=(int) current.value;}
			else {R[i/2][1]=(int) current.value;}
			current=current.next;
		}
		System.out.print("result set in R:");
		for (int k = 0; k < R.length; k++) {
			System.out.print("("+R[k][0]+" ,"+R[k][1]+"),");
		}
		System.out.println("\n==============================================================");

	}
	
	@Override
	public int[][] multiply(char poly1, char poly2) {
		while(true) {
			System.out.println("Insert first operand variable name: A, B or C");
			poly1=reader.next().charAt(0);
			if(check(poly1)==0) {System.out.println("Variable not set");}
			else if(check(poly1)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		while(true) {
			System.out.println("Insert second operand variable name: A, B or C");
			poly2=reader.next().charAt(0);
			if(check(poly2)==0) {System.out.println("Variable not set");}
			else if(check(poly2)==1) {System.out.println("Variable not exist");}
			else {break;}
		}
		if((poly1=='A' && poly2=='B') || (poly1=='B' && poly2=='A')) {multiply(A,B);}
		else if((poly1=='A' && poly2=='C') || (poly1=='C' && poly2=='A')) {multiply(A,C);}
		else if(poly1=='A' && poly2=='A') {multiply(A,A);}
		else if(poly1=='B' && poly2=='B') {multiply(B,B);}
		else if(poly1=='C' && poly2=='C') {multiply(C,C);}
		else {multiply(B,C);}
		return null;
	}
	
	public void multiply(int[][] p1,int[][] p2) {
		DLinkedList d=new DLinkedList();
		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				d.add(p1[i][0]*p2[j][0]);
				d.add(p1[i][1]+p2[j][1]);
			}
		}
		int max=(int)d.get(1);
		for(int i=1;i<d.size-2;) {
			if(max>(int)d.get(i+2)) {i+=2;}
			else {max=(int)d.get(i+2);i+=2;}
		}
		R=new int[d.size/2][2];int c=0;
		for(int i=max;i>=0;i--) {
			R[max-i][1]=max-c;
			for(int j=1;j<d.size;) {
				if(max-c==(int)d.get(j)) {
					R[max-i][0]+=(int)d.get(j-1);
				}
				j+=2;
			}
			c++;
		}
		System.out.print("result set in R:");
		for (int k = 0; k < R.length; k++) {
			System.out.print("("+R[k][0]+" ,"+R[k][1]+"),");
		}
		System.out.println("\n==============================================================");
	}
	
	public int check(char c) {
		if(c=='A' && A==null) {return 0;}
		else if(c=='B' && B==null) {return 0;}
		else if(c=='C' && C==null) {return 0;}
		else if(c!='A' && c!='C' && c!='B') {return 1;}
		return 2;
		
	}

	
}
