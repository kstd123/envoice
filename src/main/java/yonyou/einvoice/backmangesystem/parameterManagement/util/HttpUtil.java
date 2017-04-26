package yonyou.einvoice.backmangesystem.parameterManagement.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jodd.http.HttpRequest;
import yonyou.einvoice.backmangesystem.companyManagement.util.JwtInnerUtils;

public class HttpUtil {

	 private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	 public static String post(String url, String body) {
	        HttpRequest httpRequest = HttpRequest.post(url);
	        httpRequest.bodyText(body);
	        String signName = JwtInnerUtils.sign(null);
	        httpRequest.header("sign", signName);
	        return httpRequest.send().bodyText();
	    }
}
