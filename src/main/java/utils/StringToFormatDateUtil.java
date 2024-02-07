package utils;

public class StringToFormatDateUtil {

    public static String format(String string) {
        return toFormatDate(string.replace("-", "."));
    }

    private static String toFormatDate(String stringDate) {
        String yyyy;
        String MM = "";
        String dd;
        String temp = stringDate;

        for (int i = stringDate.length(); i > 0; i--) {
            if (temp.substring(i - 1, i).equals(".")) {
                if (temp.equals(stringDate)) {
                    MM = stringDate.substring(i);
                    temp = stringDate.substring(0, stringDate.length() - stringDate.substring(i).length());
                } else {
                    dd = temp.substring(i - 1, temp.length());
                    temp = stringDate.substring(0, stringDate.length() - dd.length() - MM.length());
                    yyyy = temp;
                    temp = MM + dd + yyyy;
                    break;
                }
            }
        }
        return temp;
    }
}
