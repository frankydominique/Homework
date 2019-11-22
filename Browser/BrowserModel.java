/**
 * 
 */

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
		if(!hasBack())
			return;
		fwd.push(bck.peek());
		bck.pop();
		lineNum--;
	}
	
	public void forward()
	{
		if(!hasForward())
			return;
		bck.push(fwd.peek());
		fwd.pop();
		lineNum++;
	}
	
	public void home()
	{
		lineNum = 0;
		fwd = new Stack<Integer>();
		bck = new Stack<Integer>();
	}
	
	public void followLink(int n)
	{
		lineNum = n;
		bck.push(lineNum);
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
