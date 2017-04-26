package yonyou.einvoice.backmangesystem.parameterManagement.util;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.bouncycastle.util.io.pem.PemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.compression.CompressionCodecs;
public class JwtInnerUtils {

	  /**
	  * 
	  */
	  private static final String INNER_KEY = "com.yonyou.einvoice";

	  /**
	   * 
	   */
	  private static final String PIAOEDA = "piaoeda";

	  /**
	   * 
	   */
	  private static final String YONYOU_EINVOICE = "yonyou einvoice";

	  private static Logger logger = LoggerFactory.getLogger(JwtInnerUtils.class);

	  private static volatile PrivateKey privateKey;

	  private static volatile PublicKey publicKey;

	  private static Object pubKeyLock = new Object();

	  private static Object privateKeyLock = new Object();

	  private static final String CODE = "utf-8";

	  /**
	   * ǩ��
	   * 
	   * @param datas ǩ�����
	   * @return
	   */
	  public static String sign(Map<String, Object> datas) {
	    Map<String, Object> claims =
	        JwtParamBuilder.build().setSubject(PIAOEDA).setIssuer(YONYOU_EINVOICE).setAudience(PIAOEDA)
	            .addJwtId().addIssuedAt().setExpirySeconds(300).setNotBeforeSeconds(300).getClaims();
	    if (MapUtils.isNotEmpty(datas)) {
	      claims.putAll(datas);
	    }
	    String compactJws =
	        Jwts.builder().signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(INNER_KEY))
	            .setClaims(claims).compressWith(CompressionCodecs.DEFLATE).compact();

	    return compactJws;
	  }

	  /**
	   * ��ǩ
	   * 
	   * @param token
	   */
	  public static void verify(String token) {
	    Jwts.parser().requireIssuer(YONYOU_EINVOICE).requireAudience(PIAOEDA).requireSubject(PIAOEDA)
	        .setSigningKey(TextCodec.BASE64.encode(INNER_KEY)).parse(token);
	  }

	  /**
	   * @return
	   */
	  public static PublicKey getPublicKey() {
	    if (publicKey == null) {
	      synchronized (pubKeyLock) {
	        if (publicKey == null) {
	          try {
	            PemReader pubreader = new PemReader(new InputStreamReader(
	                /**
	                 * 2016-7-26 huangyimiao findBugs���� �ӱ��뷽ʽ��"utf-8"
	                 */
	                JwtInnerUtils.class.getResourceAsStream("/einvoiceInner.pub"), CODE));
	            byte[] pubKeyBytes = pubreader.readPemObject().getContent();
	            pubreader.close();
	            X509EncodedKeySpec pubspec = new X509EncodedKeySpec(pubKeyBytes);
	            KeyFactory pubkf = KeyFactory.getInstance("RSA");
	            publicKey = pubkf.generatePublic(pubspec);
	          } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
	            logger.error("��ȡ��ǩ��Կʧ�ܣ�", e);
	          }
	        }
	      }
	    }
	    return publicKey;
	  }

	  /**
	   * @return
	   */
	  public static PrivateKey getPrivateKey() {
	    if (privateKey == null) {
	      synchronized (privateKeyLock) {
	        if (privateKey == null) {
	          try {
	            PemReader reader = new PemReader(new InputStreamReader(
	                /**
	                 * 2016-7-26 huangyimiao findBugs���� �ӱ��뷽ʽ��"utf-8"
	                 */
	                JwtInnerUtils.class.getResourceAsStream("/einvoiceInner"), CODE));
	            byte[] privateKeyBytes = reader.readPemObject().getContent();
	            reader.close();
	            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
	            KeyFactory kf = KeyFactory.getInstance("RSA");
	            privateKey = kf.generatePrivate(spec);
	          } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
	            logger.error("��ȡǩ����Կʧ�ܣ�", e);
	          }
	        }
	      }
	    }
	    return privateKey;
	  }

	}
