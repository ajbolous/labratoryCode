package Utils;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;

public class DoctorsComparator implements Comparator<Object[]>{

	@Override
	public int compare(Object[] rec1, Object[] rec2) {
		String date1= (String) rec1[2];
		String date2= (String) rec2[2];
		if(date1.equals("") && date2.equals("")) return 0;
		if (date1.equals("") && !date2.equals("")) return 1;
		if(!date1.equals("") && date2.equals("")) return -1;
		if(!date1.equals("") && !date2.equals("")) {
			//dd/MM/yyyy
			String s_date1[]=date1.split("/");
			String s_date2[]=date2.split("/");
			Date time1 = new Date(Integer.parseInt(s_date1[2]), Integer.parseInt(s_date1[1]), Integer.parseInt(s_date1[0]));
			Date time2=new Date(Integer.parseInt(s_date2[2]), Integer.parseInt(s_date2[1]), Integer.parseInt(s_date2[0]));
			
			if(time1.before(time2)) return 1;
			if(time1.after(time2)) return -1;
			return 0;

		}
		return 0;

	}
	

}
