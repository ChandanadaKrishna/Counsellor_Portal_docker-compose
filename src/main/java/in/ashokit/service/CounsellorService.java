package in.ashokit.service;

import in.ashokit.Entity.Counsellor;
import in.ashokit.dto.DashboardResponse;

public interface CounsellorService {
	public Counsellor findByEmail(String Email);
	public Counsellor login(String email,String password);
	public boolean registration(Counsellor counsellor);
	
	public DashboardResponse getDashboardInfo(Integer counsellorId);
	
	
}
