package ShitaJdbc.ShitaJdbc;

import java.util.Date;

public class CalenderPopupCaptureSystemDate {
	public static void main(String [] args)
	{
		Date dobj=new Date();
			
		String currentSystemdate=dobj.toString();
		System.out.println(currentSystemdate);
		
		String aar[]=currentSystemdate.split(" ");
		System.out.println();
		String var= aar[0];
		String date= aar[2];
		String month= aar[1];
		String year= aar[5];
		System.out.println(var+" "+date+" "+month+" "+year+" ");
	}

}
