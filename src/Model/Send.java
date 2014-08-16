package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Send {
	String PAMValue;
	String TargetGenomeValue;
	String IDValue;
	String PositionValue;
	String Value1;
	String lines;
	StringBuffer value=new StringBuffer();
	public String GET_URL="http://192.168.10.101:8080/get?";
	
	
    	public Send(String TargetGenomeValue,String PAMValue,String IDValue,String PositionValue) {
		    this.TargetGenomeValue = TargetGenomeValue;
		    this.PAMValue=PAMValue;
		    this.IDValue=IDValue;
		    this.PositionValue=PositionValue;
//		    List<NameValuePair> params=new ArrayList<NameValuePair>();
//			params.addAll((Collection<? extends NameValuePair>) new BasicNameValuePair("TargetGenomeValue", TargetGenomeValue.trim()));
//			params.addAll((Collection<? extends NameValuePair>) new BasicNameValuePair("PAMValue", PAMValue.trim()));
//			params.addAll((Collection<? extends NameValuePair>) new BasicNameValuePair("IDValue", IDValue));
//			params.addAll((Collection<? extends NameValuePair>) new BasicNameValuePair("PositionValue", PositionValue));
//			Value=params.toString();
//	        HashMap<String, String> map = new HashMap<String, String>();
//	        map.put("TargetGenomeValue", TargetGenomeValue);
//	        map.put("PAMValue", PAMValue);
//	        map.put("IDValue", IDValue);
//	        map.put("PositionValue", PositionValue);
//	        Value=map.toString();
	        try {
				SendGet();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    //SendPost(GET_URL,Value);
	  }
    	public  void SendGet() throws IOException{
    		
    		//String getURL = GET_URL + "specie=" + TargetGenomeValue+"&pam="+PAMValue+"&location="+IDValue+"&gene="+PositionValue+"&rfc="+111111;
    		String getURL="http://immunet.cn/iGEM2014/getMain.php?key=123&pam=NGG&specie=Saccharomycetes&location=1:200..2797&rfc=110010&listcount=40";
    		System.out.println(getURL);
    		URL getUrl = new URL(getURL);
    		 HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
    		 connection.connect();
    		 BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
    		    while ((lines = reader.readLine()) != null){
    	        	lines = new String(lines.getBytes(), "utf-8");
    	        	value.append(lines);
//    	            System.out.println(lines);
//    	            System.out.println(value);
    	        }
//    		    new Analyze(value);
    	        reader.close();
    	        connection.disconnect();
    	}
		public  boolean SendPost(String sUrl,String Value){
			
			try{
				if(sUrl==null||sUrl.trim().equals("")){
					System.out.print("URLµÿ÷∑Œﬁ–ß");
				}
				URL url=new URL(sUrl);
				HttpURLConnection link=(HttpURLConnection) url.openConnection();
				link.setRequestMethod("POST");
				link.setDoOutput(true);
				link.setDoInput(true);
				OutputStream Data=link.getOutputStream();
				OutputStreamWriter inputData=new OutputStreamWriter(Data,"utf-8");
				inputData.write("location=336..2798&gene=thrA&specie=E.coli&pam=NGG&rfc=111111");
				System.out.println(inputData);
				inputData.flush();
				inputData.close();
				Data.close();
				InputStream in=link.getInputStream();
				String kk=in.toString();
				System.out.println(kk);
				in.close();
				link.disconnect();
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
}