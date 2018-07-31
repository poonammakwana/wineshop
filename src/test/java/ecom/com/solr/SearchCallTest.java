package ecom.com.solr;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import ecom.wine.solr.SearchCall;

public class SearchCallTest {
	SearchCall searchCall = null;
	
	@Before
	public void setup() {
		searchCall = new SearchCall();
	}
	
	@Test
	public void testHttpRequest() throws ClientProtocolException, IOException {
		searchCall.setPort("80");
		searchCall.setServerName("35.207.23.50");
		searchCall.setCoreName("wineproject");
		searchCall.setBaseUrl("select?q=*:*");
		JsonNode jsonnode = searchCall.execute();
		assertNotNull(jsonnode);
	}

}
