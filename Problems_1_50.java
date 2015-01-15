import java.math.BigInteger;
import java.util.*;
import java.text.*;
import java.io.*;
import java.util.ArrayList;

public class Problems_1_50 {
    public int sumOfMultiplesOf3and5(int limit) {
        int sum = 0;
        for (int i = 3; i < limit;i++) {
            if (i%3 == 0 || i%5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public long evenFibbonacciNumbers(int limit) {
        long sum = 0;
        int t1 = 1;
        int t2 = 2;
        while (t2 < limit) {
            if (t2%2 == 0) {
                sum += t2;
            }
            int temp = t2;
            t2 = t1 + t2;
            t1 = temp;
        }
        return sum;
    }

    public long largestPrimeFactor(long number) {
        if (isPrime(number)) {
            return number;
        }
        long root = (long)Math.ceil(Math.sqrt(number));
        while (root >= 2) {
            if (isPrime(root) && number % root == 0) {
                return root;
            }
            root--;
        }
        return 1;
    }

    public int findPalindrome() {
        int largest = 0;
        for (int i = 999; i >= 100;i--) {
            for (int j = 999; j >= 100; j--) {
                int product = i * j;
                if (isPalindrome(product)) {
                    System.out.println(i + "*" + j + " = " + product);
                    if (largest < product) {
                        largest = product;
                    }
                }
            }
        }
        return largest;
    }

    private boolean isPalindrome(int number) {
        int temps = number;
        int digit = 0;
        List<Integer> digits = new ArrayList<Integer>();
        while (temps > 0) {
            digit = temps %10;
            temps /= 10;
            digits.add(digit);
        }
        int lo = 0, hi = digits.size()-1;
        while (lo < hi) {
            if (digits.get(lo) != digits.get(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    private boolean isPrime(long number) {
        if (number < 0) {
            return false;
        }
        if ((number == 2) || (number == 3)) {
            return true;
        }
        if ((number % 2 == 0) || (number % 3 == 0)) {
            return false;
        }
        
        if (number != 5 && number % 10 == 5) {
            return false;
        }
        
        double maxDivisor = Math.sqrt(number);
        for (int i = 5; i <= maxDivisor; i+=2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int smallestMultiple() {
        int[] primes = new int[] {2,3,5,7};
        int[] powers = new int[21];
        for (int i = 2; i < 21; i++) {
            if (isPrime(i)) {
                powers[i]++;
            } else {
                int number = i;
                for (int j = 0; j < primes.length; j++) {
                    int count = 0;
                    while (number % primes[j] == 0 && number > 1) {
                        number = number/primes[j];
                        count++;
                    }
                    if (count > powers[primes[j]]) {
                        powers[primes[j]] = count;
                    }
                    if (number == 1) {
                        break;
                    }
                }
            }
        }
        int multiple = 1;
        for(int i = 2; i < powers.length;i++) {
            if (powers[i] == 0) {
                continue;
            }
            multiple *= Math.pow(i, powers[i]);
        }
        return multiple;
    }

    public int sumSquareDifference(int limit) {
        int diff = 0;
        for (int i = 1; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {
                if (i == j) {
                    continue;
                }
                diff += i*j;
            }
        }
        return diff;
    }

    private boolean isPrime(long number, List<Long> primes) {
        if (number != 5 && number % 10 == 5) {
            return false;
        }
        long root = (long)Math.sqrt(number);
        for (long prime : primes) {
            if (prime > root) {
                break;
            }
            if (number % prime == 0) {
                return false;
            }
        }
        return true;
    }

    public long getNthPrime(int n) {
        List<Long> primes = new ArrayList<Long>(n);
        primes.add(2L);
        primes.add(3L);
        long prime = 5;
        while (true) {
            if (isPrime(prime,primes)) {
                primes.add(prime);
                //System.out.println("Prime:" + prime);
            }
            if (primes.size() == n) {
                break;
            }
            prime += 2;
        }
        return primes.get(primes.size()-1);
    }



    public int greatestProduct(String number) {
        int maxProduct = 0;
        for (int i = 0; i < number.length()-4;i++) {
            int product = number.charAt(i) - '0';
            product *= number.charAt(i+1) - '0';
            product *= number.charAt(i+2) - '0';
            product *= number.charAt(i+3) - '0';
            product *= number.charAt(i+4) - '0';
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public int specialPythagoreanTriplet() {
        int a = 1;
        int b = 1;
        for (; a < 1000; a++) {
            for (b = a+1; b < 1000; b++) {
                int factor = 1000*a + 1000*b - a*b;
                //System.out.println(factor);
                if (factor == 500000) {
                    int c = (int)Math.sqrt(a*a + b*b);
                    System.out.println(a + " - " + b + " - " + c);
                    return a*b*c;
                }
            }
        }
        return 0;
    }

    public long sumOfPrimes(int limit) {
        List<Long> primes = new ArrayList<Long>();
        primes.add(2L);
        primes.add(3L);
        long sum = 5L;
        long number = 5;
        while (number <= limit) {
            if (isPrime(number,primes)) {
                primes.add(number);
                sum += number;
                //System.out.println("Sum:" + sum);
            }
            number += 2;
        }
        return sum;
    }

    public int largestProductInGrid(int[][] grid) {
        int maxProduct = 0;
        for (int i = 0; i < grid.length;i++) {
            if (i+3 >= grid.length) {
                continue;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (j+3 >= grid[0].length) {
                    continue;
                }
                int rowProduct = grid[i][j]*grid[i][j+1]*grid[i][j+2]*grid[i][j+3];
                if (maxProduct < rowProduct) {
                    maxProduct = rowProduct;
                }

                int colProduct = grid[i][j]*grid[i+1][j]*grid[i+2][j]*grid[i+3][j];
                if (maxProduct < colProduct) {
                    maxProduct = colProduct;
                }
                int slashProduct = grid[i][j]*grid[i+1][j+1]*grid[i+2][j+2]*grid[i+3][j+3];
                if (maxProduct < slashProduct) {
                    maxProduct = slashProduct;
                }
                int backSlashProduct = grid[i][j+3]*grid[i+1][j+2]*grid[i+2][j+1]*grid[i+3][j];
                if (maxProduct < backSlashProduct) {
                    maxProduct = backSlashProduct;
                }
            }
        }
        return maxProduct;
    }

    public int highlyDivisibleTriangularNumber() {
        int i = 8;
        int sum = 28;
        while (true) {
            int count = countDivisors(sum);
            System.out.println(sum + " - " + i + " - " + count);
            if (count > 500) {
                return sum;
            }
            sum+=i;
            i++;
        }
    }

    private int countDivisors(int number) {
        if (number == 1) {
            return 1;
        }
        int root = (int)Math.floor(Math.sqrt(number));
        int count = 2;
        for (int i = 2; i < root; i++) {
            if (number % i == 0) {
                count += 2;
            }
        }
        if (number % root == 0) {
            count++;
        }
        return count;
    }

    private String largeSum(String[] numbers) {
        Long sum = 0L;
        for (String number : numbers) {
            sum += Long.parseLong(number.substring(0,11));
        }
        return sum.toString().substring(0, 10);
    }

    private int largestCollatzSequence() {
        int[] counts = new int[1000000];
        counts[2] = 1;
        int maxCount = 0;
        for (int i = 2; i < 1000000; i++) {
            long number = i;
            int count = 1;
            while (number > 1) {
                if ((number & 1) == 0) {
                    number /= 2;
                } else {
                    number = (3*number) + 1;
                }
                if (number < i) {
                    count += counts[(int)number];
                    break;
                }
                count++;
            }
            count++;
            counts[i] = count;
            if (count > maxCount) {
                System.out.println(i + "-" + count);
                maxCount = count;
            }
        }
        return maxCount;
    }

    private long latticePaths(int gridSize) {
        long sum = 0;
        long[][] pathCounts = new long[gridSize+1][gridSize+1];
        pathCounts[gridSize][gridSize] = 1;
        for (int i = gridSize; i >= 0; i--) {
            for (int j = gridSize ; j >= 0; j--) {
                if (j+1 <= gridSize) {
                    pathCounts[i][j] += pathCounts[i][j+1];
                }
                if (i+1 <= gridSize) {
                    pathCounts[i][j] += pathCounts[i+1][j];
                }
            }
        }
        return pathCounts[0][0];
    }


    public long powerDigitSum(int power) {
        int[] digits = new int[1000];
        digits[digits.length-1] = 1;
        for (int i = 1; i <= power; i++) {
            int carry = 0;
            for (int j = digits.length-1; j >= 0; j--) {
                int x = digits[j] << 1;
                int remainder = x%10;
                digits[j] = remainder+carry;
                carry = x/10;
                if (digits[j] > 9) {
                    throw new RuntimeException("Digit too big!");
                }
            }
        }
        for (int k = 0; k < digits.length;k++) {
            System.out.print(digits[k]);
        }
        System.out.println();
        long sum = 0;
        for (int i = 0; i < digits.length;i++) {
            sum += digits[i];
        }
        return sum;
    }

    public long numberLetterCounts() {
        String[] digits = {"","one","two","three","four","five","six","seven","eight","nine"};
        String[] teens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tens = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        long count = 0;
        String hundred = "hundred";
        String and = "and";
        long[] cache = new long[1000];
        String[] textCache = new String[1000];
        textCache[0] = "";
        for (int i = 1; i < 1000;i++) {
            String number;
            long length;
            if (i < 10) {
                number = digits[i];
                length = digits[i].length();
                count += length;
                cache[i] = length;
                textCache[i] = number;
            } else if (i >= 10 && i < 20) {
                number = teens[i-10];
                length = teens[i-10].length();
                count += length;
                cache[i] = length;
                textCache[i] = number;
            } else if (i >= 20 && i < 100) {
                int tenDigit = i/10;
                int digit = i%10;
                number = tens[tenDigit] + textCache[digit];
                length = tens[tenDigit].length() + cache[digit];
                count += length;
                cache[i] = length;
                textCache[i] = number;
            } else {
                int hundreds = i/100;
                int tenDigits = i%100;
                number = digits[hundreds] + hundred;
                length = digits[hundreds].length() + hundred.length();
                if (tenDigits > 0) {
                    number += and + textCache[tenDigits];
                    length += and.length() + cache[tenDigits];
                }
                count += length;
                cache[i] = length;
            }
            if (number.length() != length) {
                throw new RuntimeException(number);
            }
            System.out.println(number + " - " + length);
        }
        String thousand = "onethousand";
        count += thousand.length();
        return count;
    }

    public int maxPathSum2(int[][] triangle) {
        for (int i = triangle.length-2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }

    public int maxPathSum(int[][] triangle) {
        int[][] distances = new int[triangle.length][];
        for (int i = 0; i < triangle.length;i++) {
            distances[i] = new int[triangle[i].length];
        }
        int max = 0;
        distances[0][0] = triangle[0][0];
        PriorityQueue<GraphNode> nodes = new PriorityQueue<GraphNode>();
        nodes.add(new GraphNode(triangle[0][0],0,0));
        while (!nodes.isEmpty()) {
            GraphNode current = nodes.poll();
            if (current.arrayIndex == triangle.length-1) {
                if (current.distance > max) {
                    max = current.distance;
                }
                continue;
            }
            for (int i = 0; i <=1;i++) {
                if (distances[current.arrayIndex+1][current.index+i] < distances[current.arrayIndex][current.index] + triangle[current.arrayIndex+1][current.index+i]) {
                    distances[current.arrayIndex+1][current.index+i] = distances[current.arrayIndex][current.index] + triangle[current.arrayIndex+1][current.index+i];
                    GraphNode adj = new GraphNode(distances[current.arrayIndex+1][current.index+i], current.arrayIndex+1, current.index+i);
                    if (nodes.contains(adj)) {
                        nodes.remove(adj);
                        nodes.offer(adj);
                    }
                    nodes.offer(adj);
                }
            }
        }
        return max;
    }



    private class GraphNode implements Comparable {
        public int distance;
        public int arrayIndex;
        public int index;

        public GraphNode(int dist,int arrayIndex, int index) {
            this.distance = dist;
            this.arrayIndex = arrayIndex;
            this.index = index;
        }

        public int compareTo(Object o) {
            GraphNode other = (GraphNode)o;
            if (this.distance < other.distance) {
                return 1;
            } else if (this.distance > other.distance) {
                return -1;
            }
            return 0;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + this.distance;
            hash = 97 * hash + this.arrayIndex;
            hash = 97 * hash + this.index;
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            GraphNode other = (GraphNode)o;
            if (this.arrayIndex == other.arrayIndex && this.index == other.index) {
                return true;
            }
            return false;
        }
    }

    public int sundaysOnFirst() {
        int[] months = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        int days = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(1900,0,1);
        System.out.println("First: " + new SimpleDateFormat("EEE, dd MMM yyyy").format(cal.getTime()));
        for (int i = 0; i < months.length;i++) {
            days += months[i];
            cal.add(Calendar.DATE, months[i]);
            System.out.println(new SimpleDateFormat("EEE, dd MMM yyyy").format(cal.getTime()));
        }
        int year = 1901;
        int sundays = 0;
        while (year < 2001) {
            for (int i = 0; i < months.length;i++) {
                days += months[i];
                cal.add(Calendar.DATE, months[i]);
                if (i == 1 && isLeapYear(year)) {
                    days++;
                    cal.add(Calendar.DATE, 1);
                }
                System.out.println(new SimpleDateFormat("EEE, dd MMM yyyy").format(cal.getTime()));
                System.out.println(cal.get(Calendar.DAY_OF_WEEK));
                if (cal.get(Calendar.DAY_OF_WEEK) == 1 && cal.get(Calendar.YEAR) < 2001) {
                    sundays++;
                }
            }
            year++;
        }
        return sundays;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public int factorialDigitSum() {
        BigInteger factorial = new BigInteger("1");
        BigInteger ten = new BigInteger("10");
        for (int i=2; i < 100; i++) {
            Integer multiplier = i;
            if (multiplier%10 == 0) {
                multiplier /= 10;
            }
            factorial = factorial.multiply(new BigInteger(multiplier.toString()));
            if (factorial.remainder(ten).intValue() == 0) {
                factorial = factorial.divide(ten);
            }
            System.out.println(i + " - " + factorial);
        }
        int sum = 0;
        String s = factorial.toString();
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }

    private int sumAmicableNumbers() {
        int[] numbers = new int[10001];
        numbers[1] = 1;
        for (int i = 2; i <= 10000; i++) {
            numbers[i] = sumDivisors(i);
            //System.out.println(i + " - " + numbers[i]);
        }
        int sum = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (i == numbers[i]) {
                continue;
            }
            if (numbers[i] == -1) {
                continue;
            }
            int number1 = numbers[i];
            if (number1 > numbers.length-1) {
                continue;
            }
            int number2 = numbers[number1];
            if (i == number2) {
                sum += i;
                sum += number1;
                numbers[number1] = -1;
                System.out.println(i + " - " + number1 + " - " + number2);
            }
        }
        return sum;
    }

    private int sumDivisors(int number) {
        int sum = 1;
        int root = (int)Math.floor(Math.sqrt(number));
        for (int i = 2; i <= root; i++) {
            if (number % i == 0) {
                sum += i;
                int result = number/i;
                if (i != result) {
                    sum += result;
                }
            }
        }
        return sum;
    }

    public long nameScores() {
        long score = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("c:\\topcoder-java\\Euler\\names.txt"));
            List<String> names = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                addNames(line,names);
                line = reader.readLine();
            }
            Collections.sort(names);
            for (int i = 0; i < names.size(); i++) {
                int letterSum = 0;
                String name = names.get(i);
                for (int j = 0; j < name.length(); j++) {
                    letterSum += name.charAt(j) - 'A' + 1;
                }
                System.out.println((i+1)+ "-" + name + "-" + letterSum);
                score += (i+1) * letterSum;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return score;
    }

    private void addNames(String line, List<String> names) {
        String[] namesArray = line.split(",");
        for (String s : namesArray) {
            names.add(s.substring(1, s.length()-1));
        }
    }
    
    public long nonAbundantSums() {
        long sum = 0;
        List<Integer> abundants = new ArrayList<Integer>();
        int limit = 28123;
        for (int i = 2; i <= limit;i++) {
            int divisorSum = sumDivisors(i);
            if (divisorSum > i) {
                abundants.add(i);
                //System.out.println(i);
            }
        }
        //System.out.println(abundants.size());
        boolean[] sums = new boolean[limit];
        for (int i1 : abundants) {
            for (int i2 : abundants) {
                int abundantSum = i1 + i2;
                if (abundantSum < limit) {
                    sums[abundantSum] = true;
                }
            }
        }
        for (int i = 1; i < sums.length; i++) {
            if (!sums[i]) {
                //System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }

    public int lexPermutations() {
        int count = 1;
        int current = 123456789;
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(current);
        while (set.size() != 1000000) {
            current++;
            if (isPermutation(current)) {
                System.out.println(count + " - " + current);
                set.add(current);
                count++;
            }
        }
        return set.last();
    }

    public int lexPermutations1() {
        TreeSet<String> perms = new TreeSet<String>();
        HashMap<String,List<String>> cache = new HashMap<String, List<String>>();
        String startingPerm = "0123456789";
        for (int i = 0; i < startingPerm.length(); i++) {
            char c = startingPerm.charAt(i);
            String other = startingPerm.replace(c+"", "");
            System.out.println("Remaining: " + other);
            List<String> lowerPerms = generatePermutation(other,cache);
            System.out.println("Subpermutation size: " + lowerPerms.size());
            for (String p : lowerPerms) {
                perms.add(c + p);
                System.out.println("Permutation: " + c+p);
            }
            if (perms.size() >= 1000000) {
                break;
            }
        }
        int count = 0;
        String result = "";
        for (String s : perms) {
            count++;
            if (count == 1000000) {
                result = s;
                break;
            }
        }
        System.out.println("Result: " + result);
        return Integer.parseInt(result);
    }

    public List<String> generatePermutation(String remaining, HashMap<String,List<String>> cache) {
        if (remaining.length() == 1) {
            List<String> list = new ArrayList<String>(1);
            list.add(remaining);
            return list;
        }
        if (cache.containsKey(remaining)) {
            return cache.get(remaining);
        }
        List<String> perms = new ArrayList<String>();
        for (int i = 0; i < remaining.length(); i++) {
            char c = remaining.charAt(i);
            String other = remaining.replace(c+"", "");
            System.out.println("Other: " + other);
            List<String> lowerPerms = generatePermutation(other,cache);
            for (String p : lowerPerms) {
                perms.add(c + p);
            }
        }
        cache.put(remaining, perms);
        return perms;
    }

    private boolean isPermutation(int number) {
        boolean[] foundDigit = new boolean[10];
        if (number < 1000000000) {
            foundDigit[0] = true;
        }
        while (number > 0) {
            int digit = number % 10;
            if (foundDigit[digit]) {
                return false;
            } else {
                foundDigit[digit] = true;
            }
            number = number/10;
        }
        for (boolean found : foundDigit) {
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public long fib1000Term() {
        long termCount = 2;
        BigInteger term1 = new BigInteger("1");
        BigInteger term2 = new BigInteger("1");
        BigInteger temp = new BigInteger("0");
        while(term2.toString().length() != 1000) {
            temp = term2;
            term2 = term2.add(term1);
            term1 = temp;
            termCount++;
            System.out.println(termCount + " - " + term2.toString());
        }
        return termCount;
    }

    public int reciprocalCycles() {
        int denominator = 2;
        int numerator = 1;
        NumberFormat formatter = NumberFormat.getNumberInstance();
        //formatter.setMinimumFractionDigits(30);
        int maxCycleLength = 0;
        int maxDenominator = 0;
        while (denominator <= 1000) {
            double result = (double)numerator/(double)denominator;
            System.out.println(denominator + "-" + formatter.format(result));
            int cycleLength = findCycle(denominator);
            if (cycleLength > maxCycleLength) {
                maxCycleLength = cycleLength;
                maxDenominator = denominator;
                System.out.println("Max Cycle length: " + cycleLength + " - " + denominator);
            }
            denominator++;
        }
        return maxDenominator;
    }

    private int findCycle(int denominator) {
        boolean[] seen = new boolean[1001];
        List<Integer> cycle = new ArrayList<Integer>();
        seen[1] = true;
        int numerator = increaseNumerator(1, denominator);
        int step = 0;
        boolean cycleFound = false;
        //System.out.println("Denominator: " + denominator);
        while (numerator != 0) {
            int result = numerator/denominator;
            cycle.add(result);
            int remainder = numerator % denominator;
            if (seen[remainder]) {
                //System.out.println("Found cycle at:" + result + "-" + remainder);
                cycleFound = true;
                break;
            }
            seen[remainder] = true;
            //System.out.println("Result: " + result);
            //System.out.println("Remainder: " + remainder);
            numerator = increaseNumerator(remainder, denominator);
            step++;
        }
        if (!cycleFound) {
            return 0;
        }
        int cycleLength = 0;
        System.out.print("Cycle: ");
        for (int i : cycle) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < seen.length; i++) {
            boolean b = seen[i];
            if (b) {
                cycleLength++;
            }
        }
        return cycleLength;
    }

    private int increaseNumerator(int numerator, int denominator) {
        if (numerator == 0) {
            return 0;
        }
        while (numerator < denominator) {
            numerator *= 10;
        }
        return numerator;
    }

    public long quadraticPrimes() {
        List<Long> primes = new ArrayList<Long>();
        primes.add(2L);
        primes.add(3L);
        long number = 5;
        while (number < 1000) {
            if (isPrime(number,primes)) {
                primes.add(number);
                //System.out.println("Sum:" + sum);
            }
            number += 2;
        }
        System.out.println("Number of primes: " + primes.size());
        int[] coeff = new int[] {1,-1};
        int maxNumberPrimes = 0;
        long maxProduct = 0;
        for (int a = 0; a < 1000; a++) {
            for (int i = 0; i < coeff.length; i++) {
                //System.out.println("a:" + a*coeff[i]);
                for (long b: primes) {
                    for (int j = 0; j < coeff.length; j++) {
                        //System.out.println("b:" + b*coeff[j]);
                        long product = 2L;
                        int n = 0;
                        List<Long> genPrimes = new ArrayList<Long>();
                        for (; isPrime(product); n++) {
                            product = n*n + a*coeff[i]*n + b*coeff[j];
                            genPrimes.add(product);
                        }
                        n--;
                        if (n > maxNumberPrimes) {
                            maxNumberPrimes = n;
                            maxProduct = a * coeff[i] * b * coeff[j];
                            /*for (long prime : genPrimes) {
                                System.out.print(prime + ",");
                            }
                            System.out.println();*/
                            System.out.println("New best: " + maxNumberPrimes + " a:" + a*coeff[i] + " b:" + b*coeff[j]);
                        }
                    }
                }
            }
        }
        return maxProduct;
    }

    public long spiralDiagonals() {
        long sum = 1;
        long current = 1;
        for (int size = 2; size <= 1000; size += 2) {
            current++;
            current = current + size-1;
            sum += current;
            current = current + size;
            sum += current;
            current = current + size;
            sum += current;
            current = current + size;
            sum += current;
        }
        return sum;
    }

    public long distinctPowers() {
        long count = 0;
        int min = 2;
        int max = 100;
        int maxRoot = (int)Math.floor(Math.sqrt(max));

        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int prime = 3;
        while (prime < maxRoot) {
            if (isPrime(prime)) {
                primes.add(prime);
            }
            prime += 2;
        }

        boolean[][] duplicates = new boolean[max+1][max+1];
        for (int number = maxRoot; number >= min; number--) {
            for (int i = max; i >= min; i--) {
                for (int primeFactor : primes) {
                    int power = i;
                    int primeFactorProduct = 1;
                    if (power == 1) {
                        break;
                    }
                    if (power % primeFactor != 0) {
                        continue;
                    }
                    while (power % primeFactor == 0 && power > 1) {
                        power /= primeFactor;
                        primeFactorProduct *= primeFactor;
                        double numOnPower = (int)Math.pow(number,primeFactorProduct);
                        if (numOnPower > max) {
                            break;
                        }
                        duplicates[(int)numOnPower][power] = true;
                    }
                }
            }
        }
        int totalCount = 0;
        for (int i = 2; i < duplicates.length; i++) {
            for (int j = 2; j < duplicates[0].length; j++) {
                if (!duplicates[i][j]) {
                    count++;
                } else {
                    System.out.println("Duplicate: " + i + "^" + j);
                }
                totalCount++;
            }
        }
        System.out.println("Total count: " + totalCount);
        return count;
    }

    public int distinctPowers1() {
        Set<String> powers = new TreeSet<String>();
        
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int prime = 3;
        while (prime < 100) {
            if (isPrime(prime)) {
                primes.add(prime);
            }
            prime += 2;
        }
        int max = 100;
        for (int i = 2; i <= max; i++) {
            int number = i;
            List<Integer> factors = new ArrayList<Integer>();
            List<Integer> factorPowers = new ArrayList<Integer>();
            for (int primeFactor : primes) {
                if (number == 1) {
                    break;
                }
                int power = 0;
                while (number % primeFactor == 0) {
                    number /= primeFactor;
                    power++;
                }
                if (power > 0) {
                    factors.add(primeFactor);
                    factorPowers.add(power);
                }
            }
            for (int j = 2; j <= max; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < factors.size(); k++) {
                    sb.append(factors.get(k));
                    sb.append("-");
                    sb.append(factorPowers.get(k)*j);
                    sb.append("-");
                }
                String num = sb.toString();
                powers.add(num);
                /*if (!powers.contains(num)) {
                    //System.out.println(i + "^" + j);
                } else {
                    System.out.println("Duplicate: " + i + "^" + j);
                }*/
            }
        }
        return powers.size();
    }

    public long digitFifthPowers() {
        long sum = 0;
        int[] powers = new int[10];
        for (int i = 0; i < powers.length; i++) {
            powers[i] = (int)Math.pow(i, 5);
            System.out.println(i + "-" + powers[i]);
        }
        numLoop:
        for (int i = 2; i < 1000000; i++) {
            int number = i;
            int digitPowerSum = 0;
            int digit;
            while (number > 0) {
                digit = number % 10;
                if (powers[digit] > i) {
                    continue numLoop;
                }
                digitPowerSum += powers[digit];
                number /= 10;
            }
            if (digitPowerSum == i) {
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }

    public int coinSums() {
        int[] denoms = {200,100,50,20,10,5,2,1};
        cache = new int[201][denoms.length];
        for (int[] row : cache) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -1;
            }
        }
        //int[] denoms = {20,10,5,2,1};//,20,10,5,2,1};
        return coinSumHelper(200, denoms, 0);
    }

    private static long counter = 0;
    private int[][] cache;
    private int coinSumHelper(int amount, int[] denominations, int current) {
        if (cache[amount][current] != -1) {
            System.out.println("Hit cache");
            return cache[amount][current];
        }
        int oldAmount = amount;
        int currentDenom = denominations[current];
        if (amount == 0) {
            System.out.println("Amount: " + oldAmount + " Count: 1 Denom: " + currentDenom);
            counter++;
            //System.out.println();
            return 1;
        }
        if (current == denominations.length-1) {
            System.out.println("Amount: " + oldAmount + " Count: 1 Denom: " + currentDenom);
            //System.out.println(amount + "x1p");
            counter++;
            cache[amount][current] = 1;
            return 1;
        }
        //System.out.print("Amount: " + amount + " ");
        int count = coinSumHelper(amount, denominations, current+1);
        int denomCount = 1;
        while (amount > 0) {
            amount -= currentDenom;
            if (amount < 0) {
                break;
            } else if (amount == 0) {
                counter++;
                count++;
                break;
            }
            //System.out.print(denomCount + "x" + currentDenom + "p + ");
            count += coinSumHelper(amount, denominations, current+1);
            denomCount++;
        }
        cache[oldAmount][current] = count;
        System.out.println("Amount: " + oldAmount + " Count: " + count + " Denom: " + currentDenom);
        return count;
    }

    public long panDigitalProducts() {
        long sum = 0;
        for (int number=123456789; number <= 987654321; number++) {
            if (isPanDigital(number)) {

            }
        }
        return sum;
    }

    private boolean isPanDigital(int number) {
        int found = 0;
        while(number > 0) {
            int digit = number % 10;
            if (digit == 0) {
                return false;
            }
            int result = found & (1 << digit);
            if (result > 0) {
                return false;
            }
            found = found | (1 << digit);
            number /= 10;
        }
        return true;
    }

    private Set<Integer> panDigitalNumbers = new HashSet<Integer>();
    public void generatePanDigitalNumbers(int number, int[] digits) {
        int digitsLeft = 0;
        for (int digit : digits) {
            if (digit != -1) {
                digitsLeft++;
            }
        }
        if (digitsLeft == 0) {
            panDigitalNumbers.add(number);
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == -1) {
                continue;
            }
            int temp = digits[i];
            digits[i] = -1;
            int tempNumber = number + (int)Math.pow(10, digitsLeft-1)*temp;
            generatePanDigitalNumbers(tempNumber, digits);
            digits[i] = temp;
        }
    }

    public long panDigitalProducts1() {
        long sum = 0;
        int[] multiplicandSize = {1,2,3,4};
        int[] multiplierSize = {4,3,2,1};

        Set<Integer> truePanDigitalNumbers = new HashSet<Integer>();
        for (int i : panDigitalNumbers) {
            int number = i;
            //System.out.println(number);
            for (int k = 0; k < multiplicandSize.length; k++ ) {
                int factor1 = (int)Math.pow(10,(9-multiplicandSize[k]));
                int multiplicand = number / factor1;
                //System.out.println("Multiplicand: " + multiplicand);
                int factor2 = (int)Math.pow(10,(9-multiplicandSize[k] - multiplierSize[k]));
                int multiplier = number / factor2;
                int factor3 = (int)Math.pow(10, multiplierSize[k]);
                multiplier = multiplier % factor3;
                //System.out.println("Multiplier: " + multiplier);
                int product = number % factor2;
                //System.out.println("Product: " + product);
                if (multiplicand * multiplier == product) {
                    System.out.println(multiplicand + "x" + multiplier + "=" + product);
                    truePanDigitalNumbers.add(product);
                }
            }
        }
        for (int number : truePanDigitalNumbers) {
            sum += number;
        }
        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }

    public int digitCancellingFractions() {
        int productNum = 1;
        int productDenom = 1;
        for (int i=10; i < 99; i++) {
            for (int j = i+1; j < 100; j++) {
                int num = i;
                int denom = j;
                int numDigit1 = num / 10;
                int numDigit2 = num % 10;
                int denomDigit1 = denom / 10;
                int denomDigit2 = denom %10;
                if (numDigit1 == 0 || numDigit2 == 0 || denomDigit1 == 0 || denomDigit2 == 0) {
                    continue;
                }
                int gcd = gcd(num,denom);
                num /= gcd;
                denom /= gcd;
                if (numDigit2 == denomDigit2 && numDigit1 < denomDigit1) {
                    int gcd1 = gcd(denomDigit1,numDigit1);
                    int t1 = numDigit1/gcd1;
                    int t2 = denomDigit1/gcd1;
                    if (t1 == num && t2 == denom) {
                        System.out.println(i + "-" + j + "," + numDigit1+"-" + denomDigit1);
                        productNum *= i;
                        productDenom *= j;
                    }
                } else if (numDigit2 == denomDigit1 && numDigit1 < denomDigit2) {
                    int gcd1 = gcd(denomDigit2,numDigit1);
                    int t1 = numDigit1/gcd1;
                    int t2 = denomDigit2/gcd1;
                    if (t1 == num && t2 == denom) {
                        System.out.println(i + "-" + j + "," + numDigit1+"-" + denomDigit2);
                        productNum *= i;
                        productDenom *= j;
                    }
                } else if (numDigit1 == denomDigit2 && numDigit2 < denomDigit1) {
                    int gcd1 = gcd(denomDigit1,numDigit2);
                    int t1 = numDigit2/gcd1;
                    int t2 = denomDigit1/gcd1;
                    if (t1 == num && t2 == denom) {
                        System.out.println(i + "-" + j + "," + numDigit2+"-" + denomDigit1);
                        productNum *= i;
                        productDenom *= j;
                    }
                } else if (numDigit1 == denomDigit1 && numDigit2 < denomDigit2) {
                    int gcd1 = gcd(denomDigit2,numDigit2);
                    int t1 = numDigit2/gcd1;
                    int t2 = denomDigit2/gcd1;
                    if (t1 == num && t2 == denom) {
                        System.out.println(i + "-" + j + "," + numDigit2 + "-" + denomDigit2);
                        productNum *= i;
                        productDenom *= j;
                    }
                }
            }
        }
        int productGcd = gcd(productDenom,productNum);
        productDenom /= productGcd;
        return productDenom;
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        int i = 1;
        while (i <= n) {
            fact *= i;
            i++;
        }
        return fact;
    }

    public long digitFactorials() {
        long sum = 0;
        int[] factorials = new int[10];
        for (int i = 0; i < factorials.length; i++) {
            factorials[i] = factorial(i);
            System.out.println(i + "-" + factorials[i]);
        }
        numLoop:
        for (int i = 10; i < 1000000000; i++) {
            int number = i;
            int digitFactorialSum = 0;
            int digit;
            while (number > 0) {
                digit = number % 10;
                if (factorials[digit] > i) {
                    continue numLoop;
                }
                digitFactorialSum += factorials[digit];
                number /= 10;
            }
            if (digitFactorialSum == i) {
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }

    public int circularPrimes() {
        int count = 5;
        List<Long> primes = new ArrayList<Long>();
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);
        primes.add(7L);
        primes.add(11L);
        int number = 13;
        boolean[] primeFlags = new boolean[1000000];
        primeFlags[2] = true;
        primeFlags[3] = true;
        primeFlags[5] = true;
        primeFlags[7] = true;
        primeFlags[11] = true;
        while (number < 1000000) {
            if (isPrime(number,primes)) {
                primes.add((long)number);
                if (primeFlags[number]) {
                    number += 2;
                    continue;
                }
                primeFlags[number] = true;

                //System.out.println("Number: " + number);

                int tens = 10;
                while (number > tens) {
                    tens *= 10;
                }
                tens /= 10;

                int rotation = number;
                int lastDigit = rotation %10;
                rotation = rotation/10;
                rotation = tens*lastDigit + rotation;
                //System.out.println("Rotation: " + rotation);
                boolean foundNonPrime = false;
                int rotationCount = 1;
                while (rotation != number) {
                    if (primeFlags[rotation] || isPrime(rotation)) {
                        primeFlags[rotation] = true;
                    } else  {
                        foundNonPrime = true;
                        break;
                    }
                    lastDigit = rotation %10;
                    rotation = rotation/10;
                    rotation = tens*lastDigit + rotation;
                    //System.out.println("Rotation: " + rotation);
                    rotationCount++;
                }
                if (!foundNonPrime) {
                    count += rotationCount;
                    System.out.println(number);
                }
            }
            number += 2;
        }
        return count;
    }

    public long doubleBasedPalindromes() {
        long sum = 0;
        for (int i = 1; i < 1000000; i += 2) {
            int number = i;
            int tens = 10;
            while(number > tens) {
                tens *= 10;
            }
            if (number != tens) {
                tens /= 10;
            }
            boolean isPalindrome = true;
            while(tens > 1) {
                int firstDigit = number/tens;
                int lastDigit = number % 10;
                if (firstDigit != lastDigit) {
                    isPalindrome = false;
                    break;
                }
                number = number % tens;
                number = number/10;
                tens/=100;
            }
            if (!isPalindrome) {
                continue;
            } else {
                //System.out.println(i);
            }
            int binary = i;
            int high = 0;
            while (binary > 0) {
                binary = binary >> 1;
                high++;
            }
            high--;
            binary = i;
            String sBinary = Integer.toBinaryString(binary);
            int lo = 0;
            while (high > lo) {
                int mask = 1 << lo;
                String sMask = Integer.toBinaryString(mask);
                int loMask = binary & mask;
                String s1 = Integer.toBinaryString(loMask);
                mask = 1 << high;
                sMask = Integer.toBinaryString(mask);
                int highMask = binary & mask;
                String s2 = Integer.toBinaryString(highMask);
                if (loMask != highMask && (loMask == 0 || highMask == 0)) {
                    isPalindrome = false;
                    break;
                }
                high--;
                lo++;
            }
            if (isPalindrome) {
                System.out.println(i + " - " + Integer.toString(i, 2));
                sum += i;
            }
        }
        return sum;
    }

    public long truncatablePrimes() {
        long sum = 0;
        int count = 0;
        List<Long> primes = new ArrayList<Long>();
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);
        primes.add(7L);
        boolean[] primeFlags = new boolean[1000000];
        primeFlags[2] = true;
        primeFlags[3] = true;
        primeFlags[5] = true;
        primeFlags[7] = true;
        int number = 11;
        main:
        while (count < 11) {
            if (isPrime(number,primes)) {
                primes.add((long)number);
                primeFlags[number] = true;

                int prime = number;
                while (prime > 0) {
                    prime /= 10;
                    if (prime > 0 && !primeFlags[prime]) {
                        number += 2;
                        continue main;
                    }
                }

                int tens = 10;
                while (number > tens) {
                    tens *= 10;
                }
                tens /= 10;

                prime = number;
                while (tens > 1) {
                    prime = prime % tens;
                    tens /= 10;
                    if (prime > 0 && !primeFlags[prime]) {
                        number += 2;
                        continue main;
                    }
                }
                System.out.println("Found trunc prime: " + number);
                sum += number;
                count++;
            }
            number += 2;
        }

        return sum;
    }

    public int maxPandigitalMultiple() {
        int maxPanDigital = 987654321;
        int maxMultiple = 0;
        main:
        for (int i = 1; i < maxPanDigital; i++) {
            int mask = 0;
            int number = i;
            while (number > 0) {
                int digit = number % 10;
                if (digit == 0) {
                    continue main;
                }
                int digitMask = 1 << (digit-1);
                if ((mask & digitMask) > 0) {
                    continue main;
                }
                mask = mask | digitMask;
                number /= 10;
            }
            int multiplier = 2;
            while (true) {
                int multiple = i * multiplier;
                number = multiple;
                if (multiple > maxPanDigital) {
                    break;
                }
                while (number > 0) {
                    int digit = number % 10;
                    if (digit == 0) {
                        continue main;
                    }
                    int digitMask = 1 << (digit-1);
                    if ((mask & digitMask) > 0) {
                        continue main;
                    }
                    mask = mask | digitMask;
                    number /= 10;
                }
                if (mask == 511) {
                    if (mask >= maxMultiple) {
                        System.out.println(i + "-" + multiplier + " - " + Integer.toBinaryString(mask));
                        maxMultiple = mask;
                    }
                    continue main;
                }
                multiplier++;
            }
        }
        return maxMultiple;
    }

    public int rightTriangles() {
        int[] counts = new int[1001];
        for (int a = 1; a < 500; a++) {
            for (int b = a+1; b < 500; b++) {
                int c2 = a*a + b*b;
                int c = (int)Math.sqrt(c2);
                if (c*c != c2) {
                    continue;
                }
                int perimeter = a + b + c;
                //System.out.println(a+", " + b + ", " + c);
                //System.out.println("Perimeter: " + perimeter);
                if (perimeter < counts.length) {
                    counts[perimeter]++;
                }
            }
        }
        int maxCount = 0;
        int maxPerimeter = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxPerimeter = i;
            } else if (counts[i] == maxCount) {
                //System.out.println("Equal max:" + i + "-" + counts[i]);
            }
        }
        //System.out.println("Max Count: " + maxCount);
        return maxPerimeter;
    }

    private int numberOfDigits(int number) {
        int tens = 10;
        int digitCount = 1;
        while(number >= tens) {
            digitCount++;
            tens *= 10;
        }
        return digitCount;
    }

    public long getChampernowneConstant() {
        long constant = 1;
        int digitCount = 0;
        int number = 1;
        int nextDigitPosition = 1;
        while (digitCount <= 1000000) {
            int temp = number;
            int numberOfDigits = numberOfDigits(number);
            int tens = (int)Math.pow(10, numberOfDigits-1);
            while (tens > 0) {
                int digit = temp/tens;
                digitCount++;
                if (digitCount == nextDigitPosition) {
                    constant *= digit;
                    nextDigitPosition *= 10;
                    System.out.println("Number digit: " + digit);
                }
                temp %= tens;
                tens /= 10;
            }
            number++;
        }

        return constant;
    }

    public int largestPanDigitalPrime() {
        int[] digits = new int[] {1,2,3,4,5,6,7,8,9};
        for (int i = digits.length - 1; i > 1; i-- ) {
            panDigitalNumbers.clear();
            generatePanDigitalNumbers(0, digits);
            //System.out.println(panDigitalNumbers.size());
            int maxPrime = 0;
            for (int number : panDigitalNumbers) {
                if (number > maxPrime && isPrime(number)) {
                    maxPrime = number;
                }
            }
            if (maxPrime > 0) {
                return maxPrime;
            }
            digits[i] = -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problems_1_50 p = new Problems_1_50();
        System.out.println(p.largestPanDigitalPrime());
    }
}
        /*
                 int[][] triangle =
            {
            {75},
            {95,64},
            {17,47,82},
            {18,35,87,10},
            {20,04,82,47,65},
            {19,01,23,75,03,34},
            {88,02,77,73,07,63,67},
            {99,65,04,28,06,16,70,92},
            {41,41,26,56,83,40,80,70,33},
            {41,48,72,33,47,32,37,16,94,29},
            {53,71,44,65,25,43,91,52,97,51,14},
            {70,11,33,28,77,73,17,78,39,68,17,57},
            {91,71,52,38,17,14,91,43,58,50,27,29,48},
            {63,66,04,68,89,53,67,30,73,16,69,87,40,31},
            {04,62,98,27,23, 9,70,98,73,93,38,53,60,04,23}};

         String[] numbers = {
"37107287533902102798797998220837590246510135740250",
"46376937677490009712648124896970078050417018260538",
"74324986199524741059474233309513058123726617309629",
"91942213363574161572522430563301811072406154908250",
"23067588207539346171171980310421047513778063246676",
"89261670696623633820136378418383684178734361726757",
"28112879812849979408065481931592621691275889832738",
"44274228917432520321923589422876796487670272189318",
"47451445736001306439091167216856844588711603153276",
"70386486105843025439939619828917593665686757934951",
"62176457141856560629502157223196586755079324193331",
"64906352462741904929101432445813822663347944758178",
"92575867718337217661963751590579239728245598838407",
"58203565325359399008402633568948830189458628227828",
"80181199384826282014278194139940567587151170094390",
"35398664372827112653829987240784473053190104293586",
"86515506006295864861532075273371959191420517255829",
"71693888707715466499115593487603532921714970056938",
"54370070576826684624621495650076471787294438377604",
"53282654108756828443191190634694037855217779295145",
"36123272525000296071075082563815656710885258350721",
"45876576172410976447339110607218265236877223636045",
"17423706905851860660448207621209813287860733969412",
"81142660418086830619328460811191061556940512689692",
"51934325451728388641918047049293215058642563049483",
"62467221648435076201727918039944693004732956340691",
"15732444386908125794514089057706229429197107928209",
"55037687525678773091862540744969844508330393682126",
"18336384825330154686196124348767681297534375946515",
"80386287592878490201521685554828717201219257766954",
"78182833757993103614740356856449095527097864797581",
"16726320100436897842553539920931837441497806860984",
"48403098129077791799088218795327364475675590848030",
"87086987551392711854517078544161852424320693150332",
"59959406895756536782107074926966537676326235447210",
"69793950679652694742597709739166693763042633987085",
"41052684708299085211399427365734116182760315001271",
"65378607361501080857009149939512557028198746004375",
"35829035317434717326932123578154982629742552737307",
"94953759765105305946966067683156574377167401875275",
"88902802571733229619176668713819931811048770190271",
"25267680276078003013678680992525463401061632866526",
"36270218540497705585629946580636237993140746255962",
"24074486908231174977792365466257246923322810917141",
"91430288197103288597806669760892938638285025333403",
"34413065578016127815921815005561868836468420090470",
"23053081172816430487623791969842487255036638784583",
"11487696932154902810424020138335124462181441773470",
"63783299490636259666498587618221225225512486764533",
"67720186971698544312419572409913959008952310058822",
"95548255300263520781532296796249481641953868218774",
"76085327132285723110424803456124867697064507995236",
"37774242535411291684276865538926205024910326572967",
"23701913275725675285653248258265463092207058596522",
"29798860272258331913126375147341994889534765745501",
"18495701454879288984856827726077713721403798879715",
"38298203783031473527721580348144513491373226651381",
"34829543829199918180278916522431027392251122869539",
"40957953066405232632538044100059654939159879593635",
"29746152185502371307642255121183693803580388584903",
"41698116222072977186158236678424689157993532961922",
"62467957194401269043877107275048102390895523597457",
"23189706772547915061505504953922979530901129967519",
"86188088225875314529584099251203829009407770775672",
"11306739708304724483816533873502340845647058077308",
"82959174767140363198008187129011875491310547126581",
"97623331044818386269515456334926366572897563400500",
"42846280183517070527831839425882145521227251250327",
"55121603546981200581762165212827652751691296897789",
"32238195734329339946437501907836945765883352399886",
"75506164965184775180738168837861091527357929701337",
"62177842752192623401942399639168044983993173312731",
"32924185707147349566916674687634660915035914677504",
"99518671430235219628894890102423325116913619626622",
"73267460800591547471830798392868535206946944540724",
"76841822524674417161514036427982273348055556214818",
"97142617910342598647204516893989422179826088076852",
"87783646182799346313767754307809363333018982642090",
"10848802521674670883215120185883543223812876952786",
"71329612474782464538636993009049310363619763878039",
"62184073572399794223406235393808339651327408011116",
"66627891981488087797941876876144230030984490851411",
"60661826293682836764744779239180335110989069790714",
"85786944089552990653640447425576083659976645795096",
"66024396409905389607120198219976047599490197230297",
"64913982680032973156037120041377903785566085089252",
"16730939319872750275468906903707539413042652315011",
"94809377245048795150954100921645863754710598436791",
"78639167021187492431995700641917969777599028300699",
"15368713711936614952811305876380278410754449733078",
"40789923115535562561142322423255033685442488917353",
"44889911501440648020369068063960672322193204149535",
"41503128880339536053299340368006977710650566631954",
"81234880673210146739058568557934581403627822703280",
"82616570773948327592232845941706525094512325230608",
"22918802058777319719839450180888072429661980811197",
"77158542502016545090413245809786882778948721859617",
"72107838435069186155435662884062257473692284509516",
"20849603980134001723930671666823555245252804609722",
"53503534226472524250874054075591789781264330331690"};*/
