package services.libs_of_impl;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import services.libs_of_interface.FacilityService;
import utils.regex.RegexData;

import java.util.*;

public class FacilityServiceImpl extends ServiceAbstract implements FacilityService {
    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";

    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static List<Facility> listFacilityMaintain = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service: " + element.getKey() + " Hire number: " + element.getValue());
        }
    }

    @Override
    public void displayMaintain() {
        for (Facility facility : listFacilityMaintain) {
            System.out.println(facility);
        }
    }

    public void addFacilityMaintain(){
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            if (element.getValue() >= 5){
                listFacilityMaintain.add(element.getKey());
            }
        }
    }

    @Override
    public void addNewVilla() {
        String id = inputId(REGEX_ID_VILLA);
        String name = inputName();
        double areaUse = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputPrice());
        int maxPeople = Integer.parseInt(inputAmount());
        String style = inputStyle();
        String standard = inputStandard();
        double areaPool = Double.parseDouble(inputArea());
        int floor = Integer.parseInt(inputFloor());

        Villa villa = new Villa(id, name, areaUse, price, maxPeople, style, standard, areaPool, floor);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Thêm mới thành công");

    }

    @Override
    public void addNewHouse() {
        String id = inputId(REGEX_ID_HOUSE);
        String name = inputName();
        double areaUse = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputPrice());
        int maxPeople = Integer.parseInt(inputAmount());
        String style = inputStyle();
        String standard = inputStandard();
        int floor = Integer.parseInt(inputFloor());

        House house = new House(id, name, areaUse, price, maxPeople, style, standard, floor);
        facilityIntegerMap.put(house, 0);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void addNewRoom() {
        String id = inputId(REGEX_ID_ROOM);
        String name = inputName();
        double areaUse = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputPrice());
        int maxPeople = Integer.parseInt(inputAmount());
        String style = inputStyle();
        String foc = inputFOC();

        Room room = new Room(id, name, areaUse, price, maxPeople, style, foc);
        facilityIntegerMap.put(room, 0);
        System.out.println("Thêm mới thành công");
    }

    private String inputId(String regex){
        System.out.println("Nhập id, mã dịch vụ:");
        return RegexData.regexStr(sc.nextLine(),regex,"Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng: SVXX-YYYY!!!");
    }

    private String inputName(){
        System.out.println("Nhập tên dịch vụ:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, tên dịch vụ phải viết hoa ký tự đầu!!!");
    }

    private String inputArea(){
        System.out.println("Nhập diện tích:");
        return RegexData.regexStr(sc.nextLine(),REGEX_AREA,"Bạn đã nhập sai định dạng, diện tích sử dụng phải lớn hơn 30m2!!!");
    }

    private String inputPrice(){
        System.out.println("Nhập giá phòng:");
        return RegexData.regexStr(sc.nextLine(),REGEX_INT,"Bạn đã nhập sai định dạng, giá tiền phải là số dương!!!");
    }

    private String inputAmount(){
        System.out.println("Số lượng người:");
        return RegexData.regexStr(sc.nextLine(),REGEX_AMOUNT,"Bạn đã nhập sai định dạng, số người phải từ 1 - 19!!!");
    }

    private String inputStyle(){
        System.out.println("Nhập kiểu dịch vụ:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, kiểu phòng phải bắt đầu bằng ký tự viết hoa!!!");
    }

    private String inputStandard(){
        System.out.println("Nhập tiêu chuẩn dịch vụ:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, tiêu chuẩn phòng phải bắt đầu bằng ký tự viết hoa!!!");
    }

    private String inputFOC(){
        System.out.println("Nhập dịch vụ miễn phí:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, dịch vụ miễn phí phải bắt đầu bằng ký tự viết hoa!!!");
    }

    private String inputFloor(){
        System.out.println("Nhập số tầng:");
        return RegexData.regexStr(sc.nextLine(),REGEX_INT,"Bạn đã nhập sai định dạng, số tầng phải là số nguyên dương!!!");
    }
}
