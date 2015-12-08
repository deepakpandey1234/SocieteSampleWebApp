package com.deepak.societe.com.SocieteSampleWebApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;

import com.deepak.societe.com.Model.UserData;
import com.deepak.societe.com.util.CSVUtil;

/**
 * @author dpandey
 *
 */
@Controller
public class HomeController {
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public @ResponseBody HashMap<String, UserData> getAll() {
		return new HashMap<String,UserData>(new CSVUtil().parseCsv());
	}
	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public @ResponseBody int countUsers() {
		return new HashMap<String,UserData>(new CSVUtil().parseCsv()).size();
	}
		
	@RequestMapping(value="/greetings",method=RequestMethod.GET)
	public @ResponseBody String wish(){
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

		if(timeOfDay >= 0 && timeOfDay < 12){
		    return "Good Morning";  
		}else if(timeOfDay >= 12 && timeOfDay < 16){
		    return "Good Afternoon";
		}else if(timeOfDay >= 16 && timeOfDay < 24){
		    return "Good Evening";
		}
		return null;
	}
	//Search is based on id or status and both also
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody ArrayList<UserData> search(@RequestParam(value = "id", required = false,defaultValue = "null",@RequestParam(value = "status", required = false,defaultValue = "null") String status) {
		HashMap<String, UserData> hm = new HashMap<String, UserData>(new CSVUtil().parseCsv());
		ArrayList<UserData> list = new ArrayList<UserData>();
		for (UserData UserData : hm.values()) {
			if (UserData.getId().compareTo(ID) == 0) {
				list.add(UserData);
			}
			if(UserData.getStatus().compareTo(status)==0){
				list.add(userData);
			}
		}
		return list;
	}
}
