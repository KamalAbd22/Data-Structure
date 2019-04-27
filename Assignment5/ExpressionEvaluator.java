package eg.edu.alexu.csd.datastructure.stack.cs52;
/**
 * this class to implement the interface IExpressionEvaluator
 * 
 * @author Kamal Rashid
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
	
	/*public static void main(String[] args) {
		String str="3+7+((8)*5))-3*4)";
		ExpressionEvaluator e=new ExpressionEvaluator();
		String postfix= e.infixToPostfix(str);
		if(postfix==null) {System.out.println("can't evaluate");return;}
		int v=e.evaluate(postfix);
		System.out.println(v);
		
	}*/
	
	@Override
	public String infixToPostfix(String expression) {
		StringBuilder s1=new StringBuilder(expression);
		String postfix ="";StringBuilder s2=new StringBuilder(postfix);
		Stack s=new Stack();
		Stack t=new Stack();
		for(int i=0;i<s1.length() ; i++) {
			if(s1.charAt(i)=='(') {
				t.push(s1.charAt(i));
			}
			else if(s1.charAt(i)==')' ) {
				if(t.size!=0) {t.pop();}
				else {System.out.println("error!");return null;}
			}
		}
		if(t.size!=0) {System.out.println("error!");return null;}
		for (int i = 0; i < s1.length() ;) {
			if(s1.charAt(i)!=' ' && s1.charAt(i)!='*' && s1.charAt(i)!='+' &&s1.charAt(i)!='/' &&
					s1.charAt(i)!='-' && s1.charAt(i)!='(' && s1.charAt(i)!=')') {
				if(s2.length()==0) {s2.append(s1.charAt(i));i++;}
				else if(s1.charAt(i-1)!=' ' && s1.charAt(i-1)!='*' && s1.charAt(i-1)!='+' && s1.charAt(i-1)!='/' &&
						s1.charAt(i-1)!='-' && s1.charAt(i-1)!='(' && s1.charAt(i-1)!=')') {
					s2.append(s1.charAt(i));i++;
				}
				else {
					s2.append(' ');
					s2.append(s1.charAt(i));i++;
				}
			}
			else if((s1.charAt(i)=='*' || s1.charAt(i)=='+' ||s1.charAt(i)=='/' ||
					s1.charAt(i)=='-' || s1.charAt(i)=='(' )&& s.size==0) {
				s.push(s1.charAt(i));i++;
			}
			else if(s1.charAt(i)=='(') {s.push(s1.charAt(i));i++;}
			else if((s1.charAt(i)=='*' || s1.charAt(i)=='/') && ((char)s.peek()=='+' || (char)s.peek()=='-')) {
				s.push(s1.charAt(i));i++;
			}
			else if((s1.charAt(i)=='+' || s1.charAt(i)=='-' || s1.charAt(i)=='/' || s1.charAt(i)=='*') && ((char)s.peek()=='*' || (char)s.peek()=='/'|| (char)s.peek()=='+' || (char)s.peek()=='-')) {
				s2.append(' ');
				s2.append(s.pop());
			}
			else if(s1.charAt(i)==')') {
				char c=(char) s.pop();
				while(c!='(') {
					s2.append(' ');
					s2.append(c);
					c=(char) s.pop();
				}
				i++;
			}
			else if (s1.charAt(i)!=' '){s.push(s1.charAt(i));i++;}
			else {i++;}
		}
		while(s.size!=0) {
			s2.append(' ');
			s2.append(s.pop());
		}
		postfix=s2.toString();
		return postfix;
	}

	@Override
	public int evaluate(String expression) {
		StringBuilder b=new StringBuilder();
		Stack s=new Stack();int r=0;
		System.out.println(expression);
		for(int i=0;i<expression.length() ; i++) {
			if(expression.charAt(i)!=' ' && expression.charAt(i)!='-' && expression.charAt(i)!='+' && expression.charAt(i)!='*' && expression.charAt(i)!='/') {
				b.append(expression.charAt(i));
				if(expression.charAt(i+1)==' ') {
					String str=b.toString();
					s.push(Integer.parseInt(str));
					while(b.length()!=0) {
						b.deleteCharAt(0);
					}
				}
			}
			else if(expression.charAt(i)=='+') {
				r=(int)s.pop() + (int)s.pop();
				s.push(r);
			}
			else if(expression.charAt(i)=='-') {
				r=(int)s.pop() - (int)s.pop();
				s.push(r*-1);
			}
			else if(expression.charAt(i)=='*') {
				r=(int)s.pop() * (int)s.pop();
				s.push(r);
			}
			else if(expression.charAt(i)=='/'){
				int r1=(int)s.pop();int r2=(int)s.pop();
				r= r2/r1 ;
				s.push(r);
			}
		}
		return (int)s.pop();
	}

	
}
