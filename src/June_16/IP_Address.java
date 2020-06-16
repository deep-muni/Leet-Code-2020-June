/*
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation,
which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue
simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid.
For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".

Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".

Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.
 */

package June_16;

public class IP_Address {
    public static String validIPAddress(String IP) {
        String result;

        if (IP.contains(".")) {
            String[] arr = IP.split("\\.");

            if (arr.length == 4 && IP.charAt(IP.length()-1) != '.') {
                int count = 0;
                for (String number : arr) {
                    if(number.matches("[0-9]+") && number.length() > 0 && number.length() <= 3){
                        if (Integer.parseInt(number) >= 0 && Integer.parseInt(number) <= 255 && number.charAt(0) != '0') {
                            count++;
                        }else if(number.equals("0")){
                            count++;
                        }
                    }
                }
                result = count == 4 ? "IPv4" : "Neither";
            } else {
                result = "Neither";
            }
        } else if (IP.contains(":")) {
            String[] arr = IP.split(":");

            if (arr.length == 8 && IP.charAt(IP.length()-1) != ':') {
                int count = 0;
                for (String number : arr) {
                    if (number.length() > 0 && number.length() <= 4 && number.matches("[a-fA-F0-9]+")) {
                        count++;
                    }
                }
                result = count == 8 ? "IPv6" : "Neither";
            }else {
                result = "Neither";
            }
        } else {
            result = "Neither";
        }
        return result;
    }

    public static void main(String[] args) {

        String IP = "192.0.0.1";
        System.out.println(validIPAddress(IP));

    }
}
