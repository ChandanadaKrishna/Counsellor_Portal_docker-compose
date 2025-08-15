package in.ashokit.service;

import java.util.List;

import in.ashokit.Entity.Enquiry;
import in.ashokit.dto.ViewEnqFilter;

public interface EnquiryService {

	public boolean addEnquiry(Enquiry enquiry, Integer counsellorId) throws Exception;
	public List<Enquiry> getAllEnquiry(Integer counsellorId);
	public List<Enquiry> getAllEnquiryWithFilter(ViewEnqFilter view,Integer counsellorId);
	public Enquiry getEnquiry(Integer enquiryId);
	
	
}
