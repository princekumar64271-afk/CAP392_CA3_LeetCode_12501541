class Solution {

    private final String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int group = 0;

        while (num > 0) {

            int part = num % 1000;

            if (part != 0) {
                result = helper(part) + thousands[group]
                       + (result.isEmpty() ? "" : " " + result);
            }

            num = num / 1000;
            group++;
        }

        return result.trim();
    }

    private String helper(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return below20[num] + " ";
        }

        if (num < 100) {
            return tens[num / 10] + " "
                   + helper(num % 10);
        }

        return below20[num / 100] + " Hundred "
               + helper(num % 100);
    }
}
