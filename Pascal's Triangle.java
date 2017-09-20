/*
118. Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

//该题算是中等难度，主要考察对List的使用，最叫人拍手叫绝在：j<row.size()-1
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for(int i=0;i<numRows;i++)
    {
        row.add(0, 1);
        for(int j=1;j<row.size()-1;j++)
            row.set(j, row.get(j)+row.get(j+1));
        allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;
}


/*
119. Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<Integer>();
    for (int i = 0; i <= rowIndex; i++) {
        row.add(0,1);
        for (int j = 1; j < row.size()-1; j++) 
            row.set(j,row.get(j) + row.get(j+1));
    }
    return row;
}
