package com.example.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class login {
	public static Cookie cookie;
	//1登录（李璇）
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject getByJSON(@RequestBody JSONObject jsonParam,HttpServletResponse response) {
	    // 直接将json信息打印出来
//	    System.out.println(jsonParam.toString());
	    String phoneArea=jsonParam.getString("phoneArea");
	    String phoneNumber=jsonParam.getString("phoneNumber");
	    String password=jsonParam.getString("password");
	    
	    JSONObject result=new JSONObject();
	 
		if (phoneArea.equals("86") && phoneNumber.equals("20000000000") && password.equals("netease123")) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			 result.element("msg", "登录成功");
		}
		else {
			 result.element("msg", "用户名或密码错误，登录失败");
		}
		return result;
	}
	
//	2获取商品信息（李璇，不需要登录，且不带参数）
	@RequestMapping(value = "/skuList")
		public JSONObject getGoods1(String para) {
			Map<String, Object> goods = new HashMap<String, Object>();
			goods.put("笔记本", "5000");
			goods.put("手机", "60");
			JSONObject result = new JSONObject();
			return result.element("msg","获取商品信息成功");
		}
	
//  2获取商品信息（周倩倩）
	@RequestMapping(value = "/common/skuList")
		public JSONObject getGoods(HttpServletRequest request) {
		 	String id = request.getParameter("id");
		 	//System.out.println(id);
			JSONObject goods = new JSONObject();
			JSONObject goods1 = new JSONObject();
			JSONObject goods2 = new JSONObject();
			JSONObject goods3 = new JSONObject();
			JSONObject goods4 = new JSONObject();
			goods.put("id", "1");
			goods.put("笔记本", "5000");
			goods1.put("id", "2");
			goods1.put("纯甄酸奶", "69");
			goods2.put("id", "3");
			goods2.put("牛奶", "45");
			goods3.put("id", "4");
			goods3.put("可乐", "5");
			goods4.put("id", "5");
			goods4.put("羽绒服", "389");
			List<JSONObject> list = new ArrayList<JSONObject>();
			list.add(goods);
			list.add(goods1);
			list.add(goods2);
			list.add(goods3);
			list.add(goods4);
			JSONObject result = new JSONObject();
			for(JSONObject json : list) {
				String value = json.getString("id");
				if(id.equals(value)) {
					return json;
				}
				else {
					result.element("goods"+value, json);
				}
			}
			return result;
		}

	// 3获取地址（张帆）
		@RequestMapping("/getAddress")
		public JSONObject getAddress(HttpServletRequest request) {
			String id = request.getParameter("id");
			Cookie[] cookies = request.getCookies();
			JSONObject result = new JSONObject();
			JSONObject address = new JSONObject();
			JSONObject address1 = new JSONObject();
			JSONObject address2 = new JSONObject();
			
			address.put("id", "1");
			address.put("province", "河北省");
			address.put("area", "石家庄市_裕华区");
			address1.put("id", "2");
			address1.put("province", "重庆市");
			address1.put("area", "沙坪坝区");
			address2.put("id","3");
			address2.put("msg","无地址！");
			
			List<JSONObject> list = new ArrayList<JSONObject>();
			list.add(address);
			list.add(address1);
			for(JSONObject json : list) {
				String value = json.getString("id");
				result.element("address"+value,json);
			}
			
			if (Objects.isNull(cookies)) {
				return result.element("message","请先登录");
			}
			
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
					for(JSONObject json1 : list) {
						String value1 = json1.getString("id");
						if(id.equals(value1)) {
							return json1; 
						}
						else {
							result.element("address"+value1,json1);
						}
					}
					if(id.equals("3")) {
						return address2;
					}
				}
			}
			return result;
		}

	//4获取运费（李璇）
	 @RequestMapping(value="/getfee", method = RequestMethod.GET)
	    public Map<String, Object> getList(HttpServletRequest request,@RequestParam String address){
		  Cookie[] cookies = request.getCookies();
		  Map<String, Object> fee=new HashMap<>(); 
		  String id = request.getParameter("id");
		  if (Objects.isNull(cookies)) {
			  fee.put("msg","未登录");
			}
		  for(Cookie cookie : cookies) {
			  if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				  if(id.equals("1")&&address.equals("河北省_石家庄市_裕华区")){
			        fee.put("fee", "10元");
			        fee.put("address","河北省_石家庄市_裕华区");
			        fee.put("msg","获取运费成功");
				  }
				  else if(id.equals("2")&&address.equals("重庆市_沙坪坝区")){
			        fee.put("fee", "20元");
			        fee.put("address","重庆市_沙坪坝区");
			        fee.put("msg","获取运费成功");
				  }
				  else 
				  {
					  fee.put("msg", "请求成功");
				  }
			  }
		  }
		return fee;
	    }
	 
