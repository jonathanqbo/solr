package bq.demo.solr;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class SimpleRestRequest {

//	@Test
	public void test() throws ClientProtocolException, IOException, URISyntaxException{
		URIBuilder ub = new URIBuilder("http://192.168.0.50:8983/solr/admin/collections")
				.addParameter("action", "CREATE")
				.addParameter("name", "bqcollection" + new Random().nextInt(100))
				.addParameter("numShards", "1")
				.addParameter("replicationFactor", "2")
				.addParameter("collection.configName", "bq_config_set");
		
		HttpGet get = new HttpGet(ub.build());
		
		CloseableHttpResponse response = HttpClients.createDefault().execute(get);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}
	
	@Test
	public void testCreate() throws ClientProtocolException, IOException{
//		String jsonStr = "{\"id\" : \"MyTestDocument\",\"title\" : \"This is just a test\"}";
//		
//		
//		HttpPost post = new HttpPost("http://192.168.0.50:8983/solr/bqcollection28/update");
//		post.addHeader("Content-type", "application/json");
//		post.setEntity(new StringEntity(jsonStr));
//		
//		CloseableHttpResponse response = HttpClients.createDefault().execute(post);
//		System.out.println(EntityUtils.toString(response.getEntity()));
	}
	
	
}
