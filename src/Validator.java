public class Validator  {
public static String stringChecker(String str) throws IncorrectArgumentException {
    if (str.equals("")){
        throw new IncorrectArgumentException("Нельзя вводить пустую строку");
    } else return str;
}
}
