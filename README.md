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

- **File / class:** `_<LeetCode number, 4 digits>_<ProblemName>.java`, e.g. `_0049_GroupAnagrams.java`.
  Java class names can't start with a digit, hence the leading underscore. Zero-padding keeps files sorted by number.
- **Multiple attempts at one problem:** add a suffix, e.g. `_0049_GroupAnagramsOpt`, `_0036_ValidSudokuV2`.
- **Package:** `<list>.<topic>`, e.g. `package neetcode250._01_arrays_hashing;`. Every file must declare the package matching its folder.
- **Finding a problem:** search by number or name in IntelliJ with `Shift Shift` / `Ctrl+N` (e.g. type `0049` or `Anagram`), or use the tables below.

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

| # | Problem | Difficulty | Topic | Solution |
|---|---|---|---|---|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | Arrays & Hashing | [_0001_TwoSum](src/neetcode250/_01_arrays_hashing/_0001_TwoSum.java) |
| 14 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | Easy | Arrays & Hashing | [_0014_LongestCommonPrefix](src/neetcode250/_01_arrays_hashing/_0014_LongestCommonPrefix.java) |
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/) | Easy | Arrays & Hashing | [_0027_RemoveElement](src/neetcode250/_01_arrays_hashing/_0027_RemoveElement.java) |
| 36 | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | Medium | Arrays & Hashing | [_0036_ValidSudoku](src/neetcode250/_01_arrays_hashing/_0036_ValidSudoku.java) |
| 36 | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | Medium | Arrays & Hashing | [_0036_ValidSudokuV2](src/neetcode250/_01_arrays_hashing/_0036_ValidSudokuV2.java) |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Medium | Arrays & Hashing | [_0049_GroupAnagrams](src/neetcode250/_01_arrays_hashing/_0049_GroupAnagrams.java) |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Medium | Arrays & Hashing | [_0049_GroupAnagramsOpt](src/neetcode250/_01_arrays_hashing/_0049_GroupAnagramsOpt.java) |
| 75 | [Sort Colors](https://leetcode.com/problems/sort-colors/) | Medium | Arrays & Hashing | [_0075_SortColors](src/neetcode250/_01_arrays_hashing/_0075_SortColors.java) |
| 122 | [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Arrays & Hashing | [_0122_BestTimeToBuyAndSellStockII](src/neetcode250/_01_arrays_hashing/_0122_BestTimeToBuyAndSellStockII.java) |
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium | Arrays & Hashing | [_0128_LongestConsecutiveSequence](src/neetcode250/_01_arrays_hashing/_0128_LongestConsecutiveSequence.java) |
| 169 | [Majority Element](https://leetcode.com/problems/majority-element/) | Easy | Arrays & Hashing | [_0169_MajorityElement](src/neetcode250/_01_arrays_hashing/_0169_MajorityElement.java) |
| 238 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | Medium | Arrays & Hashing | [_0238_ProductOfArrayExceptSelf](src/neetcode250/_01_arrays_hashing/_0238_ProductOfArrayExceptSelf.java) |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | Easy | Arrays & Hashing | [_0242_ValidAnagram](src/neetcode250/_01_arrays_hashing/_0242_ValidAnagram.java) |
| 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Medium | Arrays & Hashing | [_0347_TopKFrequentElements](src/neetcode250/_01_arrays_hashing/_0347_TopKFrequentElements.java) |
| 912 | [Sort an Array](https://leetcode.com/problems/sort-an-array/) | Medium | Arrays & Hashing | [_0912_SortAnArray](src/neetcode250/_01_arrays_hashing/_0912_SortAnArray.java) |
| 15 | [3Sum](https://leetcode.com/problems/3sum/) | Medium | Two Pointers | [_0015_ThreeSum](src/neetcode250/_02_two_pointers/_0015_ThreeSum.java) |
| 18 | [4Sum](https://leetcode.com/problems/4sum/) | Medium | Two Pointers | [_0018_FourSum](src/neetcode250/_02_two_pointers/_0018_FourSum.java) |
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Sliding Window | [_0121_BestTimeToBuyAndSellStock](src/neetcode250/_03_sliding_window/_0121_BestTimeToBuyAndSellStock.java) |
| 5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | 1-D Dynamic Programming | [_0005_LongestPalindromicSubstring](src/neetcode250/_13_dp_1d/_0005_LongestPalindromicSubstring.java) |
| 13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Easy | Math & Geometry | [_0013_RomanToInteger](src/neetcode250/_18_math_geometry/_0013_RomanToInteger.java) |

## LeetCode (not on NeetCode 250) (2 files)

| # | Problem | Difficulty | Topic | Solution |
|---|---|---|---|---|
| 16 | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | Medium | Two Pointers | [_0016_ThreeSumClosest](src/leetcode/_02_two_pointers/_0016_ThreeSumClosest.java) |
| 12 | [Integer to Roman](https://leetcode.com/problems/integer-to-roman/) | Medium | Math & Geometry | [_0012_IntegerToRoman](src/leetcode/_18_math_geometry/_0012_IntegerToRoman.java) |
