package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "examination_Referrals")
public class ExaminationReferral extends Entity{ 
	
		@DatabaseField(generatedId = true)
		private int eRid ; 
		
		@DatabaseField()
		private String Discription;
		
		@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "treatment_id")
		private Treatment treatment;

		public int geteRid() {
			return eRid;
		}

		public void seteRid(int eRid) {
			this.eRid = eRid;
		}

		public String getDiscription() {
			return Discription;
		}

		public void setDiscription(String discription) {
			Discription = discription;
		}

}


