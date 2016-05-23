# labratoryCode
# http://waqet.info/ghealth/


	QueryBuilder<Appointment,Integer> q = appointments.queryBuilder();
		//	q.selectColumns("patient_id");
			q.where().between("appointmentTime", Utils.DateTime.getDate(2016, 10, 5, 0, 0), Utils.DateTime.getDate(2016, 10, 7));
			
			List<Appointment> lp  = q.query();
			int x=  lp.size();
			
			x = 0;
