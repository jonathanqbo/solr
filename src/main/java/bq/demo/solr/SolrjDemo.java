package bq.demo.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

public class SolrjDemo {
	
	private SolrClient solr;
	
	@Before
	public void setup(){
		String zkHostString = "192.168.0.46:2181,192.168.0.46:2182,192.168.0.46:2183/solr";
		solr = new CloudSolrClient(zkHostString);
	}

	@Test
	public void test(){
		try{
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("name", "boqi1");
			doc.addField("hobby", "solr");
			
			UpdateResponse response = solr.add("bqcollect1",doc);
			System.out.println(response.toString());
			
			solr.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} finally{
			try {
				solr.close();
			} catch (IOException e) {
			}
		}
	}
	
	
	
	
}
