
package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class CollectionsTest {

    void testTryWithNewResource_Java9() throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("src/resources/secret.txt"));
        try (reader1) {
          //  long length = 0;
            String line;
            while ((line = reader1.readLine()) != null) {
              //  length += line.length();
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {

        CollectionsTest testMe = new CollectionsTest();
        try {
            testMe.testTryWithNewResource_Java9();
        } catch (IOException ex) {
        }

        System.out.println("Testing Java 9 Immutable collections!");
        
        List<Integer> immutableEmptyList = List.of();
        try {
            immutableEmptyList.add(Integer.SIZE);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add an element to immutableEmptyList.");
        }

        List<Integer> singltonList = Collections.singletonList(100);

        try {
            singltonList.add(Integer.SIZE);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add an element to singltonList.");
        }

        // Creating a simglton immutable List in JKD 9
        List<Integer> singltonListJava9 = List.of(100);

        try {
            singltonListJava9.add(Integer.SIZE);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add an element to singltonListJava9.");
        }

        try {
            singltonListJava9.remove(0);

        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot remove from  singltonListJava9.");
        }

        try {
            // Try using a null element
            List<Integer> list = List.of(1, 2, null, 3);
        } catch (NullPointerException e) {
            System.out.println("Nulls not allowed in List.of().");
        }

        try {
            // Try using a null value
            Map<Integer, String> map = Map.of(1, null);
        } catch (NullPointerException e) {
            System.out.println("Nulls not allowed in Map.of().");
        }

        try {
            // Try using duplicate keys
            Map<Integer, String> map = Map.of(1, "One", 1, "On");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
