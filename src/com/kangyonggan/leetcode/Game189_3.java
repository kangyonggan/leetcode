package com.kangyonggan.leetcode;

import java.util.*;

/**
 * 1452. 收藏清单
 *
 * @author kyg
 */
public class Game189_3 {

    public static void main(String[] args) {
        List<List<String>> favoriteCompanies = new ArrayList<>();
        List<String> companiesA = new ArrayList<>();
        companiesA.add("leetcode");
        companiesA.add("google");
        companiesA.add("facebook");
        favoriteCompanies.add(companiesA);

        List<String> companiesB = new ArrayList<>();
        companiesB.add("google");
        companiesB.add("microsoft");
        favoriteCompanies.add(companiesB);

        List<String> companiesC = new ArrayList<>();
        companiesC.add("google");
        companiesC.add("facebook");
        favoriteCompanies.add(companiesC);

        List<String> companiesD = new ArrayList<>();
        companiesD.add("google");
        favoriteCompanies.add(companiesD);

        List<String> companiesE = new ArrayList<>();
        companiesE.add("amazon");
        favoriteCompanies.add(companiesE);

        List<Integer> list = new Game189_3().peopleIndexes(favoriteCompanies);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<List<String>, Integer> indexMap = new HashMap<>(favoriteCompanies.size());
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            indexMap.put(favoriteCompanies.get(i), i);
        }

        Collections.sort(favoriteCompanies, Comparator.comparingInt(List::size));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            if (check(favoriteCompanies, i)) {
                list.add(indexMap.get(favoriteCompanies.get(i)));
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        return list;
    }

    private boolean check(List<List<String>> favoriteCompanies, int index) {
        List<String> list = favoriteCompanies.get(index);
        int startIndex = 0;
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            if (list.size() == favoriteCompanies.get(i).size()) {
                startIndex = i;
                break;
            }
        }
        for (int i = startIndex; i < favoriteCompanies.size(); i++) {
            if (i == index) {
                continue;
            }
            if (favoriteCompanies.get(i).containsAll(list)) {
                return false;
            }
        }

        return true;
    }

}
