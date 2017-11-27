
public class Minge 
{
	private int X, Y;
	private CoordinateGenerator cg = new CoordinateGenerator();
	
	public Minge(int x, int y)
	{
		X = x;
		Y = y;
	}
	
	public int getX()
	{
		return X;
	}
	
	public int getY()
	{
		return Y;
	}
	
	public void suteaza() throws Corner, Gol, Out
	{	
		X = cg.generateX();
		Y = cg.generateY();
		
		//System.out.println("X = " + X + " si Y = " + Y);
		
		if(Y == 0 || Y == 50)
		{
			throw new Out();
		}
		if((X == 0 || X == 100) && (Y>=20 && Y<=30))
		{
			throw new Gol();
		}
		if((X == 0 || X == 100) && ((Y>=0 && Y<=20) || (Y>=30 && Y<=50)))
		{
			throw new Corner();
		}
			
	}
	
	

}
