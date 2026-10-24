package neetcode250._01_arrays_hashing;

public class _13_ProductOfArrayExceptSelf_238 {
    // TODO - Given an integer array we have to return an output array wherein each element of the output array is a product of all the elements besides it
    // ex. i/p -> [1,2,4,6], o/p -> [48, 24, 12, 8]

    // ? Approach - 1. Find the complete product of the array
    // ? Then when inserting each element we divide the product with the element at that position in the input array

    // Getting errors of how to handle if the input contains single or multiple zeros
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        long product = 1;
        boolean hasZero = false;
        for (int j : arr) {
            if (j == 0) {
                hasZero = true;
            } else {
                product *= j;
            }
        }
        for (int i = 0; i < n; i++) {
            if (hasZero && arr[i] != 0) {
                res[i] = 0;
            } else if (arr[i] == 0) {
                res[i] = (int) product;
            } else if (!hasZero) {
                res[i] = (int) product / arr[i];
            }
        }
        return res;
    }

    // ? Generate a prefix product and a postfix product array
    // ? Prefix product at any position i is the product of all the elements before i
    // ? Postfix product at any position i is the product of all the elements after i

    public static int[] productExceptSelfV2(int[] arr) {
        int n = arr.length;
        int[] prefixProd = new int[n];
        prefixProd[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProd[i] = prefixProd[i - 1] * arr[i - 1];
        }
        int[] suffixProd = new int[n];
        suffixProd[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            suffixProd[j] = suffixProd[j + 1] * arr[j + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefixProd[i] * suffixProd[i];
        }
        return res;
    }

    public static int[] productExceptSelfSpaceOpt(int[] arr) {
        int n = arr.length;
        int[] prefixProd = new int[n];
        prefixProd[0] = 1;
        for (int i = 1; i<n; i++){
            prefixProd[i] = arr[i-1] * prefixProd[i-1];
        }
        int rightMultiple = 1;
        for (int i = n-1; i>=0; i--){
            prefixProd[i] = prefixProd[i] * rightMultiple;
            rightMultiple = rightMultiple * arr[i];
        }
        return prefixProd;
    }

    public static void main(String[] args) {
        int[] res = productExceptSelfV2(new int[]{5, 8, 6, 2, 9});
        for (int i : res) {
            System.out.println(i);
        }
    }


}
