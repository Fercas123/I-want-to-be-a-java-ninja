/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int maxNumber = 0;
        int minNumber = Integer.parseInt(args[1]);
        int sumOfNumbers = 0;
        for (int i = 1; i < args.length; i++) {
            maxNumber = Math.max(maxNumber, Integer.parseInt(args[i]));
            minNumber = Math.min(minNumber, Integer.parseInt(args[i]));
            sumOfNumbers += Integer.parseInt(args[i]);
        }
        switch (operator) {
            case "MAX":
                System.out.println(maxNumber);
                break;
            case "MIN":
                System.out.println(minNumber);
                break;
            case "SUM":
                System.out.println(sumOfNumbers);
                break;
            default:
        }
    }
}