package utils;

import java.util.Scanner;

public class RegexData {
    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";
    public static final String REGEX_BIRTHDAY = "((0[13578]|1[02])[\\/.]31[\\/.](18|19|20)[0-9]{2})|((01|0[3-9]|1[1-2])[\\/.](29|30)[\\/.](18|19|20)[0-9]{2})|((0[1-9]|1[0-2])[\\/.](0[1-9]|1[0-9]|2[0-8])[\\/.](18|19|20)[0-9]{2})|((02)[\\/.]29[\\/.](((18|19|20)(04|08|[2468][048]|[13579][26]))|2000))";
    public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";

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
        return RegexData.regexStr(sc.nextLine(),REGEX_ID_VILLA,"Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng: SVXX-YYYY!!!");
    }

    public String inputIdHouse(String regex){
        System.out.println("Nhập id, mã House:");
        return RegexData.regexStr(sc.nextLine(),REGEX_ID_HOUSE,"Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng: SVHO-YYYY!!!");
    }

    public String inputIdRoom(String regex){
        System.out.println("Nhập id, mã Room:");
        return RegexData.regexStr(sc.nextLine(),REGEX_ID_ROOM,"Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng: SVRO-YYYY!!!");
    }

    public String inputNameFacility(){
        System.out.println("Nhập tên dịch vụ:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, tên dịch vụ phải viết hoa ký tự đầu!!!");
    }

    public String inputArea(){
        System.out.println("Nhập diện tích:");
        return RegexData.regexStr(sc.nextLine(),REGEX_AREA,"Bạn đã nhập sai định dạng, diện tích sử dụng phải lớn hơn 30m2!!!");
    }

    public String inputPrice(){
        System.out.println("Nhập giá phòng:");
        return RegexData.regexStr(sc.nextLine(),REGEX_INT,"Bạn đã nhập sai định dạng, giá tiền phải là số dương!!!");
    }

    public String inputAmount(){
        System.out.println("Số lượng người:");
        return RegexData.regexStr(sc.nextLine(),REGEX_AMOUNT,"Bạn đã nhập sai định dạng, số người phải từ 1 - 19!!!");
    }

    public String inputStyle(){
        System.out.println("Nhập kiểu dịch vụ:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, kiểu phòng phải bắt đầu bằng ký tự viết hoa!!!");
    }

    public String inputStandard(){
        System.out.println("Nhập tiêu chuẩn dịch vụ:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, tiêu chuẩn phòng phải bắt đầu bằng ký tự viết hoa!!!");
    }

    public String inputFOC(){
        System.out.println("Nhập dịch vụ miễn phí:");
        return RegexData.regexStr(sc.nextLine(),REGEX_STR,"Bạn đã nhập sai định dạng, dịch vụ miễn phí phải bắt đầu bằng ký tự viết hoa!!!");
    }

    public String inputFloor(){
        System.out.println("Nhập số tầng:");
        return RegexData.regexStr(sc.nextLine(),REGEX_INT,"Bạn đã nhập sai định dạng, số tầng phải là số nguyên dương!!!");
    }

    public String inputDateOfBirth(){
        System.out.println("Nhập ngày sinh:");
        return RegexData.regexStr(sc.nextLine(),REGEX_BIRTHDAY,"Bạn đã nhập sai định dạng, ngày sinh phải có dạng dd/MM/yyyy!!!");
    }

    public String inputEmail(){
        System.out.println("Nhập email:");
        return RegexData.regexStr(sc.nextLine(),REGEX_EMAIL,"Bạn đã nhập sai định dạng, email phải có dạng abc@gmail.com !!!");
    }

    public int inputIntNumber(){
        int num = 0;
        while (true){
            try {
                num = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return num;
    }

    public double inputDouNumber(){
        int num = 0;
        while (true){
            try {
                num = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return num;
    }

    public boolean comfirmGender(int choose){
        boolean comfirm = false;
        if (choose == 1){
            comfirm = true;
        }else {
            comfirm = false;
        }
        return comfirm;
    }
}
