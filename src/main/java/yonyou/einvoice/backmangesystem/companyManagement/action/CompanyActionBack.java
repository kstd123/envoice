package yonyou.einvoice.backmangesystem.companyManagement.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import yonyou.einvoice.backmangesystem.companyManagement.service.ICompanyBackService;
import yonyou.einvoice.backmangesystem.companyManagement.util.AbstactAction;
import yonyou.einvoice.backmangesystem.companyManagement.util.HttpUtil;
import yonyou.einvoice.backmangesystem.companyManagement.util.SplitPageUtil;
import yonyou.einvoice.backmangesystem.companyManagement.vo.Company;

@RestController
public class CompanyActionBack extends AbstactAction{

	public static final Logger logger = LoggerFactory.getLogger(CompanyActionBack.class);
	
	@Resource
	private ICompanyBackService companyBackService;
	
	@RequestMapping("/company/list")
	public @ResponseBody Map<String, Object> list(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		SplitPageUtil spu = new SplitPageUtil(request,"corpname");
		Map<String,Object> result = this.companyBackService.list(spu.getColumn(),
				spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize());
		super.handleSplit(mav, result.get("companyCount"), spu.getColumn(), 
				spu.getKeyWord(),"back.company.list.page", spu);
		mav.addObject("allCompanys", result.get("allCompanys"));
		return mav.getModel();
	}
	
	@RequestMapping("/company/listNoOpen")
	public @ResponseBody Map<String, Object> listNoOpen(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		SplitPageUtil spu = new SplitPageUtil(request,"corpname");
		Map<String,Object> result = this.companyBackService.listNoOpen(spu.getColumn(), 
				spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize());
		super.handleSplit(mav, result.get("companyCount"), spu.getColumn(), 
				spu.getKeyWord(),"back.company.notopen.page", spu);
		mav.addObject("allCompanys", result.get("allCompanys"));
		return mav.getModel();
	}
	
	@RequestMapping("/company/batch")
	public String findAllByOpenBatchPermission(HttpServletRequest request){
	      List<String> ids = super.getBatchIds(request);
	      if(this.companyBackService.UpdateBatch(ids)){
	    	  return "success";
	      }
	      return "wrong";
	}
	
	@RequestMapping("/company/open")
	public void  findAllByOpenPermission(HttpServletResponse response,Company vo){
		String url = super.getMessageValue("back.company.list.open.url");
		JSONObject obj = new JSONObject();
		Map<String,String> parMap = new HashMap<String,String>();
		parMap.put("corpId", vo.getCorpid());
		parMap.put("type", "01");
		String body = HttpUtil.post(url,parMap);
		obj.put("types", body);
		super.printJson(response, obj);
	}
	
	@RequestMapping("/company/authorize")
	public void  findAllByOpenAuthorize(HttpServletResponse response,HttpServletRequest request){
		String url = super.getMessageValue("back.company.list.authorize.url");
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		List<String> ids = super.getBatchIds(request);
		Iterator<String> iter = ids.iterator();
		while(iter.hasNext()){
			array.add(iter.next());
		}
		Map<String,String> parMap = new HashMap<String,String>();
		parMap.put("type", "01");
		parMap.put("corpId", array.toString());
		String body = HttpUtil.post(url,parMap);
		obj.put("types", body);
		super.printJson(response, obj);
	}
}