//		5、添加地址（周倩倩）
		@RequestMapping(value = "/fgadmin/address/new", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
		public JSONObject addAddress(@RequestBody JSONObject jsonParam,HttpServletResponse response,HttpServletRequest request) {
//			得到请求中的cookie
			Cookie[] cookies = request.getCookies();
//			列表存储模拟原来的地址
			Map<String, Object> goods = new HashMap<String, Object>();
			goods.put("province", "浙江");
			goods.put("area", "大学");
			goods.put("id", "1");
			Map<String, Object> goods1 = new HashMap<String, Object>();
			goods1.put("province", "浙江");
			goods1.put("area", "大学");
			goods1.put("id", "2");
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			list.add(0, goods);
			list.add(0, goods1);
			
			
//			得到请求中的参数
			String province = jsonParam.getString("province");
			String area = jsonParam.getString("area");
			String id = jsonParam.getString("id");
			JSONObject result = new JSONObject();
			
//			判断是否登录成功
			if (Objects.isNull(cookies)) {
				return result.element("msg","请先登录");
			}
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
					if(list.size()<6) {
						Map<String, Object> goods2 = new HashMap<String, Object>();
						goods2.put("province", province);
						goods2.put("area", area);
						goods2.put("id", id);
						list.add(goods2);
						for(Map<String, Object> map:list){
							String value = (String) map.get("id");
							if(id.equals(value)) {
								return result.element("msg","添加地址成功");
							}
						}
					}
						return result.element("message","地址不能超过6个！");
				}
			}
			return result.element("msg","添加地址失败");
		}

		
	//6提交订单（张帆）	
	@RestController
	public class Submit {
		@ResponseBody
		@RequestMapping(value="/qingguo/submit",method=RequestMethod.POST,produces="application/json;charset=uTF-8")
		public JSONObject doPostSubmit(@RequestBody JSONObject jsonParam,HttpServletResponse response,HttpServletRequest request) {
			//System.out.println(jsonParam.toString());
			String skuIds=jsonParam.getString("skuIds");
			String receiverName=jsonParam.getString("receiverName");
			String cellPhone=jsonParam.getString("cellPhone");
			String addressDetail=jsonParam.getString("addressDetail");
			String province=jsonParam.getString("province");
			String city=jsonParam.getString("city");
			String area=jsonParam.getString("area");
			String transportFee=jsonParam.getString("transportFee");
			
			JSONObject result=new JSONObject();
			
			Cookie[] cookies=request.getCookies();
			if(Objects.isNull(cookies)) {
				result.element("msg","请先登录");
			}
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("login")&&cookie.getValue().equals("true")) {
					if(skuIds!=null&&receiverName!=null&&cellPhone!=null&&addressDetail!=null&&province!=null&&city!=null&&area!=null&&transportFee!=null) {
						result.element("msg","成功提交订单");
					} 
					else {
						result.element("msg","请填写正确的信息！" );
					}
				}
			}
			return result;
		}

	}

//7、删除地址（郭晓丽）
@RequestMapping(value = "/fgadmin/address/delete", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
public JSONObject deleteAddress(@RequestBody JSONObject jsonParam,HttpServletResponse response,HttpServletRequest request) {
//得到请求中的cookie
		Cookie[] cookies = request.getCookies();
		//列表存储模拟原来的地址
		Map<String, Object> goods = new HashMap<String, Object>();
		goods.put("province", "浙江");
		goods.put("area", "大学");
		goods.put("id", "1");
		Map<String, Object> goods1 = new HashMap<String, Object>();
		goods1.put("province", "浙江");
		goods1.put("area", "大学");
		goods1.put("id", "2");
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list.add(0, goods);
		list.add(1, goods1);
		
		
		//得到请求中的参数
		String province = jsonParam.getString("province");
		String area = jsonParam.getString("area");
		String id = jsonParam.getString("id");
		JSONObject result = new JSONObject();
		
		//判断是否登录成功
		if (Objects.isNull(cookies)) {
			return result.element("message","请先登录");
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
		//		Map<String, Object> goods2 = new HashMap<String, Object>();
		//		goods2.put("province", province);
		//		goods2.put("area", area);
		//		goods2.put("id", id);
		//		list.add(goods2);
				for(Map<String, Object> map:list){
					String value = (String) map.get("id");
					if(id.equals(value)) {
						list.remove(id);
						return result.element("msg","删除地址成功");
					}
				}
			}
		}
		return result.element("msg","删除地址失败");
 }
}


