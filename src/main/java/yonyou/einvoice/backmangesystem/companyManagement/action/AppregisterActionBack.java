package yonyou.einvoice.backmangesystem.companyManagement.action;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import yonyou.einvoice.backmangesystem.companyManagement.service.IAppregisterBackService;
import yonyou.einvoice.backmangesystem.companyManagement.util.AbstactAction;
import yonyou.einvoice.backmangesystem.companyManagement.util.HttpUtil;
import yonyou.einvoice.backmangesystem.companyManagement.util.SplitPageUtil;
import yonyou.einvoice.backmangesystem.companyManagement.vo.Appregister;
import yonyou.einvoice.backmangesystem.companyManagement.vo.Company;

@RestController
@RequestMapping("/pages/*")
public class AppregisterActionBack extends AbstactAction {

	public static final Logger logger = LoggerFactory.getLogger(AppregisterActionBack.class);
	
	@Resource
	private IAppregisterBackService appregisterBackService;
	
	@RequestMapping("appregister")
	public @ResponseBody Map<String,Object> list(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		SplitPageUtil spu = new SplitPageUtil(request, "createtime");
		Map<String,Object> result = this.appregisterBackService.list(spu.getColumn(), 
				spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize());
		super.handleSplit(mav, result.get("appregisterCount"), spu.getColumn(), 
				spu.getKeyWord(),"back.appregister.list.page", spu);
		mav.addObject("allAppregisters",result.get("allAppregisters"));
		return mav.getModel();
	}	
	
	
	@RequestMapping("/upload")
    public void uploadFile(Company vo,MultipartFile pic,HttpServletResponse response){
		String url=super.getMessageValue("back.comapny.list.upload.url");
		byte [] bytes = super.getByteFile(pic);
		vo.setFile(bytes);
		JSONObject obj = new JSONObject();
		Map<String,String> parMap = new HashMap<String,String>();
		parMap.put("corpId", vo.getCorpid());
		parMap.put("corpName", vo.getCorpname());
		parMap.put("cert", vo.getFile().toString());
		String body = HttpUtil.post(url,parMap);
		obj.put("types", body);
		super.printJson(response, obj);
	}
	
	@RequestMapping("/get")
	public Appregister get(Integer id){
		return this.appregisterBackService.get(id);
	}
}
