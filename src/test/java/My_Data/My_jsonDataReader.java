package My_Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class My_jsonDataReader {

	public List<HashMap<String,String>> jsonDataReader(String filepath) throws IOException {
		
		String jsonfile=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		ObjectMapper map=new ObjectMapper();
		List<HashMap<String,String>>data=map.readValue(jsonfile, new TypeReference <List<HashMap<String,String>>>(){});
		return data;
	}

}
