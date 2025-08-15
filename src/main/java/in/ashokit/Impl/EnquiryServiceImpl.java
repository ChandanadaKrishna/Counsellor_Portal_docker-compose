package in.ashokit.Impl;

import java.util.List;


import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import in.ashokit.Entity.Counsellor;
import in.ashokit.Entity.Enquiry;
import in.ashokit.dto.ViewEnqFilter;
import in.ashokit.repository.CounsellorRepo;
import in.ashokit.repository.EnquiryRepo;
import in.ashokit.service.EnquiryService;
import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryServiceImpl  implements EnquiryService{
	
	private CounsellorRepo counsellorRepo;
	private EnquiryRepo enquiryRepo;
	
	public EnquiryServiceImpl(CounsellorRepo counsellorRepo,EnquiryRepo enquiryRepo) {
		  this.counsellorRepo=counsellorRepo;
		  this.enquiryRepo=enquiryRepo;
	}

	@Override
	public boolean addEnquiry(Enquiry enquiry, Integer counsellorId) throws Exception {
		  Counsellor counsellor=counsellorRepo.findById(counsellorId).orElse(null);
		  if(counsellor.getCounsellorId() == null) {
			  throw new Exception("counsellor not found exception");
		  }
		 enquiry.setCounsellor(counsellor); 
		Enquiry save = enquiryRepo.save(enquiry);
		
		if(save.getEnquiryId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Enquiry> getAllEnquiry(Integer counsellorId) {
		List<Enquiry> list = enquiryRepo.getEnquiriesCounsellorId(counsellorId);
		return list;
	}

	@Override
	public List<Enquiry> getAllEnquiryWithFilter(ViewEnqFilter view, Integer counsellorId) {
		Enquiry enquiry=new Enquiry();
		
		if(StringUtils.isNotEmpty(view.getClassmode())) {
			enquiry.setClassmode(view.getClassmode());
		}
		if(StringUtils.isNotEmpty(view.getCoursename())) {
			enquiry.setCoursename(view.getCoursename());
		}
		if(StringUtils.isNotEmpty(view.getEnqstatus())) {
			enquiry.setEnqstatus(view.getEnqstatus());
		}
		Counsellor counsellor = counsellorRepo.findById(counsellorId).orElse(null);
		enquiry.setCounsellor(counsellor);
		Example<Enquiry> of = Example.of(enquiry);
		List<Enquiry> list = enquiryRepo.findAll(of);
		return list;
	}

	@Override
	public Enquiry getEnquiry(Integer enquiryId) {
		  Enquiry enquiry = enquiryRepo.findById(enquiryId).orElse(null);
		return enquiry;
	}

}
