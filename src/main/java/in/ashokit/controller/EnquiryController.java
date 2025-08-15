package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import in.ashokit.Entity.Enquiry;
import in.ashokit.dto.DashboardResponse;
import in.ashokit.dto.ViewEnqFilter;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class EnquiryController {
  private EnquiryService enquiryService;
  private CounsellorService counsellorService;
  
  
  public EnquiryController(EnquiryService enquiryService,CounsellorService counsellorService) {
	  this.enquiryService=enquiryService;
	  this.counsellorService=counsellorService;
  }
  
  
     @GetMapping("/enquiry")
	  public String addEnquiryPage(Model model) {
		  Enquiry enquiry=new Enquiry();
		   model.addAttribute("enquiry", enquiry);
		  return "enquiryForm";
	  }
     
     @PostMapping("/addEnquiry")
     public String handleEnquiry(Enquiry enquiry,HttpServletRequest request,Model model) throws Exception {
    	  HttpSession session = request.getSession(false);
    	  Integer attribute = (Integer)  session.getAttribute("counsellorId");
    	   boolean b = enquiryService.addEnquiry(enquiry, attribute);
    	   if(b) {
    		   model.addAttribute("smsg", "enquiry added successfully");
    	   }
    	   else {
    		   model.addAttribute("emsg", "enquiry not added");
    	   }
    	 return "enquiryForm";
     }
     
     
     @GetMapping("/editenquiry")
     public String egitEnq(@RequestParam("enquiryId") Integer enquiryId,Model model) {
    	 Enquiry enquiry = enquiryService.getEnquiry(enquiryId);
    	 model.addAttribute("enquiry", enquiry);
    	 
    	 return "enquiryForm";
     }
     
     
     @GetMapping("/view-enq")
     public String viewAllenq(HttpServletRequest request,Model model) {
    	 HttpSession session = request.getSession(false);
    	 Integer attribute = (Integer) session.getAttribute("counsellorId");
    	 
    	 List<Enquiry> enquiries = enquiryService.getAllEnquiry(attribute);
    	 model.addAttribute("enquiries", enquiries);
    	 
    	ViewEnqFilter filter =new ViewEnqFilter();
    	model.addAttribute("filter", filter);
    	 return "viewEnqPage";
     }
     
     
     @PostMapping("/filter-enq")
     public String viewAllEnqWithFilter(ViewEnqFilter filter,HttpServletRequest request,Model model) {
    	
    	 HttpSession session = request.getSession(false);
    	 Integer attribute =(Integer) session.getAttribute("counsellorId");
    	 
    	 model.addAttribute("filter",filter);
    	 
    	 List<Enquiry> enquiries = enquiryService.getAllEnquiryWithFilter(filter, attribute);
    	 model.addAttribute("enquiries",enquiries );
    	 return "viewEnqPage";
    	 
     }
     
//     @GetMapping("/dashboard")
// 	public String viewDashBoard(HttpServletRequest request,Model model) {
// 		
// 		HttpSession session = request.getSession(false);
// 		Integer attribute =(Integer) session.getAttribute("counsellorId");
// 		
// 		DashboardResponse dbobj = counsellorService.getDashboardInfo(attribute);
// 		model.addAttribute("dashboardInfo",dbobj );
// 		
// 		return "dashboard";
// 	}
	
}
