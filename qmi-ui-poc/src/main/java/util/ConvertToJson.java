package util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.common.base.Stopwatch;

import model.INV_ITEM_VO;

public class ConvertToJson {
	private static final ObjectMapper mapper = new ObjectMapper();
	public String toJson(List<INV_ITEM_VO> item){
		String jsonString=null;
		try {		
			//Convert object to JSON string			
			jsonString=mapper.writeValueAsString(item);			
		} catch (JsonGenerationException e) {
			// TODO:[colin.lee], Auto-generated try catch stub
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO:[colin.lee], Auto-generated try catch stub
			e.printStackTrace();
		} catch (IOException e) {
			// TODO:[colin.lee], Auto-generated try catch stub
			e.printStackTrace();
		}
		
		return jsonString;
		
	}
}
