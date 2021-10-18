package fr.redxil.api.spigot.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtils {

    static ArrayUtils instance = new ArrayUtils();

    private ArrayUtils() {
    }

    public static ArrayUtils getInstance() {
        return instance;
    }

    public boolean containsIgnoreCase(ArrayList<String> set, String str) {
        str = str.toLowerCase();
        for (String text : set) {
            text = text.toLowerCase();
            if (text.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the contains ignore case.
     *
     * @param set the set
     * @param str the str
     * @return true, if successful
     */
    public boolean containsIgnoreCase(Set<String> set, String str) {
        str = str.toLowerCase();
        for (String text : set) {
            text = text.toLowerCase();
            if (text.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert array.
     *
     * @param list the list
     * @return the string[]
     */
    public String[] convert(ArrayList<String> list) {
        if (list == null) {
            return null;
        }
        String[] string = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            string[i] = list.get(i);
        }
        return string;

    }

    /**
     * Convert.
     *
     * @param set1 the set
     * @return the array list
     */
    public ArrayList<String> convert(Set<String> set1) {
        Set<String> set = new HashSet<String>(set1);
        return new ArrayList<>(set);
    }

    /**
     * Convert array.
     *
     * @param list the list
     * @return the array list
     */
    public ArrayList<String> convert(String[] list) {
        if (list == null) {
            return null;
        }
        return new ArrayList<>(Arrays.asList(list));
    }

    public BaseComponent[] convertBaseComponent(ArrayList<BaseComponent> list) {
        if (list == null) {
            return null;
        }
        BaseComponent[] string = new BaseComponent[list.size()];
        for (int i = 0; i < list.size(); i++) {
            string[i] = list.get(i);
        }
        return string;
    }

    public ArrayList<BaseComponent> convertBaseComponent(BaseComponent[] list) {
        if (list == null) {
            return null;
        }
        return (ArrayList<BaseComponent>) new ArrayList(Arrays.asList(list));
    }

    /**
     * Sets the to array.
     *
     * @param set the set
     * @return the string[]
     */
    public String[] convertSet(Set<String> set) {
        String[] array = new String[set.size()];
        int i = 0;
        for (String item : set) {
            array[i] = item;
            i++;
        }
        return array;
    }


    public HashMap<String, String> fromString(String str) {
        HashMap<String, String> map = new HashMap<String, String>();
        if (!str.equals("")) {
            for (String entry : str.split("%entry%")) {
                String[] values = entry.split("%pair%");
                if (values.length > 1) {
                    String key = values[0];
                    String value = values[1];
                    map.put(key, value);
                }
            }
        }
        return map;
    }

    public String makeString(HashMap<String, String> placeholders) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        if (placeholders != null && !placeholders.isEmpty()) {
            for (Entry<String, String> entry : placeholders.entrySet()) {
                str.append(entry.getKey()).append("%pair%").append(entry.getValue());
                count++;
                if (count != placeholders.size()) {
                    str.append("%entry%");
                }
            }
        }
        return str.toString();
    }

    /**
     * Make string.
     *
     * @param startIndex the start index
     * @param strs       the strs
     * @return the string
     */
    public String makeString(int startIndex, String[] strs) {
        StringBuilder str = new StringBuilder();
        for (int i = startIndex; i < strs.length; i++) {
            if (i == startIndex) {
                str.append(strs[i]);
            } else {
                str.append(" ").append(strs[i]);
            }

        }
        return str.toString();
    }

    /**
     * Make string list.
     *
     * @param list the list
     * @return the string
     */
    public String makeStringList(ArrayList<String> list) {
        if (list == null) {
            return "";
        }
        StringBuilder string = new StringBuilder("");
        if (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    string.append(list.get(i));
                } else {
                    string.append(", ").append(list.get(i));
                }
            }
        } else if (list.size() == 1) {
            string = new StringBuilder(list.get(0));
        }
        return string.toString();
    }

    public String pickRandom(ArrayList<String> list) {
        if (list != null) {
            return list.get(ThreadLocalRandom.current().nextInt(list.size()));
        }
        return "";
    }

    public ArrayList<String> removeDuplicates(ArrayList<String> list) {
        Set<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    /**
     * Replace.
     *
     * @param list        the list
     * @param toReplace   the to replace
     * @param replaceWith the replace with
     * @return the list
     */
    public List<String> replace(List<String> list, String toReplace, String replaceWith) {
        if (list == null) {
            return null;
        }
        if (replaceWith == null || toReplace == null) {
            return list;
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replace(toReplace, replaceWith));
        }
        return list;
    }


    public ArrayList<String> sort(ArrayList<String> list) {
        list.sort(String.CASE_INSENSITIVE_ORDER);
        return list;
    }


    public HashMap<String, Integer> sortByValuesStr(HashMap<String, Integer> unsortMap, final boolean order) {

        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        list.sort((o1, o2) -> {
            if (order) {
                return o1.getValue().compareTo(o2.getValue());
            } else {
                return o2.getValue().compareTo(o1.getValue());

            }
        });

        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public LinkedHashMap<String, ItemStack> sortByValuesStrItem(HashMap<String, ItemStack> unsortMap) {

        ArrayList<String> sortedKeys = sort(new ArrayList<>(unsortMap.keySet()));

        LinkedHashMap<String, ItemStack> sortedMap = new LinkedHashMap<>();
        for (String key : sortedKeys) {
            sortedMap.put(key, unsortMap.get(key));
        }

        return sortedMap;
    }
}
