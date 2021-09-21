import java.util.*;

class Radio {
	Set<String> statesNeeded;
	Map<String, Set<String>> stations;
	Set<String> finalStations;

	Radio() {
		statesNeeded = new HashSet<String>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

		stations = new HashMap<String, Set<String>>();

		stations.put("kone", new HashSet(Arrays.asList("id", "nv", "ut")));
		stations.put("ktwo", new HashSet(Arrays.asList("wa", "id", "mt")));
		stations.put("kthree", new HashSet(Arrays.asList("or", "nv", "ca")));
		stations.put("kfour", new HashSet(Arrays.asList("nv", "ut")));
		stations.put("kfive", new HashSet(Arrays.asList("ca", "az")));

		finalStations = new HashSet<String>();
	}

	void go() {
		while (!statesNeeded.isEmpty()) {
			String bestStation = null;
			Set<String> statesCovered = new HashSet<String>();

			for (String station : stations.keySet()) {
				Set<String> usefulStates = new HashSet<String>(statesNeeded);
				if (!finalStations.contains(station)) {
					Set<String> allStatesCoveredByThisStation = stations.get(station);
					usefulStates.retainAll(allStatesCoveredByThisStation);
					if (usefulStates.size() > statesCovered.size()) {
						statesCovered = usefulStates;
						bestStation = station;
					}
				}
			}
			statesNeeded.removeAll(statesCovered);
			finalStations.add(bestStation);
		}
	}

	public static void main(String[] args) {
		Radio radio = new Radio();
		radio.go();
		System.out.println(radio.finalStations);
	}
}
