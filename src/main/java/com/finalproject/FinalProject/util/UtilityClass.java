package com.finalproject.FinalProject.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class UtilityClass {

	// calculate distance in miles between lat/longs.
	public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
		double earthRadius = 3958.75;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double a = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;

		return dist;
	}
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1; // Special fix to preserve items with equal values
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        
        return sortedEntries;
    }
	
	public static SortedSet<java.util.Map.Entry<String, Double>> precinctsNearAddress(double userLat, double userLong) {


		Map<String, Double> nonSortedMap = new HashMap<String, Double>();
		nonSortedMap.put("downtownservice", distFrom(userLat, userLong, 42.329384101120404, -83.03652787242663));
		nonSortedMap.put("2nd", distFrom(userLat, userLong, 42.38555613448372, -83.18001577275903 ));
		nonSortedMap.put("3rd", distFrom(userLat, userLong, 42.367777960026565, -83.08132685564567));
		nonSortedMap.put("4th", distFrom(userLat, userLong, 42.311536886670844, -83.09305885325628));
		nonSortedMap.put("5th", distFrom(userLat, userLong, 42.3817806012646, -82.96601910577608));
		nonSortedMap.put("6th", distFrom(userLat, userLong, 42.3817806012646, -82.96601910577608));
		nonSortedMap.put("7th", distFrom(userLat, userLong, 42.35528724628933, -83.03488094062637));
		nonSortedMap.put("8th", distFrom(userLat, userLong, 42.41426001040211, -83.25477357070348));
		nonSortedMap.put("9th", distFrom(userLat, userLong, 42.40946478307603, -82.99510655467587));
		nonSortedMap.put("10th", distFrom(userLat, userLong, 42.37656481638395, -83.13855852239692));
		nonSortedMap.put("11th", distFrom(userLat, userLong, 42.42555354379842, -83.05131414200324));
		nonSortedMap.put("12th", distFrom(userLat, userLong, 42.43150785858086, -83.11865185570083));
		
		return entriesSortedByValues(nonSortedMap);
	}
}
