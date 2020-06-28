/*
Reconstruct Itinerary
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/
package June_28;

import java.util.*;

public class Itinerary {

    // Method 1
    public static List<String> findItinerary(List<List<String>> tickets) {

        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<String> check = new ArrayList<>();
        int size = tickets.size();
        result.add("JFK");

        for (List<String> tic : tickets) {
            check.add(tic.get(0));
        }

        for(int i = 0; i < size; i++){
            for (List<String> ticket : tickets) {
                if (result.get(i).equals(ticket.get(0))) {
                    temp.add(ticket.get(1));
                }
            }
            if(temp.size() == 1){
                result.add(temp.get(0));
            }else if(check.contains(temp.get(0)) && check.contains(temp.get(1))){
                Collections.sort(temp);
                result.add(temp.get(0));
            }else if(check.contains(temp.get(0))){
                result.add(temp.get(0));
            }else if(check.contains(temp.get(1))){
                result.add(temp.get(1));
            }
            tickets.remove(Arrays.asList(result.get(i), result.get(i + 1)));
            temp.clear();
        }

        return result;
    }

    public static Map<String, PriorityQueue<String>> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();

    // Method 2
    public static List<String> findItinerary_1(List<List<String>> tickets) {

        for(List<String> tic : tickets){
            if(!map.containsKey(tic.get(0)))
                map.put(tic.get(0), new PriorityQueue<>());
            map.get(tic.get(0)).add(tic.get(1));
        }

        getNext("JFK");
        return list;
    }

    public static void getNext(String str){
        PriorityQueue<String> pq = map.get(str);
        while(pq != null && !pq.isEmpty()){
            getNext(pq.poll());
        }
        list.add(0, str);
    }

    public static void main(String[] args){

        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

//        tickets.add(Arrays.asList("JFK","SFO"));
//        tickets.add(Arrays.asList("JFK","ATL"));
//        tickets.add(Arrays.asList("SFO","ATL"));
//        tickets.add(Arrays.asList("ATL","JFK"));
//        tickets.add(Arrays.asList("ATL","SFO"));

//        tickets.add(Arrays.asList("JFK","KUL"));
//        tickets.add(Arrays.asList("JFK","NRT"));
//        tickets.add(Arrays.asList("NRT","JFK"));

        System.out.println(findItinerary_1(tickets));
    }
}
