
public class Die {
	
	public int faces, die;

	public Die(int faces) {
		// TODO Auto-generated constructor stub
		this.faces = faces;
	}

	/**
	 * @return the faces
	 */
	public int getFaces() {
		return faces;
	}

	/**
	 * @param faces the faces to set
	 */
	public void setFaces(int faces) {
		this.faces = faces;
	}

	/**
	 * @return the die
	 */
	public int getDie() {
		return die;
	}

	/**
	 * @param die the die to set
	 */
	public void setDie(int die) {
		this.die = die;
	}
	
	public int roll()
	{
		return (int)(Math.random() * faces);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int oneFaces, twoFaces, numRolls;
		
		oneFaces = 	(args.length > 0) ? Integer.parseInt(args[0]) : 6;
		twoFaces = (args.length > 1) ? Integer.parseInt(args[1]) : 12;
		
		numRolls = (args.length > 2) ? Integer.parseInt(args[2]) : 10;
		
		Die one = new Die(oneFaces);
		Die two = new Die(twoFaces);
		
		for (int roll = 1; roll <= numRolls; roll++) {
			System.out.println(one + " and " + two);
			one.roll();
			two.roll();
		}
		
	}
	
	public String toString()
	{
		//return "Die [faces
		return 
	}

}
