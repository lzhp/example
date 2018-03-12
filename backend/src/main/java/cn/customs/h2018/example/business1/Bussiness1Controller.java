package cn.customs.h2018.example.business1;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 4800)
@RestController
public class Bussiness1Controller {

	@RequestMapping("/")
	public Object test() {

		List<Bussiness1> result = Lists.newArrayList();

		result.add(new Bussiness1(1, "title1", "body2221"));
		result.add(new Bussiness1(2, "title2", "body2222"));
		result.add(new Bussiness1(3, "title3", "body2223"));
		result.add(new Bussiness1(4, "title4", "body2224"));
		result.add(new Bussiness1(5, "title5", "body2225"));
		result.add(new Bussiness1(6, "title6", "body2226"));

		return result;
	}
	
	@RequestMapping("/t")
	public Object test2() {

		List<Bussiness1> result = Lists.newArrayList();

		result.add(new Bussiness1(1, "ttitle1", "body2221"));
		result.add(new Bussiness1(2, "ttitle2", "body2222"));
		result.add(new Bussiness1(3, "ttitle3", "body2223"));
		result.add(new Bussiness1(4, "ttitle4", "body2224"));
		result.add(new Bussiness1(5, "ttitle5", "body2225"));
		result.add(new Bussiness1(6, "ttitle6", "body2226"));

		return result;
	}	
	
	@RequestMapping("/t1")
	public Object test3() {

		List<Bussiness1> result = Lists.newArrayList();

		result.add(new Bussiness1(1, "t1", "body2221"));
		result.add(new Bussiness1(2, "ttitle2", "body2222"));
		result.add(new Bussiness1(3, "ttitle3", "body2223"));
		result.add(new Bussiness1(4, "ttitle4", "body2224"));
		result.add(new Bussiness1(5, "ttitle5", "body2225"));
		result.add(new Bussiness1(6, "ttitle6", "body2226"));

		return result;
	}	
	
	@RequestMapping("/t2")
	public Object test4() {

		List<Bussiness1> result = Lists.newArrayList();

		result.add(new Bussiness1(1, "t2", "body2221"));
		result.add(new Bussiness1(2, "ttitle2", "body2222"));
		result.add(new Bussiness1(3, "ttitle3", "body2223"));
		result.add(new Bussiness1(4, "ttitle4", "body2224"));
		result.add(new Bussiness1(5, "ttitle5", "body2225"));
		result.add(new Bussiness1(6, "ttitle6", "body2226"));

		return result;
	}	

}
