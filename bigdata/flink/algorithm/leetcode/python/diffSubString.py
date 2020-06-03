class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
      words = set([])
      index1, index2, max_len = 0, 0, 0
      length = len(s)
      while index1 < length and index2 < length:
        if s[index2] not in words:
          words.add(s[index2])
          index2 += 1
          max_len = max_len if max_len > index2 - index1 else index2 - index1
        else:
          words.remove(s[index1])
          index1 += 1
          
          
      
      return max_len
     
      

if __name__ == "__main__":
    s = Solution()
    r = s.lengthOfLongestSubstring("abbabadcec")
    print(r)

