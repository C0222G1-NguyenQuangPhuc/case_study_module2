package utils.regex;

import java.util.Scanner;

public class RegexData {
    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";

    static Scanner sc = new Scanner(System.in);

    public static String regexStr(String temp, String regex, String error){
        boolean check = true;
        do{
            if (temp.matches(regex)){
                check = false;
            }else {
                System.out.println(error);
                temp = sc.nextLine();
            }
        }while (check);
        return temp;
    }

    public String inputIdVilla(String regex){
        System.out.println("Nhập id, mã Villa:");
        return regexStr(sc.nextLine(),REGEX_ID_VILLA,"Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng: SVXX-YYYY!!!");
    }

    public String inputIdHouse(String regex){
        System.out.println("Nhập id, mã House:");
        return regexStr(sc.nextLine(),REGEX_ID_HOUSE,"Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng: SVHO-YYYY!!!");
    }

    public String inputIdRoom(String regex){
        System.out.println("Nhập id, mã Room:");
        return regexStr(sc.nextLine(),REGEX_ID_ROOM,"Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng: SVRO-YYYY!!!");
    }

    public String inputNameFacility(){
        System.out.println("Nhập tên dịch vụ:");
        return regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, tên dịch vụ phải viết hoa ký tự đầu!!!");
    }

    public String inputArea(){
        System.out.println("Nhập diện tích:");
        return regexStr(sc.nextLine(),REGEX_AREA,"Bạn đã nhập sai định dạng, diện tích sử dụng phải lớn hơn 30m2!!!");
    }

    public String inputPrice(){
        System.out.println("Nhập giá phòng:");
        return regexStr(sc.nextLine(),REGEX_INT,"Bạn đã nhập sai định dạng, giá tiền phải là số dương!!!");
    }

    public String inputAmount(){
        System.out.println("Số lượng người:");
        return regexStr(sc.nextLine(),REGEX_AMOUNT,"Bạn đã nhập sai định dạng, số người phải từ 1 - 19!!!");
    }

    public String inputStyle(){
        System.out.println("Nhập kiểu dịch vụ:");
        return regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, kiểu phòng phải bắt đầu bằng ký tự viết hoa!!!");
    }

    public String inputStandard(){
        System.out.println("Nhập tiêu chuẩn dịch vụ:");
        return regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, tiêu chuẩn phòng phải bắt đầu bằng ký tự viết hoa!!!");
    }

    public String inputFOC(){
        System.out.println("Nhập dịch vụ miễn phí:");
        return regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, dịch vụ miễn phí phải bắt đầu bằng ký tự viết hoa!!!");
    }

    public String inputFloor(){
        System.out.println("Nhập số tầng:");
        return regexStr(sc.nextLine(),REGEX_INT,"Bạn đã nhập sai định dạng, số tầng phải là số nguyên dương!!!");
    }


}
