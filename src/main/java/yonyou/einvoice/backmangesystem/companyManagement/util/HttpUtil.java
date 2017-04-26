package yonyou.einvoice.backmangesystem.companyManagement.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jodd.http.HttpRequest;

public class HttpUtil {

	 private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	 
	 public static String get(String url) {
	        logger.info("GET璇锋眰鐨勫湴鍧� url:{}", url);
	        return HttpRequest.get(url).send().body();
	    }
	 
	 public static String get(String url, Map<String, String> parMap) {
	        logger.info("GET璇锋眰鐨勫湴鍧� url:{},parMap:{}", url, parMap);
	        HttpRequest httpRequest = HttpRequest.get(url);
	        httpRequest.query(parMap);
	        return httpRequest.send().body();
	    }
	 
	 public static synchronized String post(String url, Map<String, String> parMap) {
	        logger.info("POST璇锋眰鐨勫湴鍧� url:{},parMap:{}", url, parMap);
	        String signName = JwtInnerUtils.sign(null);
	        HttpRequest httpRequest = HttpRequest.post(url);
	        httpRequest.query(parMap);
	        httpRequest.header("sign", signName);
	        return httpRequest.send().bodyText();
	    }
	 
	 public static synchronized String post(String url, String body) {
	        logger.info("BODY璇锋眰鐨勫湴鍧� url:{},body:{}", url, body);
	        HttpRequest httpRequest = HttpRequest.post(url);
	        httpRequest.bodyText(body);
	        return httpRequest.send().bodyText();
	    }
}
