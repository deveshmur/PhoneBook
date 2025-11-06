package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */

public class PhoneBook {
    public static void main (String[] args) {}

        private final Map<String, List<String>> phonebook;


        public PhoneBook(Map<String, List<String>> map) {
            if (map == null) {
                this.phonebook = new LinkedHashMap<>();
            } 
            else {
                this.phonebook = map;
            }

        }

        public PhoneBook() {
            this(null);
        }

        public void add(String name, String phoneNumber) {
            phonebook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
        }

        public void addAll(String name, String... phoneNumbers) {
            phonebook.computeIfAbsent(name, k -> new ArrayList<>())
                    .addAll(Arrays.asList(phoneNumbers));
        }

        public void remove(String name) {
            phonebook.remove(name);
        }

        public Boolean hasEntry(String name) {
            return phonebook.containsKey(name);
        }

        public Boolean hasEntry(String name, String phoneNumber) {
            List<String> numbers = phonebook.get(name);
            return numbers != null && numbers.contains(phoneNumber);
        }

        public List<String> lookup(String name) {
            return phonebook.get(name);
        }

        public String reverseLookup(String phoneNumber) {
            for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
                if (entry.getValue().contains(phoneNumber)) {
                    return entry.getKey();
                }
            }
            return null;
        }

        public List<String> getAllContactNames() {
            return new ArrayList<>(phonebook.keySet());
        }

        public Map<String, List<String>> getMap() {
            return phonebook;
        }
        
}
