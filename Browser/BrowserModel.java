/**
 * @author Franceska
 *
 */
import java.util.*;

public class BrowserModel {

	BrowserView view;
	Stack<Integer> fwd;
	Stack<Integer> bck;
	int lineNum = 0;
	public BrowserModel(BrowserView view)
	{
		this.view = view;
		this.view.update(lineNum);
		fwd = new Stack<Integer>();
		bck = new Stack<Integer>();
	}
	
	public void back()
	{
		if(hasBack())
		{
			lineNum = bck.peek();
			fwd.push(bck.peek());
			view.update(bck.pop());
		}
	}
	
	public void forward()
	{
		if(hasForward())
		{
			lineNum = fwd.peek();
			bck.push(fwd.peek());
			view.update(fwd.pop());
		}
	}
	
	public void home()
	{
		lineNum = 0;
		fwd = new Stack<Integer>();
		bck = new Stack<Integer>();
	}
	
	public void followLink(int n)
	{
		view.update(n);
		bck.push(lineNum);
		lineNum = n;
	}
	
	//return true means enable, return false means disable
	public boolean hasBack()
	{
		if(bck.isEmpty())
			return false;
		return true;
	}
	
	//return true means enable, return false means disable
	public boolean hasForward()
	{
		if(fwd.isEmpty())
			return false;
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public BrowserView getView() {
		return view;
	}

}
