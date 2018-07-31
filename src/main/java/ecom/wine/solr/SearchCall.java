package ecom.wine.solr;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
public class SearchCall {
	
	private ObjectMapper mapper;
	private String port;
	private String serverName;
	private String collectionName;
	private String coreName;
	private String requestUrl = "http://%s:%s/solr/%s/%s";
	
	
	private String BaseUrl;
	
	public SearchCall() {
		mapper = new ObjectMapper();
	}
	
	public JsonNode execute() throws ClientProtocolException, IOException {
		JsonNode jsonnode = null;
		requestUrl = String.format(requestUrl,serverName,port,coreName,BaseUrl);
		
		HttpClient httpclient = new DefaultHttpClient(); 
		HttpGet request = new HttpGet(requestUrl);
		HttpResponse response = httpclient.execute(request);
		
		if(response.getStatusLine().getStatusCode() == 200){
			jsonnode = mapper.readTree(response.getEntity().getContent());
		}
		return jsonnode;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getCoreName() {
		return coreName;
	}

	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}

	public String getBaseUrl() {
		return BaseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		BaseUrl = baseUrl;
	}
}
