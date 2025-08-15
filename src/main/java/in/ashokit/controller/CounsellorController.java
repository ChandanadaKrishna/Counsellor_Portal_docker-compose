package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.Entity.Counsellor;
import in.ashokit.Entity.Enquiry;
import in.ashokit.dto.DashboardResponse;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CounsellorController {

	private CounsellorService counsellorService;
	private EnquiryService enquiryService;

	public CounsellorController(CounsellorService counsellorService, EnquiryService enquiryService) {
		this.counsellorService = counsellorService;
		this.enquiryService = enquiryService;
	}

	@GetMapping("/")
	public String index(Model model) {

		Counsellor counsellor = new Counsellor();
		model.addAttribute("counsellor", counsellor);
		return "index";
	}

	@PostMapping("/login")
	public String login(Counsellor counsellor, HttpServletRequest request, Model model) {
		Counsellor c = counsellorService.login(counsellor.getEmail(), counsellor.getPassword());
		if (c == null) {
			model.addAttribute("emsg", "invalid credentials");
			return "index";
		} else {

			HttpSession session = request.getSession(true);
			session.setAttribute("counsellorId", c.getCounsellorId());
			return "redirect:/dashboard";
		}

	}

	@GetMapping("/dashboard")
	public String viewDashBoard(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		Integer attribute = (Integer) session.getAttribute("counsellorId");

		DashboardResponse dbobj = counsellorService.getDashboardInfo(attribute);
		model.addAttribute("dashboardInfo", dbobj);

		return "dashboard";
	}

	@GetMapping("/register")
	public String Registerpage(Model model) {

		Counsellor counsellor = new Counsellor();
		model.addAttribute("counsellor", counsellor);
		return "register";
	}

	@PostMapping("/register")
	public String handleRegister(@Valid Counsellor counsellor, BindingResult result, Model model,HttpServletRequest request) {
//      HttpSession session = request.getSession(true);
//      session.setAttribute("id", session);
//      session.invalidate();
		if (result.hasErrors()) {

			// validation failed
			return "register";
		} else {
			Counsellor byEmail = counsellorService.findByEmail(counsellor.getEmail());
			if (byEmail != null) {
				model.addAttribute("emsg", "duplicate email");
				return "register";
			}

			boolean registration = counsellorService.registration(counsellor);
			if (registration) {
				model.addAttribute("smsg", "sucessfully registred");
			} else {
				model.addAttribute("emsg", "registration not done");
			}
			return "register";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}

}
