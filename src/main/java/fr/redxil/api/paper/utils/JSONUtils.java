package fr.redxil.api.paper.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class JSONUtils {

    public static class getHashMapManager {

        public static HashMap<?, ?> fromJSON(String req) {
            if (req == null) {
                return new HashMap<>();
            }
            Type stringStringMap = new TypeToken<HashMap<?, ?>>() {
            }.getType();
            HashMap<?, ?> values = new Gson().fromJson(req, stringStringMap);
            return values;
        }

        public static String toJSON(HashMap<?, ?> list) {
            if (list == null) {
                list = new HashMap<>();
            }
            return new Gson().toJson(list);
        }

        public static boolean contains(String req, Object key) {
            if (req == null) {
                return false;
            }
            Type stringStringMap = new TypeToken<HashMap<?, ?>>() {
            }.getType();
            HashMap<?, ?> values = new Gson().fromJson(req, stringStringMap);
            return values.containsKey(key);
        }

        public static String get(String req, Object key) {
            if (req == null) {
                return null;
            }
            Type stringStringMap = new TypeToken<HashMap<Object, String>>() {
            }.getType();
            HashMap<Object, String> values = new Gson().fromJson(req, stringStringMap);
            if (!values.containsKey(key)) {
                return null;
            }
            return values.get(key);
        }

        public static String put(String req, Object key, String value) {
            if (req != null) {
                Type stringStringMap = new TypeToken<HashMap<Object, String>>() {
                }.getType();
                HashMap<Object, String> values = new Gson().fromJson(req, stringStringMap);
                if (value == null) {
                    values.remove(key);
                } else {
                    values.put(key, value);
                }
                return new Gson().toJson(values);
            } else {
                HashMap<Object, String> values = new HashMap<>();
                if (value == null) {
                    values.remove(key);
                } else {
                    values.put(key, value);
                }
                return new Gson().toJson(values);
            }
        }

    }

    public static class getListManager {

        public static ArrayList<Integer> fromIntJSON(String json) {
            ArrayList<Integer> result = new ArrayList<>();
            if (json != null) {
                Type stringStringMap = new TypeToken<ArrayList<Integer>>() {
                }.getType();
                result = new Gson().fromJson(json, stringStringMap);
            }
            return result;
        }

        public static ArrayList<?> fromJSON(String req) {
            if (req == null) {
                return new ArrayList<>();
            }
            Type stringStringMap = new TypeToken<ArrayList<?>>() {
            }.getType();
            ArrayList<?> values = new Gson().fromJson(req, stringStringMap);
            return values;
        }

        public static String toJSON(ArrayList<?> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            return new Gson().toJson(list);
        }

    }

    public static class getLocationManager {

        public static Location fromJSON(String req) {
            if (req == null) {
                return null;
            }
            Type stringStringMap = new TypeToken<ArrayList<String>>() {
            }.getType();
            ArrayList<String> values = new Gson().fromJson(req, stringStringMap);
            return new Location(Bukkit.getWorld(values.get(0)), Double.parseDouble(values.get(1)), Double.parseDouble(values.get(2)), Double.parseDouble(values.get(3)), Float.parseFloat(values.get(4)), Float.parseFloat(values.get(5)));
        }

        public static Location fromList(ArrayList<String> values) {
            return fromList(values, null);
        }

        public static Location fromList(ArrayList<String> values, World forceWorld) {
            if (values == null) {
                return null;
            }
            return new Location(forceWorld != null ? forceWorld : Bukkit.getWorld(values.get(0)), Double.parseDouble(values.get(1)), Double.parseDouble(values.get(2)), Double.parseDouble(values.get(3)), Float.parseFloat(values.get(4)), Float.parseFloat(values.get(5)));
        }

        public static ArrayList<String> toList(Location lo) {
            if (lo == null) {
                return null;
            }
            ArrayList<String> values = new ArrayList<>();
            values.add(lo.getWorld().getName());
            values.add(lo.getX() + "");
            values.add(lo.getY() + "");
            values.add(lo.getZ() + "");
            values.add(lo.getYaw() + "");
            values.add(lo.getPitch() + "");
            return values;
        }

    }

}
