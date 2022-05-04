package utils;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import services.libs_of_impl.FacilityServiceImpl;

import java.io.*;
import java.util.*;

public class ReadAndWrite {
    public static void writeList(String path, String line) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public static List<String[]> readList(String path)  {
        List<String[]> myList = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arrStr = line.split(",");
                myList.add(arrStr);
            }
            return myList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myList;
    }

    public static void writeFacility(Map<Facility, Integer> facilityIntegerMap , String path){
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.write("FACILITY,");
            fileWriter.append("HIRE NUMBER" + "\n");
            for(Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()){
                fileWriter.append(map.getKey().getIdFacility() + "," + map.getValue() + "\n");
            }
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readFacilityCsv(String path) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        Facility facility = null;
        List<House> houseList = FacilityServiceImpl.getHouseList();
        List<Villa> villaList = FacilityServiceImpl.getVillaList();
        List<Room> roomList = FacilityServiceImpl.getRoomList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                for (House house : houseList) {
                    if (arr[0].equals(house.getIdFacility())) {
                        facility = house;
                    }
                }
                for (Villa villa : villaList) {
                    if (arr[0].equals(villa.getIdFacility())) {
                        facility = villa;
                    }
                }
                for (Room room : roomList) {
                    if (arr[0].equals(room.getIdFacility())) {
                        facility = room;
                    }
                }
                facilityIntegerMap.put(facility, Integer.parseInt(arr[1]));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facilityIntegerMap;
    }

}
