# DSA Solutions

Java solutions, split into the [NeetCode 250](https://neetcode.io/practice/practice/neetcode250) sheet and everything else from LeetCode.

## Layout

```
src/
├── neetcode250/          problems on the NeetCode 250 sheet
│   ├── _01_arrays_hashing/
│   ├── _02_two_pointers/
│   └── ...               one package per NeetCode topic, in roadmap order
└── leetcode/             all other LeetCode problems, same topic packages
```

## Naming conventions

- **File / class:** `_<solve order>_<ProblemName>_<LeetCode number>.java`, e.g. `_05_GroupAnagrams_49.java`.
  Solve order restarts in every topic folder, so files are listed in the order you solved them.
  Java class names can't start with a digit, hence the leading underscore.
- **Multiple attempts at one problem:** give each its own order number and a suffix, e.g. `_05_GroupAnagrams_49`, `_06_GroupAnagramsOpt_49`.
- **Package:** `<list>.<topic>`, e.g. `package neetcode250._01_arrays_hashing;`. Every file must declare the package matching its folder.
- **Finding a problem:** search by name or LeetCode number in IntelliJ with `Shift Shift` / `Ctrl+N` (e.g. type `Anagram` or `_49`), or use the tables below.

## Topic packages

| Package | NeetCode topic |
|---|---|
| `_01_arrays_hashing` | Arrays & Hashing |
| `_02_two_pointers` | Two Pointers |
| `_03_sliding_window` | Sliding Window |
| `_04_binary_search` | Binary Search |
| `_05_linked_list` | Linked List |
| `_06_stack` | Stack |
| `_07_trees` | Trees |
| `_08_tries` | Tries |
| `_09_backtracking` | Backtracking |
| `_10_heap_priority_queue` | Heap / Priority Queue |
| `_11_graphs` | Graphs |
| `_12_advanced_graphs` | Advanced Graphs |
| `_13_dp_1d` | 1-D Dynamic Programming |
| `_14_dp_2d` | 2-D Dynamic Programming |
| `_15_greedy` | Greedy |
| `_16_intervals` | Intervals |
| `_17_bit_manipulation` | Bit Manipulation |
| `_18_math_geometry` | Math & Geometry |

## NeetCode 250 (20 files)

| LC # | Problem | Difficulty | Topic | Solution |
|---|---|---|---|---|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | Arrays & Hashing | [_01_TwoSum_1](src/neetcode250/_01_arrays_hashing/_01_TwoSum_1.java) |
| 36 | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | Medium | Arrays & Hashing | [_02_ValidSudoku_36](src/neetcode250/_01_arrays_hashing/_02_ValidSudoku_36.java) |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | Easy | Arrays & Hashing | [_03_ValidAnagram_242](src/neetcode250/_01_arrays_hashing/_03_ValidAnagram_242.java) |
| 14 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | Easy | Arrays & Hashing | [_04_LongestCommonPrefix_14](src/neetcode250/_01_arrays_hashing/_04_LongestCommonPrefix_14.java) |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Medium | Arrays & Hashing | [_05_GroupAnagrams_49](src/neetcode250/_01_arrays_hashing/_05_GroupAnagrams_49.java) |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Medium | Arrays & Hashing | [_06_GroupAnagramsOpt_49](src/neetcode250/_01_arrays_hashing/_06_GroupAnagramsOpt_49.java) |
| 169 | [Majority Element](https://leetcode.com/problems/majority-element/) | Easy | Arrays & Hashing | [_07_MajorityElement_169](src/neetcode250/_01_arrays_hashing/_07_MajorityElement_169.java) |
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/) | Easy | Arrays & Hashing | [_08_RemoveElement_27](src/neetcode250/_01_arrays_hashing/_08_RemoveElement_27.java) |
| 912 | [Sort an Array](https://leetcode.com/problems/sort-an-array/) | Medium | Arrays & Hashing | [_09_SortAnArray_912](src/neetcode250/_01_arrays_hashing/_09_SortAnArray_912.java) |
| 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Medium | Arrays & Hashing | [_10_TopKFrequentElements_347](src/neetcode250/_01_arrays_hashing/_10_TopKFrequentElements_347.java) |
| 36 | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | Medium | Arrays & Hashing | [_11_ValidSudokuV2_36](src/neetcode250/_01_arrays_hashing/_11_ValidSudokuV2_36.java) |
| 75 | [Sort Colors](https://leetcode.com/problems/sort-colors/) | Medium | Arrays & Hashing | [_12_SortColors_75](src/neetcode250/_01_arrays_hashing/_12_SortColors_75.java) |
| 238 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | Medium | Arrays & Hashing | [_13_ProductOfArrayExceptSelf_238](src/neetcode250/_01_arrays_hashing/_13_ProductOfArrayExceptSelf_238.java) |
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium | Arrays & Hashing | [_14_LongestConsecutiveSequence_128](src/neetcode250/_01_arrays_hashing/_14_LongestConsecutiveSequence_128.java) |
| 122 | [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Arrays & Hashing | [_15_BestTimeToBuyAndSellStockII_122](src/neetcode250/_01_arrays_hashing/_15_BestTimeToBuyAndSellStockII_122.java) |
| 15 | [3Sum](https://leetcode.com/problems/3sum/) | Medium | Two Pointers | [_01_ThreeSum_15](src/neetcode250/_02_two_pointers/_01_ThreeSum_15.java) |
| 18 | [4Sum](https://leetcode.com/problems/4sum/) | Medium | Two Pointers | [_02_FourSum_18](src/neetcode250/_02_two_pointers/_02_FourSum_18.java) |
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Sliding Window | [_01_BestTimeToBuyAndSellStock_121](src/neetcode250/_03_sliding_window/_01_BestTimeToBuyAndSellStock_121.java) |
| 5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | 1-D Dynamic Programming | [_01_LongestPalindromicSubstring_5](src/neetcode250/_13_dp_1d/_01_LongestPalindromicSubstring_5.java) |
| 13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Easy | Math & Geometry | [_01_RomanToInteger_13](src/neetcode250/_18_math_geometry/_01_RomanToInteger_13.java) |

## LeetCode (not on NeetCode 250) (2 files)

| LC # | Problem | Difficulty | Topic | Solution |
|---|---|---|---|---|
| 16 | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | Medium | Two Pointers | [_01_ThreeSumClosest_16](src/leetcode/_02_two_pointers/_01_ThreeSumClosest_16.java) |
| 12 | [Integer to Roman](https://leetcode.com/problems/integer-to-roman/) | Medium | Math & Geometry | [_01_IntegerToRoman_12](src/leetcode/_18_math_geometry/_01_IntegerToRoman_12.java) |
