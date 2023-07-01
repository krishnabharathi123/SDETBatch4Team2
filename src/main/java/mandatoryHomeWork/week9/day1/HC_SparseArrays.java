package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class HC_SparseArrays {

	@Test
	public void example1() {
		List<String> stringList=Arrays.asList("aba","baba","aba","xzxb");
        List<String> queries=Arrays.asList("aba","xzxb","ab");
		matchingStrings(stringList,queries);
	}

    @Test
    public void example2() {
        List<String> stringList=Arrays.asList("def","de","fgh");
        List<String> queries=Arrays.asList("de","lmn","fgh");
        matchingStrings(stringList,queries);
    }

    @Test
    public void example3() {
        List<String> stringList=Arrays.asList("abcde","sdaklfj","asdjf","na","basdn","sdaklfj","sdaklfj","na","asdjf","na","basdn","sdaklfj","asdjf");
        List<String> queries=Arrays.asList("abcde","sdaklfj","asdjf","na","basdn");
        matchingStrings(stringList,queries);
    }
	
	
	public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        
            HashMap<String,Integer> map=new HashMap<String,Integer>();
            List<Integer> ls=new ArrayList<Integer>();
            
            for(int i=0;i<stringList.size();i++){
                map.put(stringList.get(i),map.getOrDefault(stringList.get(i), 0)+1);
            }
            for(int j=0;j<queries.size();j++){
                if(map.containsKey(queries.get(j))){
                    ls.add(map.get(queries.get(j)));
                }
                else ls.add(0);
            }
        return ls;
    }
}
