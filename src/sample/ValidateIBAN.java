package sample;

public class ValidateIBAN {


    private static String IBAN = "";
    public static boolean checkIBAN(String iban) {
        IBAN=iban;
        if (IBAN.length() != 20) return false;
        if( calculateIBANCheckDigits() == Integer.parseInt(getIBANCheckDigits())) return true;
        return false;
    }

    private static Integer calculateIBANCheckDigits() // we do the check digits algorithm to see what IBAN check digits we should have
    {   Integer ValidateCheckDigits;
        String CalculateMod = IBAN.substring(IBAN.length() - 16) + getIBANCountryCode();
        ValidateCheckDigits = 98 - getMod(CalculateMod);
        return ValidateCheckDigits;

    }
    private static String getIBANCountryCode()
    {
        Integer x = Character.getNumericValue(IBAN.charAt(0));
        Integer y = Character.getNumericValue(IBAN.charAt(1));
        return x.toString() + y.toString() + "00";
    }
    private static String getIBANCheckDigits()
    {
        return String.valueOf(IBAN.charAt(2)) + IBAN.charAt(3);
    }

    private static Integer getMod(String num) {
        int res = 0;
        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int) num.charAt(i) - '0') % 97;
        return res;
    }

}
