public class Main {

    public static void main(String[] args) {
        /*
         * You can use this for example instaed of an ArrayList<StringPair>, but this is
         * generic, extendable and in all more handy.
         */

        PairList<String, String> pairList = new PairList<String, String>();
        pairList.add("Key", "Value");
        pairList.add("1", "2");
        pairList.add("first", "scound");

        System.out.println("\nAll keys and values:");
        for (Pair<String, String> pair : pairList) {
            System.out.println("The key is:\t" + pair.key + "\tvalue is:\t" + pair.value);
        }

        System.out.println("\nAll keys:");
        for (String key : pairList.getKeys()) {
            System.out.println("This is the key: " + key);
        }

        System.out.println("\nAll values:");
        for (String value : pairList.getValues()) {
            System.out.println("This is the value: " + value);
        }

        Pair<String, String> pair = new Pair<String, String>("Key", "Value");

        System.out.println(pairList.contains(pair)); // This is false
        System.out.println(pairList.containsPairLike(pair)); // This is true

        pairList.add(pair);
        System.out.println(pairList.contains(pair)); // Now this is true

        pairList.add("EDF768", "Bill Meyer, 2456, Vet_Parking");
        pairList.add("TY5678", "Jane Miller, 8987, AgHort_Parking");
        pairList.add("GEF123", "Jill Black, 3456, Creche_Parking");
        pairList.add("ABC234", "Fred Greenside, 2345, AgHort_Parking");
        pairList.add("GH7682", "Clara Hill, 7689, AgHort_Parking");
        pairList.add("JU9807", "Jacky Blair, 7867, Vet_Parking");
        pairList.add("KLOI98", "Martha Miller, 4563, Vet_Parking");
        pairList.add("ADF645", "Cloe Freckle, 6789, Vet_Parking");
        pairList.add("DF7800", "Jacko Frizzle, 4532, Creche_Parking");
        pairList.add("WER546", "Olga Grey, 9898, Creche_Parking");
        pairList.add("HUY768", "Wilbur Matty, 8912, Creche_Parking");
        pairList.add("EDF768", "Jenny Meyer, 9987, Vet_Parking");
        pairList.add("TY5678", "Jo King, 8987, AgHort_Parking");
        pairList.add("JU9807", "Mike Green, 3212, Vet_Parking");

        System.out.println();

        for(Pair<Integer, String> currentPair : pairList.getValuesByKey("EDF768")) {
            System.out.println("This list contains at Index: " + currentPair.key + "\tthis value: " + currentPair.value);
        }

        System.out.println("\nPairList entries: " + pairList.size());
        System.out.println(pairList.containsKeyCount("Key"));
        System.out.println(pairList.mergeDuplicatedKey("Key"));

        System.out.println("PairList entries: " + pairList.size());
        System.out.println(pairList.containsKeyCount("Key"));
   }
}
