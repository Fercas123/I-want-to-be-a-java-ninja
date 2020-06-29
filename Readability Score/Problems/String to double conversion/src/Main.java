class Converter {

    public static double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            return 0;
        }
    }
}