import java.util.*;

public class ExpressionTree extends TreeNode implements Expressions {
	
	/**
	 * constructors, constructs an expression tree
	 * @param x
	 */
	public ExpressionTree(Object x)
	{
		super(x);
	}
	
	/**
	 * breaks up an expression in postfix notation and builds a binary tree with the numbers in the leaves
	 * @param expression
	 * @return a TreeNode head of the binary tree made from the expression in the parameter
	 */
	public static TreeNode buildTree(String[] expression)
	{
		Stack<TreeNode> temp = new Stack<TreeNode>();
		ExpressionTree current = null;
		
		for(int x = 0; x < expression.length; x++)
		{
			current = new ExpressionTree(expression[x]);
			if(expression[x].equals("+") || expression[x].equals("*"))
			{
				current.setRight(temp.pop());
				current.setLeft(temp.pop());
				temp.push(current);
			} else temp.push(current);
		}
		
		return current;
	}
	
	@Override
	/**
	 * evaluates the given tree starting from the leaves and moving up to the root
	 */
	public int evalTree() {
		// TODO Auto-generated method stub
		if(!this.getValue().toString().equals("+") && !this.getValue().toString().equals("*"))
		{
			return Integer.parseInt(this.getValue().toString());
		}
		
		else if(this.getValue().toString().equals("+"))
		{
			int left = ((ExpressionTree)this.getLeft()).evalTree();
			int right = ((ExpressionTree)this.getRight()).evalTree();
			return left + right;
		} else {
			int left = ((ExpressionTree)this.getLeft()).evalTree();
			int right = ((ExpressionTree)this.getRight()).evalTree();
			return left * right;
		}
	}

	@Override
	/**
	 * traverses through the tree in preorder and builds a string representation of the string in prefix notation
	 */
	public String toPrefixNotation() {
		// TODO Auto-generated method stub
		String left = "";
		String right = "";
		
		ExpressionTree current = this;
		if(current.getLeft() == null && current.getRight() == null)
			return current.getValue().toString();
		
		ExpressionTree currentLeft = (ExpressionTree)current.getLeft();
		left = currentLeft.toPrefixNotation() + " " + left;
		
		ExpressionTree currentRight = (ExpressionTree)current.getRight();
		right = currentRight.toPrefixNotation() + " " + right;
		
		String result = this.getValue().toString() + " " + left + right;
		
		return result;
	}

	@Override
	/**
	 * traverses the tree inorder and builds a string representation of the tree in infix notation
	 */
	public String toInfixNotation() {
		// TODO Auto-generated method stub
		String left = "";
		String right = "";
		
		ExpressionTree current = this;
		if(current.getLeft() == null && current.getRight() == null)
			return current.getValue().toString();
		
		ExpressionTree currentLeft = (ExpressionTree)current.getLeft();
		left = currentLeft.toInfixNotation() + " " + left;
		
		ExpressionTree currentRight = (ExpressionTree)current.getRight();
		right = currentRight.toInfixNotation() + " " + right;
		
		String result = "(" + left + this.getValue().toString() + right + ")";
		
		return result;
	}

	@Override
	/**
	 * traverses the tree in postorder and builds a string representation of the three in postfix notation
	 */
	public String toPostfixNotation() {
		// TODO Auto-generated method stub
		String left = "";
		String right = "";
		
		ExpressionTree current = this;
		if(current.getLeft() == null && current.getRight() == null)
			return current.getValue().toString();
		
		ExpressionTree currentLeft = (ExpressionTree)current.getLeft();
		left = currentLeft.toPostfixNotation() + " " + left;
		
		ExpressionTree currentRight = (ExpressionTree)current.getRight();
		right = currentRight.toPostfixNotation() + " " + right;
		
		String result = left + right + this.getValue().toString();
		
		return result;
	}
	
	@Override
	/**
	 * evaluates the postfix notation expression and returns the resulting integer
	 */
	public int postfixEval(String[] exp) {
		// TODO Auto-generated method stub
		Stack<String> temp = new Stack<String>();
		
		for(int x = 0; x < exp.length; x++)
		{
			if(exp[x].equals("+"))
			{
				int first = Integer.parseInt(temp.pop());
				int second = Integer.parseInt(temp.pop());
				temp.push(first + second + "");
			} else if (exp[x].equals("*"))
			{
				int first = Integer.parseInt(temp.pop());
				int second = Integer.parseInt(temp.pop());
				temp.push(first * second + "");
			} else temp.push(exp[x]);
		}
		
		int ans = Integer.parseInt(temp.pop());
		
		return ans;
	}
	
	public static void main(String[] args)
	{
		String[] nums = {"2", "3", "4", "+", "*"};
		ExpressionTree test = (ExpressionTree)buildTree(nums);
		System.out.println(test.postfixEval(nums));
		System.out.println(test.evalTree());
		System.out.println(test.toPrefixNotation());
		System.out.println(test.toPostfixNotation());
		System.out.println(test.toInfixNotation());
	}
	
}
