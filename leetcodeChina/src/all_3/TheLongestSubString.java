package all_3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zwxbest on 2018/3/7.
 */
public class TheLongestSubString {

    @Test
    public void main() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.lengthOfLongestSubstring(""), 0);
        Assert.assertEquals(solution.lengthOfLongestSubstring("abcabcd"), 4);
        Assert.assertEquals(solution.lengthOfLongestSubstring("abcabcabcabcdabcde"), 5);
        Assert.assertEquals(solution.lengthOfLongestSubstring("bbbbbbb"), 1);
        Assert.assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
        Assert.assertEquals(solution.lengthOfLongestSubstring("abcabcbbdefd"), 4);
        Assert.assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
        Assert.assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
        Assert.assertEquals(solution.lengthOfLongestSubstring("dvdf"), 3);
        Assert.assertEquals(solution.lengthOfLongestSubstring("anviaj"), 5);
    }

}

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start = 0, end = 1;
        int maxLength = 1;
        int cursize = 1;
        if(s.equals(""))
            return 0;
        while (start + cursize - 1 < s.length() - 1)//不应该用maxlength
        {
            String cur = s.substring(start, end);
            int pos = cur.indexOf(s.charAt(end));
            if (pos == -1) {
                cursize++;

                if (maxLength < cursize)
                    maxLength = cursize;

            } else {
                start += pos + 1;//位置不对，当前并没有包括end
                cursize = end - start + 1;
            }
            end++;
        }

        return maxLength;

    }

//    public String getString(String s,int startindex,int endindex)
//    {
//        StringBuilder sb=new StringBuilder();
//        for(int i=startindex;i<=endindex;i++)
//    }

}
