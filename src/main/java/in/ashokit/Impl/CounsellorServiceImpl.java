package in.ashokit.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.ashokit.Entity.Counsellor;
import in.ashokit.Entity.Enquiry;
import in.ashokit.dto.DashboardResponse;
import in.ashokit.repository.CounsellorRepo;
import in.ashokit.repository.EnquiryRepo;
import in.ashokit.service.CounsellorService;


@Service
public class CounsellorServiceImpl implements CounsellorService{
	
	private CounsellorRepo counsellorRepo;
	private EnquiryRepo enquiryRepo;
	
	public CounsellorServiceImpl(CounsellorRepo counsellorRepo,EnquiryRepo enquiryRepo) {
		this.counsellorRepo=counsellorRepo;
		this.enquiryRepo=enquiryRepo;
	}

	@Override
	public Counsellor findByEmail(String Email) {
		Counsellor byEmail = counsellorRepo.findByEmail(Email);
		return byEmail;
	}

	@Override
	public Counsellor login(String email, String password) {
		Counsellor counsellor = counsellorRepo.findByEmailAndPassword(email, password);
		return counsellor;
	}

	@Override
	public boolean registration(Counsellor counsellor) {
		Counsellor save = counsellorRepo.save(counsellor);
		if(save.getCounsellorId() !=null) {
			return true;
		}
		return false;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorId) {
		DashboardResponse dashboardResponse=new DashboardResponse();
		List<Enquiry> list = enquiryRepo.getEnquiriesCounsellorId(counsellorId);
		int totalenq = list.size();
		    int enrolledenq = list.stream()
		    		   .filter(a->a.getEnqstatus().equals("Enrolled"))
		               .collect(Collectors.toList()).size();
		    int openenq = list.stream()
		    		   .filter(a->a.getEnqstatus().equals("Open"))
		               .collect(Collectors.toList()).size();
		    int lostenq = list.stream()
		    		   .filter(a->a.getEnqstatus().equals("Lost"))
		               .collect(Collectors.toList()).size();
		    
		    dashboardResponse.setTotalEnq(totalenq);
		    dashboardResponse.setEnrolledEnq(enrolledenq);
		    dashboardResponse.setLostEnq(lostenq);
		    dashboardResponse.setOpenEnq(openenq);
		return dashboardResponse;
	}

}
