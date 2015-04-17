import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * find top k most frequent elements
 * 
 * @author cassie9082
 * 
 */
public class FindtopKElements {
	public List<String> findStringTopK(List<String> inputData, int k) {
		List<String> result = new ArrayList<String>();
		Map<String, Integer> map = mapInput(inputData);
		List<Map.Entry<String, Integer>> sortedEntry = sortEachEntryInMapByValue(map);
		//check top size
		if(k > sortedEntry.size()){
			k = sortedEntry.size();
		}
		//get top
		for(int i = sortedEntry.size() - k; i < sortedEntry.size(); i++){
			result.add(sortedEntry.get(i).getKey());
		}
		return result;
	}

	public Map<String, Integer> mapInput(List<String> inputData) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String t : inputData) {
			if (map.containsKey(t)) {
				int count = map.get(t);
				map.put(t, ++count);
			} else {
				map.put(t, 1);
			}
		}
		return map;
	}
	
	public List<Map.Entry<String, Integer>> sortEachEntryInMapByValue(Map<String, Integer> map){
		List<Map.Entry<String, Integer>> sortedEntry = new ArrayList<Map.Entry<String, Integer>>();
		sortedEntry.addAll(map.entrySet());
		Collections.sort(sortedEntry, new Comparator(){
			public int compare(Object o1, Object o2){
				return((Comparable)((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
			}
		});
		return sortedEntry;
	}
}
