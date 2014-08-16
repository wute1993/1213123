package Model;


import java.io.FileReader;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Jiemian.*;
public class Analyze
	{
	static String varlueStr;
	static StringBuffer value=new StringBuffer();
	static String[][][] dataofftarget;
	static String[][] datakey;
	static int offtargetNum=40;
	static int jsonLengthson;
	public Analyze(StringBuffer value){
		this.value=value;
		varlueStr=value.toString();
		try {
			ParseJson(varlueStr);
		} catch (JSONException | ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		new result(datakey,dataofftarget);
		new result();
	}
	public static void main(String[] args) throws Exception
	{
		
		FileReader wj = new FileReader("D:/用户目录/Desktop/txt/result.out");
		int aa;
		StringBuffer value=new StringBuffer();
		aa = wj.read();  
		while (aa!=(-1)) 
			{
			value.append((char)aa);
			aa = wj.read();
			}
			varlueStr=value.toString();
			wj.close();
			ParseJson(varlueStr);
			new result(datakey,dataofftarget);
			new result();
		}
	   public static void ParseJson(String varlueStr) throws JSONException,
       ParseException {
		   
		   JSONObject dataJson=new JSONObject(varlueStr);
		   JSONArray result= dataJson.getJSONArray("result");
		   int jsonLength=result.length();
	       datakey=new String[jsonLength][offtargetNum];
	       dataofftarget=new String[jsonLength][offtargetNum][6];
	       for(int i=0;i<jsonLength;i++){
	       		String offtarget=result.getJSONObject(i).getString("offtarget");
	       		JSONArray dataJsonOfftarget=new JSONArray(offtarget);
	       		System.out.print(dataJsonOfftarget);
	       		jsonLengthson=dataJsonOfftarget.length();
	       		for(int j=0;j<jsonLengthson;j++){
	        		String osequence=dataJsonOfftarget.getJSONObject(j).getString("osequence");
	        		String oscore=dataJsonOfftarget.getJSONObject(j).getString("oscore");
	        		String omms=dataJsonOfftarget.getJSONObject(j).getString("omms");
	        		String ostrand=dataJsonOfftarget.getJSONObject(j).getString("ostrand");
	        		String oposition=dataJsonOfftarget.getJSONObject(j).getString("oposition");
	        		String oregion=dataJsonOfftarget.getJSONObject(j).getString("oregion");
	        		dataofftarget[i][j][0]=osequence;
	        		
	        		dataofftarget[i][j][1]=oscore;
	        		dataofftarget[i][j][2]=omms;
	        		dataofftarget[i][j][3]=ostrand;
	        		dataofftarget[i][j][4]=oposition;
	        		dataofftarget[i][j][5]=oregion;	
	        	}//i代表key；j代表offtarget
        		String key=result.getJSONObject(i).getString("key");
        		datakey[i][0]=key;
        		String grna=result.getJSONObject(i).getString("grna");
        		datakey[i][1]=grna;
        		String position=result.getJSONObject(i).getString("position");
        		datakey[i][2]=position;
        		String total_score=result.getJSONObject(i).getString("total_score");
        		datakey[i][3]=total_score;
	        	
	        }
	     
	   }
	   
//		Map<String,List<Map<String,mapJson>>> mapJson=new HashMap<String,List<Map<String,mapJson>>>();
//		List<Map<String,mapJson>> mapjsonson=new ArrayList<Map<String,mapJson>>();
//		Map<String, mapJson> mm=new HashMap<String, mapJson>();
//	    mapJson sp1=new mapJson();
//	    mapJson sp2=new mapJson();
//	    mapJson sp3=new mapJson();
}
class mapJson{
	String key;
	String grna;
	String position;
	String totalScore;
	String offtarget;
	
}
