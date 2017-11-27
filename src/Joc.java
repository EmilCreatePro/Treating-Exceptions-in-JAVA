
public class Joc 
{
	private String numeEchipa1, numeEchipa2;
	private int goluriEchipa1 = 0, goluriEchipa2 = 0;
	private Minge minge, pozVeche;
	public static int nrCornere = 0, nrOut = 0;
	
	public Joc(String nume1, String nume2, Minge minge)
	{
		numeEchipa1 = nume1;
		numeEchipa2 = nume2;
		
		this.minge = minge;
	}
	
	public void simuleaza()
	{
		for(int i = 0; i <= 1000; i++)
		{
			try
			{	
				pozVeche = minge;	
				minge.suteaza();
				
			}catch(Corner e)
				{
					nrCornere++;
					if(minge.getX() == 0)
					{
						if(minge.getY() >= 30)
							minge = new Minge(0,50);
						if(minge.getY() <=20)
							minge = new Minge(0,0);	
					}
					if(minge.getX() == 100)
					{
						if(minge.getY() >= 30)
							minge = new Minge(500, 50);
						if(minge.getY() <=20)
							minge = new Minge(500,0);	
					}
				}
			catch(Gol e)
			{
				if(minge.getX() == 0) goluriEchipa1++;
				if(minge.getX() == 100) goluriEchipa2++;
				minge = new Minge(50, 25);
			}
			catch(Out e)
			{
				nrOut++;
				minge = pozVeche;
			}
			System.out.println(toString());
		}
				
	}
	
	public String toString()
	{
		return "Echipa1: " + numeEchipa1 + " - Echipa2: " + numeEchipa2 + 
				"\nSCOR -> Echipa1: " + goluriEchipa1 + " --- Echipa2: " + goluriEchipa2 + 
				 "\nNumar Cornere:" + nrCornere + "\nNumar Out-uri: " + nrOut + "\n\n";
	}
	
	public static void main(String[] args) 
	{
		Minge minge = new Minge(50,25);
		
		Joc meci = new Joc("Steaua", "Barcelona", minge);
		
		meci.simuleaza();		
		
	}
	
}
