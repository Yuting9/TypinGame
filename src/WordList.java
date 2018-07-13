import java.io.*;
import java.util.*;

public class WordList {
	FileReader read = null;
	FileWriter write = null;
	BufferedReader in = null;
	BufferedWriter out = null;
	Map<String, String[][]> dict = null;
	
	public WordList(){
		
		try {
			read = new FileReader("WordList.dict");
			in = new BufferedReader(read);
			dict = new HashMap<String, String[][]>();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void populate(){
		dict.clear();
		try {
			String line, word;
			String[][] defandsyn = new String[2][];
			while ((line = in.readLine()) != null) {
				String[] temp = line.split("#");
				System.out.println(Arrays.deepToString(temp));
				word = temp[0];
				defandsyn[0] = new String[] {temp[1]};
				defandsyn[1] = temp[2].split("&");
				System.out.println(Arrays.deepToString(defandsyn));
				dict.put(word, defandsyn);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(String word, String[][] defandsyn) {
		dict.put(word, defandsyn);
	}
	
	public void close(){
		try {
			write = new FileWriter("WordList.dict");
			out = new BufferedWriter(write);
			for (Map.Entry<String, String[][]> entry : dict.entrySet()){
				String temp = "";
				for (String str : entry.getValue()[1]) {
					temp += str + "&";
				}
				temp = temp.substring(0, temp.length() - 1);
				out.write(entry.getKey() + "#" + entry.getValue()[0][0] + "#" + temp +"\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
